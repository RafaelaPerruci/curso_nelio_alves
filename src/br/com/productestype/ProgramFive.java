package br.com.productestype;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramFive {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> list = new ArrayList<>();

        for (int i = 1; i<=n; i++){

            System.out.print("Common used, imported (c/u/i)? ");
            char ch = sc.next().toLowerCase().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preco: ");
            double price = sc.nextDouble();
            if (ch == 'c') {
                list.add(new Product(name, price));
            }
            else if (ch == 'u') {
                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));
            }
            else {
                System.out.print("Taxa de importacao: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("ETIQUETAS DE PRECO:");
        for(Product p : list){
            System.out.println(p.priceTag());
        }





       sc.close();
    }
}
