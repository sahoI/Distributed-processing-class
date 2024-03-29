public class Main {

    public static void main(String[] args) {
        PrintClass pc = new PrintClass();

        MultiThread1 mt1 = new MultiThread1(pc);
        MultiThread2 mt2 = new MultiThread2(pc);
        mt1.start();
        mt2.start();
    }

}

class PrintClass {
    private boolean bl = false;

    public synchronized void method1(String str, int i) {
        while(bl == true) {
            try {
                wait(); // blがtrueの間待機
            } catch (InterruptedException e) { }
        }

        System.out.println(str + "の" + (i + 1) + "度目の処理");
        bl = true;

        // blにtrueを代入したあと、待機状態のスレッドを実行可能状態に
        notifyAll();
    }

    public synchronized void method2(String str, int i) {
        while(bl == false) {
            try {
                wait(); // blがfalseの間待機
            } catch (InterruptedException e) { }
        }

        System.out.println(str + "の" + (i + 1) + "度目の処理");
        bl = false;

        // blにfalseを代入したあと、待機状態のスレッドを実行可能状態に
        notifyAll();
    }
}

class MultiThread1 extends Thread {
    private PrintClass pc;

    public MultiThread1(PrintClass pc) {
        this.pc = pc;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            pc.method1("スレッド1", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MultiThread2 extends Thread {
    private PrintClass pc;

    public MultiThread2(PrintClass pc) {
        this.pc = pc;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            pc.method2("スレッド2", i);
        }
    }
}
