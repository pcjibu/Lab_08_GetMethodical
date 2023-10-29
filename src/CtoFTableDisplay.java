public class CtoFTableDisplay {
    public static void main(String[] args) {
        System.out.println("Celsius\tFahrenheit");

        for (int celsius = -100; celsius <= 100; celsius++) {
            double fahrenheit = CtoF(celsius);
            System.out.printf("%d\t%.2f%n", celsius, fahrenheit);
        }
    }

    public static double CtoF(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
}
