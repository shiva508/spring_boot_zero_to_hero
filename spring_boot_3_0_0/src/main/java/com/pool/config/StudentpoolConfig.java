package com.pool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.pool.service.JsonPlaceHolderService;

@Configuration
public class StudentpoolConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public JsonPlaceHolderService holderService() {
        WebClient webClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                .build();
        JsonPlaceHolderService holderService = factory.createClient(JsonPlaceHolderService.class);
        return holderService;
    }
}
