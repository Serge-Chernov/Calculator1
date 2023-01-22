import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(BigDecimal num1, BigDecimal num2, String type) {
        switch (type) {
            case "sum":
               return num1.add(num2);
            case "sub":
               return num1.subtract(num2);
            case "mul":
               return num1.multiply(num2);
            case "div":
               return num1.divide(num2, 14, RoundingMode.DOWN);

        }
        return BigDecimal.valueOf(0);
    }
}