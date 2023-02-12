import java.math.BigDecimal;
import java.util.List;

public interface OpStorage {

    void save(Operation operation);

    List<Operation> findAll();
}
