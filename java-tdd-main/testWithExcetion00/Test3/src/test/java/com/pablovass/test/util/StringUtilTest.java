package com.pablovass.test.util;


import org.junit.Assert;
import org.junit.Test;


public class StringUtilTest {
    @Test
    public  void testReapeat_once(){
        Assert.assertEquals("hola",StringUtil.repeat("hola",1));
    }
    @Test
    public  void testReapeatMany(){
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3));
    }
    @Test
    public  void Reapeat_zero_times(){
        Assert.assertEquals("",StringUtil.repeat("hola",0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StringUtil.repeat("hola",-1);
    }
}