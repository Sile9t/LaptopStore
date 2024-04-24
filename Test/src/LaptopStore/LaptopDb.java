package LaptopStore;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LaptopDb {
    private static Scanner _scan = new Scanner(System.in);
    private static Set<Laptop> _setOfLaptops = new HashSet<>();
    
    private static String[] manufacturers = Enums.manufacturers;
    private static String[] series = Enums.series;
    private static String[] oses = Enums.oses;

    public Set<Laptop> InitDefault(){
        for(int i = 0; i < 20; i++){
            Laptop laptop1 = new Laptop();
            _setOfLaptops.add(laptop1);
        }
        return _setOfLaptops;
    }
    public boolean Add(Laptop l){
        return _setOfLaptops.add(l);
    }
    public boolean Remove(Laptop l){
        return _setOfLaptops.remove(l);
    }
    public void Print(){
        System.out.println("Store assortment:");
        for (Laptop l : _setOfLaptops){
            System.out.println(l);
        }
    }
    public void printArray(String[] arr){
        System.out.print("[ ");
        for (String el : arr) {
            System.out.print(el+" ");
        }

        System.out.println("None ]");
    }
    public String setManuf(){
        System.out.println("Enter a number of manufacturer");
        printArray(manufacturers);
        int num = Integer.parseInt(_scan.nextLine());
        if (num > 0 && num <= manufacturers.length){
            return manufacturers[num-1];
        }
        return "None";
    }
    public String setSeries(){
        System.out.println("Enter a number of series");
        printArray(series);
        int num = Integer.parseInt(_scan.nextLine());
        if (num > 0 && num <= series.length){
            return series[num-1];
        }
        return "None";
    }
    public String setOs(){
        System.out.println("Enter a number of OS");
        printArray(oses);
        int num = Integer.parseInt(_scan.nextLine());
        if (num > 0 && num <= oses.length){
            return oses[num-1];
        }
        return "None";
    }
    public void filterAndPrint(){
        Set<Laptop> filtered = new HashSet<>(_setOfLaptops);
        System.out.println("Enter your filter values for options:");
        String manuf = setManuf();
        if (manuf != "None") filtered.removeIf(l -> l.getManuf() != manuf);
        String series = setSeries();
        if (series != "None") filtered.removeIf(l -> l.getSeries() != series);
        String os = setOs();
        if (os != "None") filtered.removeIf(l -> l.getOs() != os);
        System.out.println("Enter min ram volume:");
        int ram = Integer.parseInt(_scan.nextLine());
        filtered.removeIf(l -> (l.getRam() < ram));
        System.out.println("Enter min ssd volume:");
        int ssd = Integer.parseInt(_scan.nextLine());
        filtered.removeIf(l -> l.getSsd() < ssd);
        System.out.println("Enter min hdd volume:");
        int hdd = Integer.parseInt(_scan.nextLine());
        filtered.removeIf(l -> l.getHdd() < hdd);
        System.out.println("Filtered assortment:");
        for (Laptop l : filtered){
            System.out.println(l);
        }
    }
}
