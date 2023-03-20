package productqueryservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockEvent {
    private String productNumber;
    private Integer quantity;
}
