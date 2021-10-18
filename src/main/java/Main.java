public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int count = 10;
        final int sleep = 1000;
        Toy toy = new Toy();
        Thread user = new Thread(null, () -> toy.change(count, sleep));
        Thread changer = new Thread(null, toy::controlTumbler);

        user.start();
        changer.start();

        user.join();
        changer.interrupt();



    }
}
