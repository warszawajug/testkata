package eu.solidcraft.testkata.domain.biller;

import org.bson.types.ObjectId;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Biller {
    private ObjectId id;
    private String code;
    private String name;
    private List<Product> products = newArrayList();

    private Biller() {
    }

    public Biller(String code, String name, List<Product> products) {
        this.code = code;
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }
}
