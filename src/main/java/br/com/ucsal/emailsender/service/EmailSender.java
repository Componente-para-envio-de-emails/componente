package br.com.ucsal.emailsender.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeBodyPart;

public interface EmailSender {
    //Método para enviar email
    void sendEmail(String to, String subject);
    //Método para criar um conteudo para um email
    void createContent(String body, String source, String fileName);
    //Método para adicionar um conteudo para um content
    void addContent(MimeBodyPart bodyPart) throws MessagingException;
}