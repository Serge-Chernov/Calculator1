import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage implements OpStorage {
    private final List<Operation> operations = new ArrayList<>();
    @Override
    public void save(Operation operation) {

    }
    @Override
    public List<Operation> findAll() {
        return new ArrayList<>(operations);
    }

}
