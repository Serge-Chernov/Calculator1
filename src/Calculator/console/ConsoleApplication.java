package Calculator.console;

import Calculator.Application;
import Calculator.console.util.ConsoleReader;
import Calculator.console.util.ConsoleWriter;
import Calculator.entity.Operation;
import Calculator.service.Calculator;
import Calculator.storage.InMemoryOperationStorage;
import Calculator.storage.JsonOperationStorage;
import Calculator.storage.OperationStorage;
import Calculator.util.Reader;
import Calculator.util.Writer;
import Calculator.validator.Validator;
import java.math.BigDecimal;
import java.util.List;

public class ConsoleApplication implements Application {
    private Calculator calculator = new Calculator();
    private Writer writer = new ConsoleWriter();
    private Reader reader = new ConsoleReader();
    private OperationStorage storage = new InMemoryOperationStorage();
    private Validator validator = new Validator();
    private JsonOperationStorage json = new JsonOperationStorage();

    public void runApp() {
        boolean continueCalculate = true;
        while (continueCalculate) {
            boolean continueValidate = false;
            String ent = "";
            BigDecimal num1;
            BigDecimal num2;
            String type;

            while (true) {
                do {
                    writer.write("Enter the first number");
                    ent = reader.readString();

                } while (continueValidate == validator.validateNumber(ent));
                num1 = new BigDecimal(ent);

                do {
                    writer.write("Enter the second number");
                    ent = reader.readString();

                } while (continueValidate == validator.validateNumber(ent));
                num2 = new BigDecimal(ent);

                do {
                    writer.write("Enter an arithmetic operation (sum, sub, mul or div)");
                    ent = reader.readString();

                } while (continueValidate == validator.validateOperationType(ent));
                type = ent;

                Operation op = new Operation(num1, num2, type);
                Operation result = calculator.calculate(op);
                storage.save(result);
                writer.write(result.toString());

                do {
                    writer.write("Do you want to see story? (yes or no)");
                    ent = reader.readString();

                } while (continueValidate == validator.validateAnswer(ent));
                String answer = ent;
                switch (answer) {
                    case "yes": {
                        operationHistory(storage.findAll());
                        break;
                    }
                    case "no": {
                        JsonOperationHistory(storage.findAll());
                        writer.write("Fine");
                        break;
                    }
                    default: {
                        break;
                    }
                }

                do {
                    writer.write("Do you want to continue? (yes or no)");
                    ent = reader.readString();

                } while (continueValidate == validator.validateAnswer(ent));
                String answer2 = ent;
                switch (answer2) {
                    case "yes": {
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
                break;
            }
        }
    }

    private void JsonOperationHistory(List<Operation> operations) {
        for (Operation operation : operations) {
            json.save(operations);
        }
    }
    private void operationHistory(List<Operation> operations) {
        for (Operation operation : operations) {
            writer.write(operation.toString());
            json.save(operations);
        }
    }
}


