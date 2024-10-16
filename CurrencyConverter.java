import java.util.Scanner;
public class CurrencyConverter {

    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.75;
    private static final double USD_TO_RUB = 100.0;
    private static final double USD_TO_JPY = 110.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму в долларах США (USD): ");
        double amountInUSD = scanner.nextDouble();

        double amountInEUR = convertCurrency(amountInUSD, USD_TO_EUR);
        double amountInGBP = convertCurrency(amountInUSD, USD_TO_GBP);
        double amountInRUB = convertCurrency(amountInUSD, USD_TO_RUB);
        double amountInJPY = convertCurrency(amountInUSD, USD_TO_JPY);

        System.out.println("Конвертированная сумма:");
        System.out.printf("%.2f USD = %.2f EUR\n", amountInUSD, amountInEUR);
        System.out.printf("%.2f USD = %.2f GBP\n", amountInUSD, amountInGBP);
        System.out.printf("%.2f USD = %.2f RUB\n", amountInUSD, amountInRUB);
        System.out.printf("%.2f USD = %.2f JPY\n", amountInUSD, amountInJPY);

        scanner.close();
    }

    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
