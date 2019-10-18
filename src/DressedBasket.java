import java.util.ArrayList;
import java.util.List;

public class DressedBasket {

    List<Doll> dressedBasket = new ArrayList<>();


    public synchronized void addDoll(Doll doll) {

        dressedBasket.add(doll);

        notifyAll();

    }

    public synchronized Doll getLastDoll() throws InterruptedException {

        while (dressedBasket.isEmpty()) {

                wait();



        }


        return dressedBasket.remove(dressedBasket.size() - 1);


    }


}
