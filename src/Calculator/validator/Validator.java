package Calculator.validator;

import Calculator.console.util.ConsoleReader;
import Calculator.console.util.ConsoleWriter;
import Calculator.util.Reader;
import Calculator.util.Writer;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private Reader reader = new ConsoleReader();
    private Writer writer = new ConsoleWriter();

    public String ValidateNumber(String number) {
        boolean continueValidate = true;
        while (continueValidate) {
            number = reader.readString();
            Pattern pattern = Pattern.compile("\\-\\d*\\.?\\d{0,20}|\\d*\\.?\\d{0,20}");
            Matcher matcher = pattern.matcher(number);
            switch (String.valueOf(matcher.matches())) {
                case "true":
                    continueValidate = false;
                    break;
                case "false":
                    writer.write("Please, enter a number without letters or symbols");
            }
        }
        return number;
    }

    public String ValidateOperationType(String type) {
        boolean continueValidate = true;
        while (continueValidate) {
            type = reader.readString();
            Pattern pattern = Pattern.compile("^sum$|^sub$|^div$|^mul$");
            Matcher matcher = pattern.matcher(type);
            switch (String.valueOf(matcher.matches())) {
                case "true":
                    continueValidate = false;
                    break;
                case "false":
                    writer.write("Please, enter correct operation (sum, sub, div or mul");
            }
        }
        return type;
    }

    public String ValidateAnswer(String answer) {
        boolean continueValidate = true;
        while (continueValidate) {
            answer = reader.readString();
            Pattern pattern = Pattern.compile("^yes$|^no$");
            Matcher matcher = pattern.matcher(answer);
            switch (String.valueOf(matcher.matches())) {
                case "true":
                    continueValidate = false;
                    break;
                case "false":
                    writer.write("Please, enter correct answer (yes or no)");
            }
        }
        return answer;
    }
}
