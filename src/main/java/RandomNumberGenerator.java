import java.util.Scanner;
import java.util.stream.LongStream;

public class RandomNumberGenerator {
    private void generate() {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long c = in.nextLong();
        long m = in.nextLong();
        LongStream.iterate(6, n -> 1 * ((a * n + c) % m))
                .limit(20)
                .forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        rng.generate();
    }
}