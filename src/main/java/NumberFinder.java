import java.util.Arrays;
import java.util.List;

public class NumberFinder {

    public void numberList(String[] array){
        String line = Arrays.toString(array);
        String[] nums = line.substring(1, line.length()-1).split(", ");
        List<String> slist = Arrays.asList(nums);
        final String[] res = {new String()};

        slist
                .stream()
                .map(Integer::parseInt)
                .sorted()
                .forEach(s ->{
                    res[0] += ", " + s;
                });
        String result = res[0].substring(2, res[0].length());
        System.out.println(result);
    }

    public static void main(String[] args) {
        NumberFinder nf = new NumberFinder();
        String[] array = {"1, 2, 0", "4, 5", "13, 41"};
        nf.numberList(array);
    }
}
