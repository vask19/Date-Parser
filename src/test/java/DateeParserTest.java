import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utill.DateParser;

import java.util.List;

public class DateeParserTest {
    private static DateParser parser;

    private final String FIRST_FORMAT = "01.sep.2000";
    private final String SECOND_FORMAT = "12-01-1230";
    private final String THIRD_FORMAT = "10/OcT/2010";
    private final String FOURTH_FORMAT = "31.maY.2001";
    private final String FIFTH_FORMAT = "20/JUN.2000";
    private final String SIXTH_FORMAT = "03 oCT-2000";
    private final String SEVENTH_FORMAT = "01 sep 2000";


    private final String FIRST_ANSWER = "01.Sep.2000";
    private final String SECOND_ANSWER = "12-01-1230";
    private final String THIRD_ANSWER = "10/Oct/2010";
    private final String FOURTH_ANSWER = "31.May.2001";
    private final String FIFTH_ANSWER = "20/Jun.2000";
    private final String SIXTH_ANSWER = "03 Oct-2000";
    private final String SEVENTH_ANSWER = "01 Sep 2000";


    @BeforeAll
    public static void createDateParser(){
        parser = DateParser.getInstance();
    }


    @Test
    public void check1_5Formats(){
        String  formats = FIRST_FORMAT + SECOND_FORMAT + THIRD_FORMAT + FOURTH_FORMAT + FIFTH_FORMAT;
        var parsedDates = parser.parse(formats);
        List<String> answers = List.of(FIRST_ANSWER,SECOND_ANSWER,THIRD_ANSWER,FOURTH_ANSWER,FIFTH_ANSWER);
        Assertions.assertEquals(parsedDates,answers);
    }

    @Test
    public void check6Format(){
        var parsedDates = parser.parse(SIXTH_FORMAT);
        List<String> answers = List.of(SIXTH_ANSWER);
        Assertions.assertEquals(parsedDates,answers);
    }



    @Test
    public void check7Format(){
        var parsedDates = parser.parse(SEVENTH_FORMAT);
        List<String> answers = List.of(SEVENTH_ANSWER);
        Assertions.assertEquals(parsedDates,answers);
    }




}
