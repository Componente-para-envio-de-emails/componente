package br.com.ucsal.emailsender.service.decorators;

import br.com.ucsal.emailsender.service.EmailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeBodyPart;

import java.util.Set;

public class MultiRecipientEmailSender extends EmailDecorator{

    public MultiRecipientEmailSender(EmailSender decoratedEmailSender) {
        super(decoratedEmailSender);
    }

    public void sendEmail(Set<String> recipients, String subject) {
        for (String recipient : recipients) {
            decoratedEmailSender.sendEmail(recipient, subject);
        }
    }

    @Override
    public void createContent(String body, String source, String filename) {
        decoratedEmailSender.createContent(body, source, filename);
    }

    @Override
    public void addContent(MimeBodyPart bodyPart) throws MessagingException {

    }
}
