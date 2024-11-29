package br.com.joaogabriel.threads.model;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Member {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen() {return this.open;}

    public int pendingEmails() {
        synchronized (this.emails) {
            return this.emails.size();
        }
    }

    public void addMemberEmail(String email) {
        synchronized (this.emails) {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "added email to list");
            this.emails.add(email);
            this.emails.notifyAll();
        }
    }

    public String retrieveEmail() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + "checking if there are emails");
        synchronized (this.emails) {
            while (this.emails.isEmpty()) {
                if (!open) return null;
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + " No email available.");
                /**
                 * Usage of wait must be in the context of lock thread.
                 * */
                try {
                    this.emails.wait();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            return this.emails.poll();
        }
    }

    public void close() {
        this.open = false;
        synchronized (this.emails) {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + " Notifying all threads...");

        }
    }
}
