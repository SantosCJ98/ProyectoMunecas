import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Packer extends Worker implements Runnable {

    DressedBasket dressedBasket;

    FinalBasket finalBasket;

    public Packer(String name, DressedBasket dressedBasket, FinalBasket finalBasket) {
        super(name);
        this.dressedBasket = dressedBasket;
        this.finalBasket = finalBasket;
    }

    public int getWaitingTime() {

        Random random = new Random();

        return random.nextInt(1000) + 1000;

    }

    public void showMessage(Doll doll) {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.printf("(%s) Packer %s putted finished doll number %d in the Doll Basket\n", sdf.format(date), getName(), doll.getSerial_number());
    }

    @Override
    public void run() {

            while (true) {

                try {

                    Doll doll = dressedBasket.getLastDoll();
                    Thread.sleep(getWaitingTime());
                    finalBasket.addDoll(doll);
                    showMessage(doll);
                } catch (InterruptedException e) {
                    return;
                }
            }

        }
}
