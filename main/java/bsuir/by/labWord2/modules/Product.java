package bsuir.by.labWord2.modules;

/**
 * Created by Сергей on 18.03.2017.
 */
public enum Product {
    MILK("Milk"),
    FISH("Fish"),
    MEAT("Meat"),
    OIL("Oil"),
    BREAD("Bread");




    private String product;

    public String getProduct() {
        return product;
    }

    Product(String product) {
        this.product = product;
    }
}
