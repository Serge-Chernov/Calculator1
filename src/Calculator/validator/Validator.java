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

    private Reader reader = new ConsoleReader();
    private Writer writer = new ConsoleWriter();

    public Boolean validateNumber(String number) {

        Pattern pattern = Pattern.compile("\\-\\d*\\.?\\d{0,20}|\\d*\\.?\\d{0,20}");
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }

    public Boolean validateOperationType(String type) {

        Pattern pattern = Pattern.compile("^sum$|^sub$|^div$|^mul$");
        Matcher matcher = pattern.matcher(type);

        return matcher.matches();
    }

    public Boolean validateAnswer(String answer) {

        Pattern pattern = Pattern.compile("^yes$|^no$");
        Matcher matcher = pattern.matcher(answer);

        return matcher.matches();
    }
}
