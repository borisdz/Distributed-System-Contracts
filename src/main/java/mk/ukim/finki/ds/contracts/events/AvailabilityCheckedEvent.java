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
public class AvailabilityCheckedEvent {
    public static final int CURRENT_VERSION = 1;

    private String eventId;
    private int eventVersion;
    private Instant occurredAt;
    private String correlationId;
    private String orderId;
    private String warehouseId;
    private String warehouseRegion;
    private boolean available;
    private int etaHours;
}
