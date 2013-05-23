package eu.solidcraft.testkata.domain.biller;

import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class Product {
    private ObjectId id;
    private String code;
    private BigDecimal price;

    public Product(String code, BigDecimal price) {
        this.code = code;
        this.price = price;
    }
}
