package com.MobileApp.Backend.service;
//
//
//import com.MobileApp.Backend.config.MpesaConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.Base64;
//
//@Service
//public class MpesaService {
//
//    @Autowired
//    private MpesaConfig mpesaConfig;
//
//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    // Get Mpesa OAuth token
//    public String getAccessToken() {
//        String credentials = mpesaConfig.getConsumerKey() + ":" + mpesaConfig.getConsumerSecret();
//        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
//
//        return webClientBuilder.build()
//                .post()
//                .uri(mpesaConfig.getBaseUrl() + "/oauth/v1/generate?grant_type=client_credentials")
//                .header("Authorization", "Basic " + encodedCredentials)
//                .retrieve()
//                .bodyToMono(String.class)
//                .map(response -> {
//                    // Extract token from the response
//                    return response.split("\"access_token\":\"")[1].split("\"")[0];
//                })
//                .block();
//    }
//
//    // Initiate STK Push
//    public String initiateSTKPush(String phoneNumber, double amount, String accountReference, String transactionDesc) {
//        String token = getAccessToken();
//        String timestamp = String.valueOf(System.currentTimeMillis());
//        String password = Base64.getEncoder().encodeToString((mpesaConfig.getShortcode() +
//                mpesaConfig.getPasskey() + timestamp).getBytes());
//
//        String stkPushRequest = "{"
//                + "\"BusinessShortCode\":\"" + mpesaConfig.getShortcode() + "\","
//                + "\"Password\":\"" + password + "\","
//                + "\"Timestamp\":\"" + timestamp + "\","
//                + "\"TransactionType\":\"CustomerPayBillOnline\","
//                + "\"Amount\":\"" + amount + "\","
//                + "\"PartyA\":\"" + phoneNumber + "\","
//                + "\"PartyB\":\"" + mpesaConfig.getShortcode() + "\","
//                + "\"PhoneNumber\":\"" + phoneNumber + "\","
//                + "\"CallBackURL\":\"" + mpesaConfig.getCallbackUrl() + "\","
//                + "\"AccountReference\":\"" + accountReference + "\","
//                + "\"TransactionDesc\":\"" + transactionDesc + "\""
//                + "}";
//
//        return webClientBuilder.build()
//                .post()
//                .uri(mpesaConfig.getBaseUrl() + "/mpesa/stkpush/v1/processrequest")
//                .header("Authorization", "Bearer " + token)
//                .bodyValue(stkPushRequest)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
//}
import com.MobileApp.Backend.DTO.MpesaStkRequest;
import com.MobileApp.Backend.DTO.MpesaTokenResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MpesaService {

    private final String consumerKey = "W0pmY712MVuTuxTcu6JqHJ4fEJwWCZwk";
    private final String consumerSecret = "mcLoGXtoNGVtSNuC";
    private final String shortCode = "0704971637";
    private final String passkey = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
    private final String stkPushUrl = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
    private final String tokenUrl = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    private final String callbackUrl = "https://85cc-105-161-109-5.eu.ngrok.io/mobile-money/stk-transaction-result'";

    public String initiateStkPush(String phoneNumber, Double amount, String accountReference, String transactionDesc) {
        try {
            // Step 1: Generate access token
            String accessToken = getAccessToken();

            // Step 2: Prepare STK Push Request Payload
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String password = Base64.getEncoder().encodeToString((shortCode + passkey + timestamp).getBytes());

            MpesaStkRequest request = new MpesaStkRequest(
                    shortCode, // Business Short Code
                    password,
                    timestamp,
                    "CustomerPayBillOnline",
                    amount,
                    phoneNumber,
                    shortCode,
                    phoneNumber,
                    callbackUrl,
                    accountReference,
                    transactionDesc
            );

            // Step 3: Call M-Pesa STK Push API
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(accessToken);

            HttpEntity<MpesaStkRequest> entity = new HttpEntity<>(request, headers);
            ResponseEntity<String> response = restTemplate.exchange(stkPushUrl, HttpMethod.POST, entity, String.class);

            return response.getBody();

        } catch (Exception e) {
            throw new RuntimeException("Error initiating STK Push: " + e.getMessage(), e);
        }
    }

    private String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(consumerKey, consumerSecret);

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<MpesaTokenResponse> response = restTemplate.exchange(tokenUrl, HttpMethod.GET, entity, MpesaTokenResponse.class);

        return response.getBody().getAccessToken();
    }
}
