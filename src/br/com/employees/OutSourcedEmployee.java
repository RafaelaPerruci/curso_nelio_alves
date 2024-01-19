package br.com.employees;

public class OutSourcedEmployee extends Employee{
    private Double aditionalCharge;

    public OutSourcedEmployee(){
        super();
    }
    public OutSourcedEmployee(String name, Integer hours, Double valuePerHour, Double aditionalCharge) {
        super(name, hours, valuePerHour);
        this.aditionalCharge = aditionalCharge;
    }

    public Double getAditionalCharge() {
        return aditionalCharge;
    }

    public void setAditionalCharge(Double aditionalCharge) {
        this.aditionalCharge = aditionalCharge;
    }
    @Override
    public double payment(){
        return super.payment() + aditionalCharge * 1.10;
    }
}
