import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeTwo {
    private int id;
    private String name;
    private double salary;

    public EmployeeTwo(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double increaseSalary(double perc){
        this.salary += this.salary * perc / 100;
        return this.salary;
    }
    @Override
    public String toString() {
        return "Id:" + id +
                ", Name: " + name +
                ", Salary: " + salary;
    }

     public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many employees will be registered? ");
        int n = sc.nextInt();

        List<EmployeeTwo> list = new ArrayList<>();

        for (int i=0; i < n; i++){
            System.out.println("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Employee name: ");
            String name = sc.nextLine();
            System.out.println("Employee salary: ");
            double salary = sc.nextDouble();
            EmployeeTwo emp = new EmployeeTwo(id, name, salary);
            list.add(emp);
        }
        System.out.println();

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        EmployeeTwo emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        /*
         *A expressão  usa streams em Java para encontrar o primeiro objeto EmployeeTwo na lista list
         * cujo ID é igual ao valor fornecido (id). Se encontrado, o valor desse objeto é retornado e
         * atribuído à variável emp, caso contrário, emp recebe null. O uso de Optional ajuda a lidar
         * com a possibilidade de não encontrar um objeto correspondente, evitando NullPointerException.
         * */

        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println("List of employees: ");
        for (EmployeeTwo emps: list){
            System.out.println(emps.toString());
        }

        sc.close();
    }
}
