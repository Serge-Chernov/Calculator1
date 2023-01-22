import java.math.BigDecimal;

public class Application {
    private Calculator calculator = new Calculator();
    private Writer writer = new Writer();
    private Reader reader = new Reader();

    public void runApp() {
        boolean continueCalculate = true;
        while (continueCalculate) {
            writer.write("Enter the first number");
            String snum1 = String.valueOf(reader.readNumber());

            writer.write("Enter the second number");
            String snum2 = String.valueOf(reader.readNumber());

            writer.write("Enter an arithmetic operation ('sum', 'sub', 'mul' or 'div')");
            String type = String.valueOf(reader.readOperation());

            BigDecimal num1 = new BigDecimal(snum1);
            BigDecimal num2 = new BigDecimal(snum2);
             BigDecimal result = calculator.calculate(num1, num2, type);

            writer.write(String.valueOf(result));

            writer.write("Do you want to continue? ('yes' or 'no')");
            String answer = reader.readOperation();
            switch (answer) {
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
        }
    }
}
