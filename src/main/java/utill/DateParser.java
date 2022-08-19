package utill;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateParser {
    private final String pattern = "(0[1-9]|[12][0-9]|3[0-1])[/\\. \\-](0[1-9]|1[0-3]|\\w{3}\\.?)[/\\. \\-]((1[1-9]|20)\\d{2})";
    private final String monthPattern = "\\w{3}";
    private static DateParser instance;
    private DateParser(){
    }
    public static DateParser getInstance(){
        if (instance == null){
            instance = new DateParser();
        }
        return instance;
    }


    /**
     * Parses all dates from line according to a given pattern
     * @param str
     * @return String list parsed dates
     */
    public List<String> parse(String str){
        List<String > date = new ArrayList<>();
        Matcher matcher = Pattern.compile(pattern).matcher(str);
        while (matcher.find()){
            String dateStr = matcher.group();
            Matcher monthMatcher = Pattern.compile(monthPattern).matcher(dateStr);
            if (monthMatcher.find()){
                dateStr = dateStr.replace(dateStr.substring(3,4),dateStr.substring(3,4).toUpperCase(Locale.ROOT))
                        .replace(dateStr.substring(4,6),dateStr.substring(4,6).toLowerCase(Locale.ROOT));
            }
            date.add(dateStr);
        }
        return date;



    }


}
