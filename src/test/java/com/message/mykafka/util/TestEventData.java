package com.message.mykafka.util;

import java.util.UUID;

import com.message.mykafka.custommessage.OrderCreated;

public class TestEventData {

	public static OrderCreated buildOrderCreatedEvent(UUID orderId, String item) {
		
		return OrderCreated.builder()
				.orderId(orderId)
				.item(item)
				.build();
	}
}
