package com.message.mykafka.handler;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.message.mykafka.custommessage.OrderCreated;
import com.message.mykafka.service.DispatchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCreateHandler {

	private final DispatchService dispacthService;
	
	@KafkaListener(
			id = "orderConsumerClient",
			topics = "order.created",
			groupId = "dispatch.order.created.consumer"
	)
	public void listen(OrderCreated payload) {
		
		log.info("Received message: payload"+ payload);
		dispacthService.process(payload);
	}
}
