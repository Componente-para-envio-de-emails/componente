package br.com.ucsal.emailsender.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

public class JakartaMailSender implements EmailSender {

    private final String host;
    private final String username;
    private final String password;
    private final Properties properties;
    private MimeMultipart content;

    public JakartaMailSender(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;

        properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
    }

    @Override
    public void sendEmail(String to, String subject) {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(content);

            Transport.send(message);
            System.out.println("Email enviado com sucesso para " + to);
        } catch (MessagingException e) {
            System.out.println("Erro ao enviar email: " + e.getMessage());
        }
    }

    @Override
    public void createContent(String body, String source, String fileName) {
        try {
            MimeMultipart multipart = new MimeMultipart();

            //Por essa ser uma classe de implementação simples, o email vai contar apenas com o texto.
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(body);
            multipart.addBodyPart(textPart);
            this.content = multipart;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addContent(MimeBodyPart bodyPart) throws MessagingException {
        content.addBodyPart(bodyPart);
    }
}
