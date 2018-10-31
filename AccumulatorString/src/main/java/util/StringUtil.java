package util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static String getNegatvie(String [] numbers) {
        String negativeString= "";
        for (int i = 0; i <= numbers.length -1; i++){
            if (Integer.parseInt(numbers[i]) < 0){
                negativeString = negativeString + numbers[i] + ",";
            }
        }
        if (negativeString != "") {
            return negativeString.substring(0,negativeString.length() -1);
        }
        return "";
    }
}
