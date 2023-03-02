package Calculator.storage;

import Calculator.entity.Operation;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonOperationStorage {

    private Gson gson = new Gson();

    public void save(List<Operation> operations) {
        for (Operation operation : operations) {
            String s = gson.toJson(operations);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("history.json");
                fileWriter.write(s);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
