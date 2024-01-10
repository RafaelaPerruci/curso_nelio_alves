public class Employee {
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name, double grossSalary, double tax) {
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }
    public Employee(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    public double netSalary(){
        return this.grossSalary - this.tax;
    }
    public double increasedSalary(double perc){
        double percentual = (this.grossSalary * perc) / 100;
        double total = this.grossSalary - percentual;
        return total;
    }

    @Override
    public String toString() {
        return  name + ", " +
                grossSalary + ", " +
                tax + ", " +
                String.format("$%.2f", netSalary());

    }
}
