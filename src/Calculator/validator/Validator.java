package Calculator.validator;

import Calculator.console.util.ConsoleReader;
import Calculator.console.util.ConsoleWriter;
import Calculator.util.Reader;
import Calculator.util.Writer;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private final Pattern patternNum = Pattern.compile("\\-\\d*\\.?\\d{0,20}|\\d*\\.?\\d{0,20}");
    private final Pattern patternType = Pattern.compile("^sum$|^sub$|^div$|^mul$");
    private final Pattern patternAnswer = Pattern.compile("^yes$|^no$");

    public Boolean validateNumber(String number) {

        Matcher matcher = patternNum.matcher(number);
        return matcher.matches();
    }

    public Boolean validateOperationType(String type) {

        Matcher matcher = patternType.matcher(type);
        return matcher.matches();
    }

    public Boolean validateAnswer(String answer) {

        Matcher matcher = patternAnswer.matcher(answer);
        return matcher.matches();
    }
}
