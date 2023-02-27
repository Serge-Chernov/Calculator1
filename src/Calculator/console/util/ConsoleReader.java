package Calculator.console.util;

import Calculator.util.Reader;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private Scanner scanner = new Scanner(System.in);

    public BigDecimal readNumber() {

        return scanner.nextBigDecimal();
    }

    public String readString() {
        return scanner.next();
        }
}

