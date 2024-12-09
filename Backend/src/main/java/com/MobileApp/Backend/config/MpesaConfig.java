package com.MobileApp.Backend.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpesaConfig {

    // Consumer credentials (provided by Safaricom when you register for Daraja API)
    @Value("${mpesa.consumer.key}")
    private String consumerKey;

    @Value("${mpesa.consumer.secret}")
    private String consumerSecret;

    // Mpesa shortcode (provided by Safaricom for your business)
    @Value("${mpesa.shortcode}")
    private String shortcode;

    // The passkey for STK push (provided by Safaricom)
    @Value("${mpesa.passkey}")
    private String passkey;

    // Base URL for Mpesa API (either sandbox or production)
    @Value("${mpesa.baseurl}")
    private String baseUrl;

    // Callback URL (your endpoint where Mpesa sends the response after payment)
    @Value("${mpesa.callback.url}")
    private String callbackUrl;

    // Getters for each of the configuration properties
    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getShortcode() {
        return shortcode;
    }

    public String getPasskey() {
        return passkey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }
}

