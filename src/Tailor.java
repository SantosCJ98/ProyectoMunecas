import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tailor extends Worker implements Runnable {

    DollBasket dollBasket;

    DressedBasket dressedBasket;

    Counter counter;

    public Tailor(String name, DollBasket dollBasket, DressedBasket dressedBasket) {

        super(name);

        this.dollBasket = dollBasket;

        this.dressedBasket = dressedBasket;
    }

    public int getWaitingTime() {

        Random random = new Random();

        return random.nextInt(3000-1000) + 1000;

    }

    public void showMessage(Doll doll) {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.printf("(%s) Tailor %s putted dressed doll number %d in the Dressed Basket\n", sdf.format(date), getName(), doll.getSerial_number());
    }

    @Override
    public void run() {

        while (true) {

            try {

                Doll doll = dollBasket.getLastDoll();
                Thread.sleep(getWaitingTime());
                dressedBasket.addDoll(doll);
                showMessage(doll);
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
