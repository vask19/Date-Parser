package date;

import date.Datee;

import java.util.Comparator;

public class DateeComparator implements Comparator<Datee> {

    @Override
    public int compare(Datee o1, Datee o2) {
        int res = o1.getYear() - o2.getYear();
        if (res == 0)
            res = o1.getMonth() - o2.getMonth();
        if (res == 0)
            res = o1.getDay() - o2.getDay();
        return Integer.compare(res, 0);

    }
}
