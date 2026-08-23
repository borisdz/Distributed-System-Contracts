package mk.ukim.finki.ds.contracts.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderStatusUpdatedEvent {
    public static final int CURRENT_VERSION = 1;

    public enum Status {
        PLACED,
        CHECKING,
        AVAILABLE,
        UNAVAILABLE,
        TIMEOUT,
        FAILURE
    }

    private String eventId;
    private int eventVersion;
    private Instant occurredAt;
    private String correlationId;
    private String orderId;
    private Status status;
    private String reason;
}
