package service.delimiter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatternDelimiterServiceTest {
    private PatternDelimiterService patternDelimiterService;
    @Before
    public void setUp() throws Exception {
        patternDelimiterService = new PatternDelimiterService();
    }

    @Test
    public void getDelimiters() {
        String actualDelimiters = ";";
        String delimiterLine = PatternDelimiterService.DELIMITER_PREFIX + actualDelimiters + PatternDelimiterService.DELIMITER_SUFFIX;
        String numberString = delimiterLine + "1;2";
    }
}