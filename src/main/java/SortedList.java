import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortedList {
    private String[] list;

    public void readInput(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        list = line.split(", ");
        in.close();
    }

    public void sortedList(){
        readInput();
        List<String> slist = Arrays.asList(list);

        slist
                .stream()
                .map(s -> s.toUpperCase())
                .sorted((s1, s2) -> s2.compareTo(s1))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        SortedList sl = new SortedList();
        sl.sortedList();
        //1. hgbkj, 2. kjkb, 3. juhkj, 4. jhk, 5. jhnk, 6. jhgbkj, 7. rdgg, 8. jvg, 12. jhgvbj, 13. jkj, 151. uhgiuk
    }
}
