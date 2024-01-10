public class Product {
    private String name;
    private double price;
    private int quantity = 0;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, Total: $ "
                + String.format("%.2f", totalStock());
    }
    public void addProduct(int quantity){
        this.quantity += quantity;
    }
    public void removeProduct(int quantity){
        if(this.quantity >= quantity){
            this.quantity -= quantity;
        }else{
            System.out.println("Error, quantity of demanded product is bigger than quantity available in stock.");
        }
    }
    public double totalStock(){
        return this.price * this.quantity;
    }
}
