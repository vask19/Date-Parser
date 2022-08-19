import date.Datee;
import fileutils.CustomFileReader;
import fileutils.CustomFileWriter;
import utill.DateParser;
import date.DateeComparator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String filePath ="File_with_dates.txt";

    public static void main(String[] args) {
        String date3 = CustomFileReader.read(filePath);
        DateParser parser = DateParser.getInstance();
        var list = parser.parse(date3);
        System.out.println(list);
        List<Datee> datees =
                             list.stream().map(Datee::new)
                                     .collect(Collectors.toList())
                                     .stream()
                                     .sorted((x,y) ->
                                             new DateeComparator().compare(x,y))
                                     .collect(Collectors.toList());

        var element
                = datees.stream().filter(el -> el.getYear() == 2000 && el.getMonth() == 9 && el.getDay() == 1).findFirst();
        System.out.println(element.orElse(new Datee()));
        datees.forEach(System.out::println);

        CustomFileWriter.write(datees,"File_with_dates.bin");






    }

}




