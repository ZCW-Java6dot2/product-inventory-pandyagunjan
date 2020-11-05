
import models.Sneaker;
import java.util.ArrayList;

public class SneakerService {

    private static int nextId = 1;  // (1)

    private AList<Sneaker> inventory = new ArrayList<>();  // (2)

    public SneakerService() {
    }

}