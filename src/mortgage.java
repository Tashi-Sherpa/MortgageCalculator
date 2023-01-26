import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {

    private static final int MONTHS_IN_A_YEAR = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Principal Amount:");
        double principal = scanner.nextDouble();

        System.out.println("Annual Interest Rate:");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("Term in years:");
        int termInYears = scanner.nextInt();

        scanner.close();

        float monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR;
        int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;

        // Formula: M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
        double monthlyPayment = principal
                * ((monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                        ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1));

        System.out.println("Your Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));

        System.out.println("The total payback amount: "
                + NumberFormat.getCurrencyInstance().format(monthlyPayment * numberOfPayments));

    }
}
