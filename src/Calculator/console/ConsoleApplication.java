package Calculator.console;

import Calculator.Application;
import Calculator.console.util.ConsoleReader;
import Calculator.console.util.ConsoleWriter;
import Calculator.entity.Operation;
import Calculator.service.Calculator;
import Calculator.storage.InMemoryOperationStorage;
import Calculator.storage.OperationStorage;
import Calculator.util.Reader;
import Calculator.util.Writer;
import Calculator.validator.Validator;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class ConsoleApplication implements Application {
    private Calculator calculator = new Calculator();
    private Writer writer = new ConsoleWriter();

    private Reader reader = new ConsoleReader();
    private OperationStorage storage = new InMemoryOperationStorage();

    private Validator validator = new Validator();

    Gson gson = new Gson();

    public void runApp() {
        boolean continueCalculate = true;
        while (continueCalculate) {


            writer.write("Enter the first number");
            String snum1 = "";
            snum1 = validator.ValidateNumber(snum1);
            BigDecimal num1 = new BigDecimal(snum1);


            writer.write("Enter the second number");
            String snum2 = "";
            snum2 = validator.ValidateNumber(snum2);
            BigDecimal num2 = new BigDecimal(snum2);


            writer.write("Enter an arithmetic operation (sum, sub, mul or div)");
            String sType = "";
            sType = validator.ValidateOperationType(sType);
            String type = sType;


            Operation op = new Operation(num1, num2, type);
            Operation result = calculator.calculate(op);
            storage.save(result);
            writer.write(result.toString());


            writer.write("Do you want to see story? (yes or no)");
            String sAnswer = "";
            sAnswer = validator.ValidateAnswer(sAnswer);
            String answer = sAnswer;
            switch (answer) {
                case "yes": {
                    operationHistory(storage.findAll());
                    break;
                }
                case "no": {
                    writer.write("Fine");
                    break;
                }
                default: {
                    break;
                }
            }
            writer.write("Do you want to continue? (yes or no)");
            String sAnswer2 = "";
            sAnswer2 = validator.ValidateAnswer(sAnswer2);
            String answer2 = sAnswer2;
            switch (answer2) {
                case "yes": {
//                    continueCalculate = true;
                    break;
                }
                case "no": {
                    continueCalculate = false;
                    writer.write("Bye!");
                    break;
                }
                default: {
                    continueCalculate = false;
                    writer.write("Bye!");
                }

            }
        }
    }

    private void operationHistory(List<Operation> operations) {
        for (Operation operation : operations) {
            writer.write(operation.toString());
        }
        String s = gson.toJson(operations);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("history.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

