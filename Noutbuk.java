import java.util.*;
import java.util.stream.Collectors;

class Noutbuk {
    private int ram; // ОЗУ
    private int storage; // ОбЪем ЖД
    private String os; // Операционная система
    private String color; // Цвет

    public Noutbuk(int ram, int storage, String os, String color) {
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public static List<Noutbuk> filterNoutbuks(List<Noutbuk> noutbuks, Map<String, Object> criteria) {
        return noutbuks.stream().filter(noutbuk -> {
            boolean matches = true;
            if(criteria.containsKey("ram")) {
                matches &= noutbuk.getRam() >= (int) criteria.get("ram");
            }
            if(criteria.containsKey("storage")) {
                matches &= noutbuk.getStorage() >= (int) criteria.get("storage");
            }
            if(criteria.containsKey("os")) {
                matches &= noutbuk.getOs().equalsIgnoreCase((String) criteria.get("os"));
            }
            if(criteria.containsKey("color")) {
                matches &= noutbuk.getColor().equalsIgnoreCase((String) criteria.get("color"));
            }
            return matches;
        }).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Noutbuk{" +
                "ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

