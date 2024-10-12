import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NameReader {
    private String[] list;

    public void readInput(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        list = line.split(", ");
        in.close();
    }

    public void filterList(){
        readInput();
        List<String> flist = Arrays.asList(list);
        final String[] res = {new String()};
        flist
                .stream()
                .filter(s -> {
                    int num = Integer.parseInt(s.split(". ")[0]);
                    return num%2==1;
                })
                .forEach(s ->{
                    res[0] += ", " + s;
                });
        String result = res[0].substring(2, res[0].length());
        System.out.println(result);
    }

    public static void main(String[] args) {
        NameReader nr = new NameReader();
        nr.filterList();
        //1. hgbkj, 2. kjkb, 3. juhkj, 4. jhk, 5. jhnk, 6. jhgbkj, 7. rdgg, 8. jvg, 12. jhgvbj, 13. jkj, 151. uhgiuk
    }
}
