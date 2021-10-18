public class Toy {
    private volatile boolean tumbler = false;

    public void change(int count, int sleep) {
        try {
            for (int i = 0; i < count; i++){
                System.out.println("Включаю тумблер");
                tumbler = !tumbler;
                Thread.sleep(sleep);
            }
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void controlTumbler() {
        while (true) {
            if (Thread.interrupted() == true) {
                return;
            }
            if (tumbler == true) {
                tumbler = false;
                System.out.println("Выключаю тумблер");
            }
        }

    }
}
