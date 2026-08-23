package mk.ukim.finki.ds.contracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.ds.contracts.events.OrderStatusUpdatedEvent;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderStatusUpdatedEventTest {
    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @Test
    void serializesAndDeserializesAllLifecycleStates() throws Exception {
        for (OrderStatusUpdatedEvent.Status status : OrderStatusUpdatedEvent.Status.values()) {
            OrderStatusUpdatedEvent event = new OrderStatusUpdatedEvent(
                    "event-1", 1, Instant.parse("2026-08-23T12:00:00Z"),
                    "correlation-1", "order-1", status, "reason");

            String json = objectMapper.writeValueAsString(event);
            OrderStatusUpdatedEvent decoded = objectMapper.readValue(json, OrderStatusUpdatedEvent.class);

            assertEquals(status, decoded.getStatus());
            assertEquals("order-1", decoded.getOrderId());
            assertEquals(event.getOccurredAt(), decoded.getOccurredAt());
        }
    }

    @Test
    void reasonCanBeAbsentForNormalTransitions() throws Exception {
        OrderStatusUpdatedEvent event = new OrderStatusUpdatedEvent(
                "event-1", 1, Instant.now(), "correlation-1", "order-1",
                OrderStatusUpdatedEvent.Status.AVAILABLE, null);

        OrderStatusUpdatedEvent decoded = objectMapper.readValue(
                objectMapper.writeValueAsString(event), OrderStatusUpdatedEvent.class);

        assertNull(decoded.getReason());
    }
}
