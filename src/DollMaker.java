import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DollMaker extends Worker implements Runnable {

    DollBasket dollBasket;

    Counter counter;

    public DollMaker(String name, DollBasket dollBasket, Counter counter) {
        super(name);
        this.dollBasket = dollBasket;
        this.counter = counter;
    }

    public int getWaitingTime() {

        Random random = new Random();

        return random.nextInt(8000-4000) + 4000;

    }

    @Override
    public void showMessage(Doll doll) {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.printf("(%s) Doll Maker %s putted maked doll number %d in the Doll Basket\n", sdf.format(date), getName(), doll.getSerial_number());
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(getWaitingTime());
                Doll doll = new Doll(counter.getCounter());
                dollBasket.addDoll(doll);
                showMessage(doll);
                counter.increment();
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
