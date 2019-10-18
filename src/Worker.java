public abstract class Worker {

    String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getWaitingTime();

    public abstract void showMessage(Doll doll);


}
