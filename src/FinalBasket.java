import java.util.ArrayList;
import java.util.List;

public class FinalBasket {

    List<Doll> finalBasket = new ArrayList<>();

    public synchronized void addDoll(Doll doll) {

        finalBasket.add(doll);

    }

    public synchronized int getTotalDolls() {

        return finalBasket.size();

    }

}
