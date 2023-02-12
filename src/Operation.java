import java.math.BigDecimal;

public class Operation {
    double num1;
    double num2;
    String type;
    double result;

    public Operation(double num1, double num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getType() {

        return type;
    }

    public double getResult() {

        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String toString() {
        return String.valueOf(result);
    }
}