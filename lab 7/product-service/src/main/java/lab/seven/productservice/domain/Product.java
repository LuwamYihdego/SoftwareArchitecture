package lab.seven.productservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
   private  int productNumber;
   private  String productName;
    private int countStock;

    public Product(int productNumber, String productName) {
        this.productNumber = productNumber;
        this.productName = productName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public int getCountStock() {
        return countStock;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCountStock(int countStock) {
        this.countStock = countStock;
    }
}
