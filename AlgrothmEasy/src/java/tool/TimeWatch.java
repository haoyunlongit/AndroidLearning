package java.tool;
public class TimeWatch {
    static long timeFlag = 0;
    public static void start() {
        timeFlag = System.currentTimeMillis();
    }

    public static long stop() {
        long result = System.currentTimeMillis() - timeFlag;
        timeFlag = 0;
        return result;
    }

}
