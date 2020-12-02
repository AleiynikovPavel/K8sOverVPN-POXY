package com.testproxy.testproxy;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {

    @Value("${my.proxy.url}")
    public String url;
    @Value("${my.proxy.port}")
    public Integer port;


    @GetMapping("/client_ip")
    public JsonNode getIp() {
        RestTemplate restTemplate = new RestTemplateBuilder(new ProxyCustomizer(url, port)).build();
        return restTemplate.getForObject("http://api.ipify.org?format=json", JsonNode.class);
    }

}
