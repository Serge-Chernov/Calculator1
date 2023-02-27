package Calculator.console.util;

import Calculator.util.Writer;

public class ConsoleWriter implements Writer {
    public void write(String message){

        System.out.println(message);
    }
}
