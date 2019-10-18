import java.util.ArrayList;
import java.util.List;

public class DollBasket {

    List<Doll> dollBasket = new ArrayList<>();

    public List<Doll> getDollBasket() {
        return dollBasket;
    }

    public synchronized void addDoll(Doll doll) {

        dollBasket.add(doll);

        notifyAll();

    }

    public synchronized Doll getLastDoll() throws InterruptedException {

        while (dollBasket.isEmpty()) {


                wait();

        }


        return dollBasket.remove(dollBasket.size() - 1);

    }


}
