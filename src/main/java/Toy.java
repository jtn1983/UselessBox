public class Toy {
    private volatile boolean tumbler = false;

    public void change(int count, int sleep) {
        try {
            for (int i = 0; i < count; i++) {
                System.out.println("Включаю тумблер");
                if (!tumbler) {
                    tumbler = true;
                }
                Thread.sleep(sleep);
            }
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void controlTumbler() {
        if (Thread.interrupted()) {
            return;
        }
        if (tumbler) {
            tumbler = false;
            System.out.println("Выключаю тумблер");
        }
    }
}
