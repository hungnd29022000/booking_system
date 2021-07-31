package hungnd.booking_system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

    /**
     * generate time in yyyy-MM-dd format
     *
     * @param timeInMilliSecs time in milliseconds
     * @return date String in yyyy-MM-dd format
     */
    public static String generateTime(long timeInMilliSecs) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMilliSecs);
        return simpleDateFormat.format(cal.getTime());
    }

    /**
     * generate time in specified format
     *
     * @param timeInMilliSecs time in milliseconds
     * @param datePattern     date pattern, eg: yyyy-MM-dd, yyyy-MM-dd HH:mm:ss,....
     * @return date String in yyyy-MM-dd format
     */
    public static String generateTime(long timeInMilliSecs, String datePattern) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMilliSecs);
        return simpleDateFormat.format(cal.getTime());
    }

    /**
     * get time in milliseconds for a specified date
     *
     * @param date        date in String format, eg: 2020-01-01
     * @param datePattern date pattern, eg: yyyy-MM-dd, yyyy-MM-dd HH:mm:ss,....
     * @return time in milliseconds
     * @throws Exception if any error occurs
     */
    public static long getTimeInMilliSecs(String date, String datePattern) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
        Date dateObject = formatter.parse(date);
        return dateObject.getTime();
    }

    public static boolean checkBeforeTime(String fromDate, String toDate) {
        return LocalDateTime.parse(fromDate).isBefore(LocalDateTime.parse(toDate));
    }

    public static long getDurationTwoDay(String fromDate, String toDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(fromDate);
        Date d2 = sdf.parse(toDate);
        long difference_In_Time = d2.getTime() - d1.getTime();
        long daysBetween = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        return daysBetween;
    }

}
