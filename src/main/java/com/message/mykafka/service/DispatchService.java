package com.message.mykafka.service;

import org.springframework.stereotype.Service;

import com.message.mykafka.custommessage.OrderCreated;

@Service
public class DispatchService {

	public void process(OrderCreated payload) {
		//no-op
	}
}
