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
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.println("Date (DD/MM/YYYY): ");
            LocalDate contractDate = LocalDate.parse(sc.next(), sdf);
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String inputMonthYear = sc.next();
        String[] monthYear = inputMonthYear.split("/");
        int month = Integer.parseInt(monthYear[0]);
        int year = Integer.parseInt(monthYear[1]);
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartament().getDepartmentName());
        System.out.println("Income for " + inputMonthYear + ": " + String.format("%.2f", worker.income(year, month)));


        sc.close();

    }
}
