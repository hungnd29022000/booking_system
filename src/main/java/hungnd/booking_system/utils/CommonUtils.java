package hungnd.booking_system.utils;

public class CommonUtils {
    public static boolean checkEmpty(String input) {
        return input == null || input.equals("");
    }

    public static boolean checkEmpty(Double input) {
        return input == null || input == 0.0;
    }

    public static boolean checkEmpty(int input) {
        return input == 0;
    }

    public static boolean checkEmpty(Long input) {
        return input == null || input == 0L;
    }
}
