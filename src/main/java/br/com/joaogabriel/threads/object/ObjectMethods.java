package br.com.joaogabriel.threads.object;

import br.com.joaogabriel.threads.model.Member;
import br.com.joaogabriel.threads.model.service.EmailDeliveryService;

import javax.swing.*;

/**
 * Wait, Notify and NotifyAll
 * */
public class ObjectMethods {
    public static void main(String[] args) {
        Member member = new Member();
        Thread jiraya = new Thread(new EmailDeliveryService(member), "Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(member), "Kakashi");
        jiraya.start();
        kakashi.start();
        while(true) {
            String email = JOptionPane.showInputDialog("Enter your email: ");
            if (email == null || email.isBlank()) {
                member.close();
                break;
            }
            member.addMemberEmail(email);
        }

    }
}
