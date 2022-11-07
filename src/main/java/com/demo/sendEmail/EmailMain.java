/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.sendEmail;

import com.raven.form.Form_DoiMatKhau;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Daokh
 */
public class EmailMain {

    public static String maxt = "";

    public static int RanDom() {
        int min = 100000;
        int max = 999999;
        int random_int = (int) (Math.random() * (max - min + 1) + min);
        System.out.println(random_int);
        maxt = String.valueOf(random_int);
        return random_int;
    }

    public static void GuiEmail(String toEmail) {
        final String username = "ngobakha2t4@gmail.com";
        final String password = "tsopgjhvyuygyygt";
        System.out.println(username);
//        final String ToEmail = XacNhanEmail.getEmail();
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");//TLS
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("traptps21791@fpt.edu.vn"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse("traptps21791@fpt.edu.vn")
                );
                message.setSubject("CHANGE PASSWORD");
                message.setText("Ðây là mã xác thuc: " + RanDom() + "\n Vui lòng nhap de xac minh");
                
                Transport.send(message);
                
                System.out.println("Done");
                
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    }


