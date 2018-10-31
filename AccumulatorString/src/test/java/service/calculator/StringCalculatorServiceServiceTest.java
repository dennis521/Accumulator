package service.calculator;

import static org.junit.Assert.assertEquals;

import service.delimiter.DelimiterService;
import service.delimiter.PatternDelimiterService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

public class StringCalculatorServiceServiceTest {
    private CalculatorService stringCalculatorService;
    private DelimiterService patternDelimiterService;
    @Before
    public void setUp() throws Exception {
        patternDelimiterService = new PatternDelimiterService();
        stringCalculatorService = new StringCalculatorServiceService(patternDelimiterService);
    }

    @Test
    public void addTestEmpty() throws Exception{
        String numberString =null;
        assertEquals(0, stringCalculatorService.add(numberString));
    }
    @Test
    public void addTestOneNumber() throws Exception{
        String numberString ="1";
        int expected =1;
        assertEquals(expected, stringCalculatorService.add(numberString));

        numberString ="2";
        expected =2;
        assertEquals(expected, stringCalculatorService.add(numberString));
    }

    @Test(expected = Exception.class)
    public void addTestThrowException() throws Exception{
        String numberString ="1,-5,-8,9";
        stringCalculatorService.add(numberString);
    }

    @Test
    public void addTestAboveLimit() throws Exception{
        String delimiters = PatternDelimiterService.DELIMITER_PREFIX + "," + PatternDelimiterService.DELIMITER_SUFFIX;
        String numberString = delimiters + "1,1000,1001";
        int expected = 1001;
        assertEquals(expected,stringCalculatorService.add(numberString));
    }

    @Test
    public void addTestMultipleNumbers() throws Exception{
        String delimiters = PatternDelimiterService.DELIMITER_PREFIX + ";" + PatternDelimiterService.DELIMITER_SUFFIX;
        String numberString = delimiters + "1;2";
        int expected =3;
        assertEquals(expected, stringCalculatorService.add(numberString));

        numberString = delimiters + "1;2;3";
        expected =6;
        assertEquals(expected, stringCalculatorService.add(numberString));

        numberString = delimiters + "1;2;5";
        expected =8;
        assertEquals(expected, stringCalculatorService.add(numberString));
    }

    @Test
    public void addTestAnyLength() throws Exception{
        String delimiters = PatternDelimiterService.DELIMITER_PREFIX + ";;;;" + PatternDelimiterService.DELIMITER_SUFFIX;
        String numberString = delimiters + "1;;;;2;;;;3";
        int expected =6;
        assertEquals(expected, stringCalculatorService.add(numberString));
    }

    @Test
    public void addTestAnyLength2() throws Exception{
        String delimiters = PatternDelimiterService.DELIMITER_PREFIX + "***" + PatternDelimiterService.DELIMITER_SUFFIX;
        String numberString = delimiters + "1***2***3";
        int expected =6;
        assertEquals(expected, stringCalculatorService.add(numberString));
    }

    @Test
    public void addTestMultipleDelimiters() throws Exception{
        String delimiters = PatternDelimiterService.DELIMITER_PREFIX + "!|%" + PatternDelimiterService.DELIMITER_SUFFIX;
        String numberString = delimiters + "1!2%3";
        int expected =6;
        assertEquals(expected, stringCalculatorService.add(numberString));
    }

}