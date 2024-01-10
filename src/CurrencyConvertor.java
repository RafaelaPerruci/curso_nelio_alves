public class CurrencyConvertor {

    public static final double IOF_PERCENTAGE = 0.06;
    public static final double DOLAR = 4.12;

    public static double convCurrency(double value) {
        double iof = (value * DOLAR * IOF_PERCENTAGE);
        return (value * DOLAR) + iof;

    }
}