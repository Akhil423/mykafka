package com.message.mykafka.service;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.message.mykafka.custommessage.OrderCreated;
import com.message.mykafka.util.TestEventData;

class DispatchServiceTest {

	private DispatchService dispatchService;
	
	@BeforeEach
	void setUp() throws Exception {
		dispatchService = new DispatchService();
	}

	@Test
	void testProcess() {
		OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(randomUUID(),randomUUID().toString());

		dispatchService.process(testEvent);
	}

}
