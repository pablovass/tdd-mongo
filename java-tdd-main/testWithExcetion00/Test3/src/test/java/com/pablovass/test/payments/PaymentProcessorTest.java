package com.pablovass.test.payments;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {
    @Test
    public void payment_is_correct() {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);// COMO NO TENEMOS LA PASARELA DE PAGO LA MOKEAMOS
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        PaymentProcessor paymentProcessor =new  PaymentProcessor(paymentGateway);

        //boolean result= paymentProcessor.makePayment(1000);
        assertTrue(paymentProcessor.makePayment(1000));

    }
    @Test
    public void payment_is_wrong() {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);// COMO NO TENEMOS LA PASARELA DE PAGO LA MOKEAMOS
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        PaymentProcessor paymentProcessor =new  PaymentProcessor(paymentGateway);

        //boolean result= paymentProcessor.makePayment(1000);
        assertFalse(paymentProcessor.makePayment(1000));

    }
}