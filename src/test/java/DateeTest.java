import date.Datee;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateeTest {
    private final String FIRST_ANSWER = "01.Sep.2000";
    private final String SECOND_ANSWER = "12-01-1230";
    private final String THIRD_ANSWER = "10/Oct/2010";
    private final String FOURTH_ANSWER = "31.May.2001";
    private final String FIFTH_ANSWER = "20/Jun.2000";
    private final String SIXTH_ANSWER = "03 Oct-2000";
    private final String SEVENTH_ANSWER = "01 Sep 2000";




    @Test
    public void checkCreationFirstFormatDate(){
        Datee datee = new Datee(FIRST_ANSWER);
        Assertions.assertEquals(datee.toString(), "2000_9_1");


    }
    @Test
    public void checkCreationSecondFormatDate(){
        Datee datee = new Datee(SECOND_ANSWER);
        Assertions.assertEquals(datee.toString(), "1230_1_12");


    }
    @Test
    public void checkCreationThirdFormatDate(){
        Datee datee = new Datee(THIRD_ANSWER);
        Assertions.assertEquals(datee.toString(), "2010_10_10");


    }
    @Test
    public void checkCreationFourthFormatDate(){
        Datee datee = new Datee(FOURTH_ANSWER);
        Assertions.assertEquals(datee.toString(), "2001_5_31");


    }
    @Test
    public void checkCreationFifthFormatDate(){
        Datee datee = new Datee(FIFTH_ANSWER);

        Assertions.assertEquals(datee.toString(), "2000_6_20");


    }
    @Test
    public void checkCreationSixthFormatDate(){
        Datee datee = new Datee(SIXTH_ANSWER);

        Assertions.assertEquals(datee.toString(), "2000_10_3");


    }

    @Test
    public void checkCreationSeventhFormatDate(){
        Datee datee = new Datee(SEVENTH_ANSWER);


        Assertions.assertEquals(datee.toString(), "2000_9_1");


    }

}
