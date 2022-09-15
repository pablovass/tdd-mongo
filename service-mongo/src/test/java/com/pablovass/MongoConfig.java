package com.pablovass;

import com.mongodb.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.ImmutableMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@TestConfiguration
public class MongoConfig {
    private static final String CONNECTION_STRING = "mongodb://%s:%d";

    @Value("${spring.data.mongodb.host:localhost}")
    String ip;
    @Value("${spring.data.mongodb.port:27017}")
    int port;


    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        final MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, port)), "test");
        return mongoTemplate;

    }

    @Bean
    public MongodExecutable mongodExecutable() throws IOException {
        ImmutableMongodConfig mongodConfig = MongodConfig
                .builder()
                .isShardServer(true)
                .version(Version.Main.PRODUCTION)
                .net(new Net(ip, port, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        Object mongodExecutable = starter.prepare(mongodConfig);
        return (MongodExecutable) mongodExecutable;
    }

}