import java.math.BigDecimal;
import java.util.Scanner;

public class Reader {

    private Scanner scanner = new Scanner(System.in);

    public BigDecimal readNumber(){

        return scanner.nextBigDecimal();
    }
    public String readOperation(){

        return  scanner.next();
    }
}

