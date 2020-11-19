package com.Alcatraz.Client.Connectivity.Configuration;

import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class ClientConnectivityServicePublisher {
    private final Jedis jedis = new Jedis();

    public void publisher(String message){
        this.jedis.publish("ClientConnectivityService",message);
    }
}
