import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NoutbukStore {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        List<Noutbuk> noutbuks = new ArrayList<>();
        noutbuks.add(new Noutbuk(8, 256, "Windows", "Black"));
        noutbuks.add(new Noutbuk(16, 512, "Windows", "Silver"));
        noutbuks.add(new Noutbuk(16, 1024, "MacOS", "Gray"));
        // ... добавление других ноутбуков

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();
        
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ\n2 - Объем ЖД\n3 - Операционная система\n4 - Цвет");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ:");
                criteria.put("ram", scanner.nextInt());
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                criteria.put("storage", scanner.nextInt());
                break;
            case 3:
                System.out.println("Введите название операционной системы:");
                criteria.put("os", scanner.next());
                break;
            case 4:
                System.out.println("Введите цвет корпуса:");
                criteria.put("color", scanner.next());
                break;
            default:
                System.out.println("Некорректный ввод. Применяются стандартные критерии.");
                break;
        }

        List<Noutbuk> filteredNoutbuks = Noutbuk.filterNoutbuks(noutbuks, criteria);
        filteredNoutbuks.forEach(System.out::println);
    }
}