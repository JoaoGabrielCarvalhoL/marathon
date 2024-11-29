package br.com.joaogabriel.threads.synchronizedd;

import br.com.joaogabriel.threads.model.Account;

public class ThreadAccount implements Runnable {

    private Account account = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("...");
            }
        }
    }

    /**
     * Locking the execution to a single thread. This way, every thread accesses the method per time.
     * */
    private synchronized void withdrawal(int amount) {
        try {
            Thread.sleep(1000);
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + " is withdrawing money from the account.");
            this.account.withdrawal(amount);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadAccount threadAccount = new ThreadAccount();
        Thread thread = new Thread(threadAccount, "Hestia");
        Thread secondThread = new Thread(threadAccount, "Bell Cranel");
        thread.start();
        secondThread.start();
    }


}
