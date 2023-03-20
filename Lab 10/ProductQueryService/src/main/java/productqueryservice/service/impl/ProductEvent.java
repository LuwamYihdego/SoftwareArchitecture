package productqueryservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import productqueryservice.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {
    private String event;
    private Product product;
}
