package LaptopStore;
import java.util.Scanner;

public class LaptopStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LaptopDb db = new LaptopDb();
        db.InitDefault();
        while(true){
            System.out.println("Enter key");
            System.out.println(" - 'p' to print laptops");
            System.out.println(" - 'f' to filter");
            System.out.println(" - 'q' to exit");
            String com = scanner.nextLine();
            if (com.equals("q")) break;
            if (com.equals("p")) db.Print();
            if (com.equals("f")) db.filterAndPrint();
        }
        scanner.close();
    }
}
