import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            sc.nextLine();
            String name = sc.nextLine();
            book.setName(name);

            double price = sc.nextDouble();
            book.setPrice(price);

            books[i] = book;
        }
        PriceComparator priceComparator = new PriceComparator();
        Arrays.sort(books, priceComparator);
        for (int i = 0; i < n; i++) {
            System.out.println(books[i]);
        }
    }
}
class Book {
    private String name;
    private double price;

    @Override
    public String toString() {
        return name + " " + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class PriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
