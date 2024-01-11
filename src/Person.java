import java.util.Locale;
import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    /*
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um númeto inteiro: ");
        int n = sc.nextInt();
        Person[] people = new Person[n];

        for (int i=0; i< people.length; i++){
            System.out.println("Digite seus dados: ");
            System.out.println("Nome: ");
            String name = sc.next();
            System.out.println("Idade: ");
            int age = sc.nextInt();
            System.out.println("Altura: ");
            double height = sc.nextDouble();
            people[i] = new Person(name, age, height);


        }
        double sumHeight = 0.0;
        int countUnder16 = 0;

        for (Person person : people) {
            sumHeight += person.getHeight();
            if (person.getAge() < 16) {
                countUnder16++;
                System.out.println(person.getName());
            }
        }

        double averageHeight = sumHeight / people.length;
        double percentageUnder16 = (double) countUnder16 / people.length * 100;

        System.out.printf("Altura média: %.2f%n", averageHeight);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", percentageUnder16);


        sc.close();

    }*/
}
