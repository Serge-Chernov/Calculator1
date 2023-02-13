import java.math.BigDecimal;

public class Operation {
    BigDecimal num1;
    BigDecimal num2;
    String type;
    BigDecimal result;

    public Operation(BigDecimal num1, BigDecimal num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public BigDecimal getNum1() {
        return num1;
    }

    public BigDecimal getNum2() {
        return num2;
    }

    public String getType() {

        return type;
    }

    public BigDecimal getResult() {

        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String toString() {
        return result.toString();
    }
}