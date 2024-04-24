package LaptopStore;
import java.util.Objects;
import java.util.Random;

public class Laptop {
    private int _id;
    private String _manufacturer;
    private String _series;
    private String _os;
    private int _ram;
    private int _ssd;
    private int _hdd;

    private static int count = 0;
    static Random random = new Random();
    public Laptop() {
        _id = count++;
        _manufacturer = Enums.manufacturers[random.nextInt(3)];
        _series = Enums.series[random.nextInt(1)];
        _os = Enums.oses[random.nextInt(1)];
        _ram = (random.nextInt(1) == 0)? 8 : 16;
        _ssd = (random.nextInt(1) == 0)? 512 : 1024;
        _hdd = (random.nextInt(1) == 0)? 1024 : 2048;
    }
    public Laptop(String manufact, String series, String os, int ram, int ssd, int hdd) {
        _id = count++;
        _manufacturer = manufact;
        _series = series;
        _os = os;
        _ram = ram;
        _ssd = ssd;
        _hdd = hdd;
    }
    public String getManuf(){
        return _manufacturer;
    }
    public String  getSeries(){
        return _series;
    }
    public String getOs(){
        return _os;
    }
    public int getRam(){
        return _ram;
    }
    public int getSsd(){
        return _ssd;
    }
    public int getHdd(){
        return _hdd;
    }
    @Override
    public String toString() {
        return String.format(
            "%d. Laptop '%s %s-series' OS: %s Ram: %dGb SSD: %dGb HDD: %dGb"
            , _id, _manufacturer, _series, _os, _ram, _ssd, _hdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _manufacturer, _series, _os, _ram, _ssd, _hdd);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return (_id == laptop._id)
            && (_manufacturer == laptop._manufacturer)
            && (_series == laptop._series)
            && (_os == laptop._os)
            && (_ram == laptop._ram)
            && (_ssd == laptop._ssd)
            && (_hdd == laptop._hdd);
    }
}
