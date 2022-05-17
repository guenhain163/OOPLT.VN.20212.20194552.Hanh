package hust.soict.hedspi.aims.utils;

import hust.soict.hedspi.aims.utils.MyDate;

public class DateUtils {
    // return -1 if d1 is after d2
    // return 0 if d1 equals d2
    // return 1 if d1 is before d2
    public static int compareTwoDates(MyDate d1, MyDate d2) {
        int month1 = d1.getMonth();
        int month2 = d2.getMonth();
        int day1 = d1.getDay();
        int day2 = d2.getDay();

        if (d1.getYear() > d2.getYear()) {
            return 1;
        }

        if (d1.getYear() < d2.getYear()) {
            return -1;
        }

        if (month1 > month2) {
            return 1;
        }

        if (month1 < month2) {
            return -1;
        }

        if (day1 > day2) {
            return 1;
        }

        if (day1 < day2) {
            return -1;
        }

        return 0;
    }
}
