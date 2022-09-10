package com.pablovass.test.discounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorTest {



    @Test
    public void total_zero_when_there_are_prices() {
        PriceCalculator calculator =new PriceCalculator();
        assertThat(calculator.getTotal(),is(0.0));
    }

    @Test
    public void total_is_the_sum_of_price() {
        PriceCalculator calculator= new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        assertThat(calculator.getTotal(),is(25.7));
    }
    @Test
    public void  apply_discount_to_price(){
        PriceCalculator calculator= new PriceCalculator();

        calculator.addPrice(12.5);
        calculator.addPrice(17.5);
        calculator.setDiscount(50);
        assertThat(calculator.getTotal(),is(15.0));
    }


}