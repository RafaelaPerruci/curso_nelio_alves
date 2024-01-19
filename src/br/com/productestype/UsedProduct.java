package br.com.productestype;

import java.time.LocalDate;

public class UsedProduct extends Product{
    private LocalDate manufatureDate;

    public UsedProduct(){
        super();
    }

    public UsedProduct(String name, Double price, LocalDate manufatureDate) {
        super(name, price);
        this.manufatureDate = manufatureDate;
    }

    public LocalDate getManufatureDate() {
        return manufatureDate;
    }

    public void setManufatureDate(LocalDate manufatureDate) {
        this.manufatureDate = manufatureDate;
    }
    @Override
    public String priceTag(){
        return manufatureDate + " " + super.priceTag();
    }
}
