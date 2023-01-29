package com.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class Sender {
    private final MailSender mailSender;

    private String text;
    private String theme;
    private String destination;
    private String sender;
    private String timeToSend;

    private int choice;

    private String path;

    private String brentPrice;

    @Autowired
    public Sender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail() throws IOException, ParseException {
        askForInfo();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(destination);
        message.setFrom(sender);

        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) mailSender;

        javaMailSender.setUsername(sender);
        javaMailSender.setPassword("your personal gmail account`s password"); // *

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    if(choice == 1){
                        brentPrice = ParserUtil.getBrentPrice();
                        text = "Current brent price is " + brentPrice + "$";
                    }
                    message.setText(text);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                mailSender.send(message);
            }
        };

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime time = LocalDateTime.parse(timeToSend, dateFormatter);
        long difference = Duration.between(LocalDateTime.now(), time).getSeconds();

        if(choice == 1){
            theme = "Brent price";
            TermsReader.readTerms(path);
            timer.schedule(timerTask, difference * 1000, TermsReader.period * 1000);
        }
        else {
            timer.schedule(timerTask, difference * 1000);
        }

        message.setSubject(theme);
        message.setText(text);
    }

    private void askForInfo() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("write theme: ");
        theme = bufferedReader.readLine();

        System.out.println("write text: ");
        text = bufferedReader.readLine();

        System.out.println("write sender: ");
        sender = bufferedReader.readLine();

        System.out.println("write destination: ");
        destination = bufferedReader.readLine();

        System.out.println("write time to send. It must fit a pattern yyyy-MM-dd HH:mm: ");
        timeToSend = bufferedReader.readLine();

        System.out.println("if you want to specify additional terms press 1, if not press 0: ");
        choice = Integer.parseInt(bufferedReader.readLine());

        if(choice == 1){
            System.out.println("write file`s absolute path: ");
            path = bufferedReader.readLine();
        }
    }

    public MailSender getMailSender() {
        return mailSender;
    }

    public String getText() {
        return text;
    }

    public String getTheme() {
        return theme;
    }

    public String getDestination() {
        return destination;
    }

    public String getSender() {
        return sender;
    }

    public String getTimeToSend() {
        return timeToSend;
    }
}
