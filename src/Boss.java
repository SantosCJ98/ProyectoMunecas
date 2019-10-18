public class Boss {

    public static void main(String[] args) {

        Counter counter = new Counter();

        DollBasket dollBasket = new DollBasket();

        DressedBasket dressedBasket = new DressedBasket();

        FinalBasket finalBasket = new FinalBasket();

        DollMaker dm1 = new DollMaker("Pablo", dollBasket, counter);

        DollMaker dm2 = new DollMaker("Juan", dollBasket, counter);

        Tailor tlr = new Tailor("Andrea", dollBasket, dressedBasket);

        Packer pckr = new Packer("Rocío", dressedBasket, finalBasket);

        Thread th_dm1 = new Thread(dm1);

        Thread th_dm2 = new Thread(dm2);

        Thread th_tlr = new Thread(tlr);

        Thread th_pckr = new Thread(pckr);
        try {

            th_dm1.start();

            th_dm2.start();

            th_tlr.start();

            th_pckr.start();


            Thread.sleep(60000);


            th_dm1.interrupt();
            th_dm2.interrupt();
            th_tlr.interrupt();
            th_pckr.interrupt();
        } catch (InterruptedException e) {

        }

        System.out.printf("Day is over.\nA total of %d dolls has been produced.", finalBasket.getTotalDolls());


    }

}
