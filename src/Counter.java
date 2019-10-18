public class Counter {

    Integer counter = 1;

    public synchronized void increment() {

        counter++;

    }

    public Integer getCounter() {
        return counter;
    }
}
