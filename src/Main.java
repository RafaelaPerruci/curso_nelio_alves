
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        BankAccount b1;


        System.out.println("Enter the number of your bank account: ");
        int numberAccount = sc.nextInt();

        System.out.println("Enter your name: ");
        String holder = sc.next();

        System.out.println("Do you wanna do a initial deposit(y/n)? ");
        char option = sc.next().charAt(0);
        if (option == 'y'){
            System.out.println("Enter the value of initial deposit: ");
            double deposit = sc.nextDouble();
            b1 = new BankAccount(numberAccount, holder, deposit);
            System.out.println(b1);
        }else {
            b1 = new BankAccount(numberAccount, holder);
            System.out.println(b1);;
        }


        sc.close();

    }
}