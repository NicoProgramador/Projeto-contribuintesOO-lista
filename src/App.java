import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int N = sc.nextInt();

        for (int i=0; i<N; i++) {
            System.out.println("Digite os dados do " + (i+1) + "° contribuinte: ");
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();

            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();

            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();

            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
        
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));

            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            System.out.println();
            System.out.println("Resumo do " + (i+1) + "° contribuinte:");
            System.out.printf("Imposto bruto total: %.2f%n", list.get(i).grossTax());
            System.out.printf("Abatimento: %.2f%n", list.get(i).taxRebate());
            System.out.printf("Imposto devido: %.2f%n", list.get(i).netTax());
        }

        sc.close();
    }
}
