package br.com.salarycalculation.entities;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Departament departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){

    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);

    }
    public void removeContract(HourContract contract){
        contracts.removeIf(x -> x.equals(contract));
    }
    public double income(int year, int month){
        double sum = baseSalary;
        for(HourContract c : contracts){
            LocalDate contractDate = c.getDate();
            int cMonth = contractDate.getMonthValue();
            int cYear = contractDate.getYear();
            if (cYear == year && cMonth == month){
                sum += c.totalValue();
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Worker: " + name + '\'' +
                ", Level: " + level +
                ", Salary base:" + baseSalary +
                ", Department: " + departament +
                ", Contracts: " + contracts;
    }

}
