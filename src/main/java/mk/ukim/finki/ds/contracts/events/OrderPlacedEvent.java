package mk.ukim.finki.ds.contracts.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.ds.contracts.model.OrderItem;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlacedEvent {
    public static final int CURRENT_VERSION = 1;

    private String eventId;
    private int eventVersion;
    private Instant occurredAt;
    private String correlationId;
    private String orderId;
    private String customerId;
    private String customerRegion;
    private List<OrderItem> items;
}
