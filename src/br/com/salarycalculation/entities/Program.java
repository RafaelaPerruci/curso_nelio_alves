package br.com.salarycalculation.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
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
        String workerLevel = sc.nextLine().toUpperCase();
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
