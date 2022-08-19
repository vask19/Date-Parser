package date;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Custom date
 * with format yyyy_MM_dd
 * @version 1.0
 *
 */

public class Datee implements Comparable<Datee>, Serializable {



    private int year;
    private int month;
    private int day;
    private int daysOfMonth;

    public Datee() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Datee(String date) {
       LocalDate localDate = createTempDate(date);
        year = localDate.getYear();
        month = localDate.getMonthValue();
        day = localDate.getDayOfMonth();
        daysOfMonth = localDate.getMonth().maxLength();


    }


    /**
     * Parse String date to LocalDate
     * @param date
     * @return
     */
    private LocalDate createTempDate(String date){
        String format = createFormat(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formatter);
    }


    @Override
    public String toString(){
        return (year +"_"+month+"_"+day);
    }


    /**
     * Creates format for parse string to LocalDate
     * @param date line with String date
     * @return String format
     */
    private String createFormat(String date) {
        String oldDate = date;
        date = date.replace(date.substring(0, 2), "dd");
        Matcher matcher = Pattern.compile("\\d{2}[. -/]\\w{3}[. /-]\\d{4}").matcher(oldDate);
        if (matcher.find()) {
            date = date.replace(date.substring(3, 6), "MMM");
            date = date.replace(date.substring(7, 11), "yyyy");
        } else {
            date = date.replace(date.substring(3, 5), "MM");
            date = date.replace(date.substring(6, 10), "yyyy");
        }
        return date;
    }

    @Override
    public int compareTo(Datee datee) {
        int res = this.year - datee.year;
        if (res == 0)
            res = this.month - datee.month;
        if (res == 0)
            res = this.day - datee.day;
        return Integer.compare(res, 0);

    }
}



