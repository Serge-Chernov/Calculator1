import java.math.BigDecimal;
import java.util.List;

public class Application {
    private Calculator calculator = new Calculator();
    private Writer writer = new ConsoleWriter();
    private Reader reader = new ConsoleReader();
    private OperationStorage storage = new InMemoryOperationStorage();

    public void runApp() {
        boolean continueCalculate = true;
        while (continueCalculate) {
            writer.write("Enter the first number");
            BigDecimal num1 = reader.readNumber();

            writer.write("Enter the second number");
            BigDecimal num2 = reader.readNumber();

            writer.write("Enter an arithmetic operation ('sum', 'sub', 'mul' or 'div')");
            String type = reader.readString();

            Operation op = new Operation(num1, num2, type);
            Operation result = calculator.calculate(op);
            storage.save(result);
            writer.write(result.toString());

            writer.write("Do you want to see story? ('yes' or 'no')");
            String answer = reader.readString();
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

            writer.write("Do you want to continue? ('yes' or 'no')");
            String answer2 = reader.readString();
            switch (answer2) {
                case "yes": {
                    continueCalculate = true;
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
    }
}

