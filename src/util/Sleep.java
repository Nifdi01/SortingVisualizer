package util;
import static java.lang.Math.pow;

public class Sleep {
    public static void sleepFor(long nanoseconds) {
        long elapsedTime;
        final long startTime = System.nanoTime();
        do {
            elapsedTime = System.nanoTime() - startTime;
        } while (elapsedTime < nanoseconds);
    }

    public static long secondsToNano(long time) {
        return time * (long) pow(10, 9);
    }

    public static long millisecondsToNano(long time) {
        return time * (long) pow(10, 6);
    }

    public static long microsecondsToNano(long time) {
        return time * (long) pow(10, 3);
    }
}