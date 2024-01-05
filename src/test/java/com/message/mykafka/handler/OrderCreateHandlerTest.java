package com.message.mykafka.handler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static java.util.UUID.randomUUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.message.mykafka.custommessage.OrderCreated;
import com.message.mykafka.service.DispatchService;
import com.message.mykafka.util.TestEventData;

class OrderCreateHandlerTest {

	private OrderCreateHandler handler;
	
	private DispatchService dispatchServiceMock;
	
	@BeforeEach
	void setUp() throws Exception {
		
		dispatchServiceMock = mock(DispatchService.class);
		handler = new OrderCreateHandler(dispatchServiceMock);
	}

	@Test
	void testListen() {
		OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(randomUUID(),randomUUID().toString());
		handler.listen(testEvent);
		verify(dispatchServiceMock, times(1)).process(testEvent);
	}

}
