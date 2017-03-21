package bsuir.by.labWord2.modules;

/**
 * Created by Сергей on 18.03.2017.
 */
public enum Product {
    MILK("Milk"),
    FISH("Fish"),
    MEAT("Meat"),
    OIL("Oil"),
    BREAD("Bread"),
    ICE_CREAM("Ice-cream"),
    WATER("WATER"),
    SUGAR("Sugar"),
    CAKE("Cake");




    private String product;

    /**
     * get String name of Product
     * @return name of product
     */
    public String getProduct() {
        return product;
    }

    Product(String product) {
        this.product = product;
    }
}
