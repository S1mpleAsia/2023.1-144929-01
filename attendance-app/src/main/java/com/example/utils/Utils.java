package utils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class Utils {
    public static Logger getLogger(String className) {
        return Logger.getLogger(className);
    }

    public static LocalDateTime dateTimeConvert(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString ,formatter);
    }

    public static LocalDate simpleConvert(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    public static LocalDate convert(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDate.parse(dateString, formatter);
    }

    public static Double roundValue(Double time) {
        DecimalFormat df = new DecimalFormat("#.##");

        return Double.valueOf(df.format(time));
    }

    public static double getTimeFromLocalDateTime(LocalDateTime dateTime) {
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();

        return hour + 1.0 * minute / 60 + 1.0 * second / 3600;
    }

    public static String getStringTime(LocalDateTime dateTime) {
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();

        return hour + ":" + minute + ":" + second;
    }
}
