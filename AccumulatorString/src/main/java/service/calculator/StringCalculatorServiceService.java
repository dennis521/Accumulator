package service.calculator;

import service.delimiter.PatternDelimiterService;
import service.delimiter.DelimiterService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.StringUtil;

public class StringCalculatorServiceService implements CalculatorService {
    private static final int LIMIT =1000;
    private static final List<String> SPECIAL_CHARACTERS = new ArrayList<String>(Arrays.asList("*", "$"));
    private DelimiterService patternDelimiterService;
    public StringCalculatorServiceService() {
        patternDelimiterService = new PatternDelimiterService();
    }
    public StringCalculatorServiceService(DelimiterService patternDelimiterService) {
        this.patternDelimiterService = patternDelimiterService;
    }
    public int add(String number) throws Exception{
        if (number ==null) return 0;

        String delimiters = patternDelimiterService.getDelimiters(number, PatternDelimiterService.DELIMITER_PREFIX, PatternDelimiterService.DELIMITER_SUFFIX);
        String removedDelimiterLineNumber = number.substring(number.indexOf(PatternDelimiterService.DELIMITER_SUFFIX)+1);
//        String [] numbers = removedDelimiterLineNumber.split(delimiters);
        String [] numbers = removedDelimiterLineNumber.split(escapeCharacters(delimiters));

        String negatives = StringUtil.getNegatvie(numbers);
        if (negatives != "") {
            throw new Exception("negatives not allowed:" + negatives);
        }
        int total = 0;
        int current = 0;
        for (int i = 0; i <= numbers.length -1; i++){
            current =  Integer.parseInt(numbers[i]);
            if (current <= LIMIT){
                total += current;
            }
        }
        return total;
    }

    public String escapeCharacters(String characters) {
        String escapeChar;
        for (int i=0; i<= SPECIAL_CHARACTERS.size() -1; i++) {
            escapeChar = SPECIAL_CHARACTERS.get(i);
            characters = characters.replaceAll("\\" + escapeChar, "\\\\" + escapeChar);
        }

        return characters;
    }

}
