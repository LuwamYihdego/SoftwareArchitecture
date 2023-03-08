package shoppingcart.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class Product {
    @Id
    private String productNumber;
    private String description;
    private Double price;

}
