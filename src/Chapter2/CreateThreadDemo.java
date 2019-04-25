package Chapter2;

import java.sql.SQLOutput;
import java.util.stream.IntStream;

public class CreateThreadDemo {
    private final static String PREFIX = "ALEX-";
    public static void main(String[] args) {
//        IntStream.range(0,5).boxed().map(
//                i -> new Thread(() -> System.out.println(Thread.currentThread().getName()))).
//                forEach(Thread::start);
        IntStream.range(0,5).mapToObj(CreateThreadDemo::createThread).forEach(Thread::start);

    }
    private static Thread createThread(final int intName){
        return new Thread(
                () -> System.out.println(Thread.currentThread().getName()),PREFIX + intName
        );
    }
}
