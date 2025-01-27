package com.apiconsumer.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;

import java.io.File;



import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;


@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() throws Exception {
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(new File("src/main/resources/truststore.jks"), "truststore-password".toCharArray())
                .build();

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

        HttpClient httpClient = (HttpClient)HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();
      

        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
