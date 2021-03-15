import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BitcoinPrice implements Comparable {

    private final LocalDate date;
    private final float price;

    public BitcoinPrice(LocalDate date, float price) {
        this.date = date;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Datum: " + date.format(DateTimeFormatter.ISO_DATE) + " Price: " + price + "€";
    }

    @Override
    public int compareTo(Object o) {
        return (int) (((BitcoinPrice) o).price * 100 - price * 100);
    }
}
