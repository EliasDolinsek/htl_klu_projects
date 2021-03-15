import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<BitcoinPrice> bitcoinPrices = readPrices("btc.csv");
        analyzePrices(bitcoinPrices, 2017);
    }

    private static List<BitcoinPrice> readPrices(String filename) throws IOException {
        List<BitcoinPrice> bitcoinPrices = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replace("\uFEFF", "");
            String[] data = line.split(";");

            try {
                LocalDate date = LocalDate.parse(data[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                float price = Float.parseFloat(data[1]);
                bitcoinPrices.add(new BitcoinPrice(date, price));
            } catch (DateTimeParseException e) {
                // Invalid line data (title)
            }
        }

        return bitcoinPrices;
    }

    private static void analyzePrices(List<BitcoinPrice> bitcoinPrices, int year) throws IOException {
        bitcoinPrices.sort((o1, o2) -> (int) (o1.getPrice() * 100 - o2.getPrice() * 100));

        BufferedWriter writer = new BufferedWriter(new FileWriter("Bitcoin_Result.txt"));
        writer.write("Number of analyzed values: " + bitcoinPrices.size() + "\n");

        BitcoinPrice lowestPrice = bitcoinPrices.get(0);
        BitcoinPrice highestPrice = bitcoinPrices.get(bitcoinPrices.size() - 1);

        writer.write("Lowest price: " + lowestPrice + "\n");
        writer.write("Highest price: " + highestPrice + "\n");

        LocalDate tenDaysBeforeLowestPriceDate = lowestPrice.getDate().minusDays(10);
        LocalDate tenDaysBeforeHighestPriceDate = highestPrice.getDate().minusDays(10);

        Optional<BitcoinPrice> tenDaysBeforeLowestPrice = bitcoinPrices
                .stream()
                .filter(bitcoinPrice -> bitcoinPrice.getDate()
                        .equals(tenDaysBeforeLowestPriceDate))
                .findFirst();

        Optional<BitcoinPrice> tenDaysBeforeHighestPrice = bitcoinPrices
                .stream()
                .filter(bitcoinPrice -> bitcoinPrice.getDate()
                        .equals(tenDaysBeforeHighestPriceDate))
                .findFirst();

        writer.write("Price 10 days before lowest price: " + tenDaysBeforeLowestPrice.orElse(null) + "\n");
        writer.write("Price 10 days before highest price: " + tenDaysBeforeHighestPrice.orElse(null) + "\n");

        double totalPrice = 0;
        List<BitcoinPrice> yearFilteredPrices = bitcoinPrices
                .stream()
                .filter(bitcoinPrice -> bitcoinPrice.getDate().getYear() == year)
                .collect(Collectors.toList());

        for (BitcoinPrice bitcoinPrice : yearFilteredPrices) {
            totalPrice += bitcoinPrice.getPrice();
        }

        String averagePrice = String.format(Locale.ENGLISH, "%.2f", totalPrice / yearFilteredPrices.size());
        writer.write("Average for year " + year + ": " + averagePrice + "€\n");
        writer.close();
    }

}
