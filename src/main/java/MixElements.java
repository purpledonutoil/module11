import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MixElements {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Iterator<T> outIterator = new Iterator<T>() {
            boolean switcher = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element;
                if (switcher) {
                    element = firstIterator.next();
                } else {
                    element = secondIterator.next();
                }
                switcher = !switcher;
                return element;
            }
        };

        return StreamSupport.stream(((Iterable<T>) () -> outIterator).spliterator(), false);
    }

    public static void main(String[] args) {
        MixElements me = new MixElements();
        Stream<Integer> arrayStream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> arrayStream2 = Stream.of(7, 8, 9, 0);
        System.out.println(me.zip(arrayStream1, arrayStream2).toList());
    }
}
