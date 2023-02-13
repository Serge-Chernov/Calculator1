import java.math.RoundingMode;

public class Calculator {
    public Operation calculate(Operation operation) {
        switch (operation.getType()) {
            case "sum":
                operation.setResult(operation.getNum1().add(operation.getNum2()));
                return operation;
            case "sub":
                operation.setResult(operation.getNum1().subtract(operation.getNum2()));
                return operation;
            case "mul":
                operation.setResult(operation.getNum1().multiply(operation.getNum2()));
                return operation;
            case "div":
                operation.setResult(operation.getNum1().divide(operation.getNum2(),14, RoundingMode.DOWN));
                return operation;

        }
        return operation;
    }
}