package br.com.productestype;

public class ImportedProduct extends Product{
    private Double customFee;

    public ImportedProduct(){
        super();
    }

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public Double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(Double customFee) {
        this.customFee = customFee;
    }
    public Double totalPrice(){
        return this.price += customFee;

    }
    @Override
    public String priceTag(){
        return getName().substring(0,1).toUpperCase()
                + " $ "
                + String.format("%.2f", totalPrice())
                + " (Customs fee: $ "
                + String.format("%.2f", customFee)
                + ")";
    }
}
