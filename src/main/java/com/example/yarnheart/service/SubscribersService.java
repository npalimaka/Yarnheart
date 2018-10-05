package com.example.yarnheart.service;

import com.example.yarnheart.model.Subscribers;

public interface SubscribersService {

    void save(Subscribers subscriber);
    void unsubscribe(Subscribers subscriber);
}
