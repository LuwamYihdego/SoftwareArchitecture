package productcommandservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import productcommandservice.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {
    private String event;
    private Product product;
}
