package com.example.yarnheart.service;

import com.example.yarnheart.model.Subscribers;
import com.example.yarnheart.repository.SubscribersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscribersService {

    private SubscribersRepository subscribersRepository;

    @Autowired
    public SubscriberServiceImpl(SubscribersRepository subscribersRepository) {
        this.subscribersRepository = subscribersRepository;
    }

    @Override
    public void save(Subscribers subscriber) {
        subscribersRepository.save(subscriber);
    }

    @Override
    public void unsubscribe(Subscribers subscriber) {
        subscribersRepository.delete(subscriber);
    }
}
