import java.math.BigDecimal;
import java.util.Scanner;

public class Reader {

    private Scanner scanner = new Scanner(System.in);

    public double readNumber(){

        return scanner.nextDouble();
    }
    public String readString(){

        return  scanner.next();
    }

}

