import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberFinder {

    public void numberList(String[] array){
        String line = Arrays.toString(array);
        String[] nums = line.substring(1, line.length()-1).split(", ");
        List<String> slist = Arrays.asList(nums);

        String list = slist
                .stream()
                .map(Integer::parseInt)
                .sorted()
                .map(i -> i.toString())
                .collect(Collectors.joining(", "));
        System.out.println(list);
    }

    public static void main(String[] args) {
        NumberFinder nf = new NumberFinder();
        String[] array = {"1, 2, 0", "4, 5", "13, 41"};
        nf.numberList(array);
    }
}
