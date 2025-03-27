package org.example;

public class Producto implements Comparable<Producto>{

    private int SKU;
    private float priceR; //price retail
    private float priceC; //price current
    private String name;
    private String category;

    public Producto(int SKU, float priceR, float priceC, String name, String category) {
        this.SKU = SKU;
        this.priceR = priceR;
        this.priceC = priceC;
        this.name = name;
        this.category = category;
    }


    //getters
    public int getSKU() {
        return SKU;
    }
    public float getPriceR() {
        return priceR;
    }
    public float getPriceC() {
        return priceC;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }

    public int compareTo(Producto p) {
        if (this.SKU > p.SKU) {
            return 1;
        }
        if (this.SKU < p.SKU) {
            return -1;
        }
        return 0;
    }

}
