package stockcommandservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    private String productNumber;
    private Integer quantity;
}
