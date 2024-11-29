package br.com.joaogabriel.threads.model.service;

import br.com.joaogabriel.threads.model.Member;

public class EmailDeliveryService implements Runnable {

    private final Member member;

    public EmailDeliveryService(Member member) {
        this.member = member;
    }

    @Override
    public void run() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + " starting to deliver emails");
        while (member.isOpen() || member.pendingEmails() > 0) {
            try {
                String email = member.retrieveEmail();
                if (email == null) continue;
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + " sending email to: " + email);
                Thread.sleep(2000);
                System.out.println("Email sent.");
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        System.out.println("All emails are sent successfully");
    }
}
