package service.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDelimiterService implements DelimiterService {
    public static final String DELIMITER_PREFIX = "//";
    public static final String DELIMITER_SUFFIX = "\n";

    public String getDelimiters(String text, String pattern1, String pattern2) {
        String regexString = Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2);
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

}
