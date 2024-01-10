import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many dolars you want to bought? ");
        double value = sc.nextDouble();
        double total = CurrencyConvertor.convCurrency(value);

        System.out.printf("You will need R$%.2f reais. ", total);

        sc.close();

    }
}