package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void getNegatvie() {
        String [] numbers = {"3","4","-5", "-6", "8", "-9"};
        String expected = "-5,-6,-9";
        assertEquals(expected, StringUtil.getNegatvie(numbers));
    }
}