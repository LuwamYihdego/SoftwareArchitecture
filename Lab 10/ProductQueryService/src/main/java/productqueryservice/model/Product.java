package productqueryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products_in_stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String productNumber;
    private String name;
    private Double price;
    private Integer numberInStock;
}
