import java.math.BigDecimal;

public class Application {
   private Calculator calculator = new Calculator();
   private Writer writer = new Writer();
   private Reader reader = new Reader();
     public void runApp(){
         writer.write("Enter the first number");
         String snum1 = String.valueOf(reader.readNumber());

         writer.write("Enter the second number");
         String snum2 = String.valueOf(reader.readNumber());

         writer.write("Enter an arithmetic operation");
         String type = String.valueOf(reader.readOperation());

         BigDecimal num1 = new BigDecimal(snum1);
         BigDecimal num2 = new BigDecimal(snum2);
         BigDecimal result = calculator.calculate(num1, num2, type);

         writer.write(String.valueOf(result));

     }
}
