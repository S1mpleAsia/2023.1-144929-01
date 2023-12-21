import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;


public class checkTime{
    public String inputTime(String time){
        try{
            LocalTime.parse(time);
            return "Valid time " + time;
        }catch(DateTimeParseException | NullPointerException e){
            return "Invalid time " + time;
        }
    }
    @Test
    public void TC1() {
        checkTime test = new checkTime();
        Assert.assertEquals("Valid time 08:00",test.inputTime("08:00"));
    }

    @Test
    public void TC2() {
        checkTime test = new checkTime();
        Assert.assertEquals("Valid time 08:00:00",test.inputTime("08:00:00"));
    }

    @Test
    public void TC3() {
        checkTime test = new checkTime();
        Assert.assertEquals("Invalid time 08",test.inputTime("08"));
    }
    @Test
    public void TC4(){
        checkTime test = new checkTime();
        Assert.assertEquals("Valid time 13:00",test.inputTime("13:00"));
    }

    @Test
    public void TC5(){
        checkTime test = new checkTime();
        Assert.assertEquals("Valid time 23:59",test.inputTime("23:59"));
    }

    @Test
    public void TC6(){
        checkTime test = new checkTime();
        Assert.assertEquals("Invalid time 10-20-30",test.inputTime("10-20-30"));
    }
    @Test
    public void TC7(){
        checkTime test = new checkTime();
        Assert.assertEquals("Valid time 10:20:30.000",test.inputTime("10:20:30.000"));
    }

}

