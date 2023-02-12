import java.math.BigDecimal;
import java.util.List;

public class Application {
    private Calculator calculator = new Calculator();
    private Writer writer = new Writer();
    private Reader reader = new Reader();
    private OpStorage storage = new InMemoryOperationStorage();

    public void runApp() {
        boolean continueCalculate = true;
        while (continueCalculate) {
            writer.write("Enter the first number");
            double num1 = reader.readNumber();

            writer.write("Enter the second number");
            double num2 = reader.readNumber();

            writer.write("Enter an arithmetic operation ('sum', 'sub', 'mul' or 'div')");
            String type = reader.readString();

            Operation op = new Operation(num1, num2, type);
            Operation result = calculator.calculate(op);
            storage.save(result);
            writer.write(String.valueOf(result));

            writer.write("Do you want to see story? ('yes' or 'no')");
            String answer = reader.readString();
            switch (answer) {
                case "yes": {
                    operationHistory(storage.findAll());
                    List<Operation> all = storage.findAll();
                    for (Operation operation : storage.findAll()) {
                        writer.write("num 1: " + operation.num1 + " " + operation.type + " num 2: " + operation.num2 + " = " + operation.result);                    }
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
