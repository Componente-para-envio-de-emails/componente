package br.com.ucsal.emailsender.service.decorators;

import br.com.ucsal.emailsender.service.EmailSender;

public abstract class EmailDecorator implements EmailSender {
    protected EmailSender decoratedEmailSender;

    public EmailDecorator(EmailSender decoratedEmailSender){
        this.decoratedEmailSender = decoratedEmailSender;
    }

    @Override
    public void sendEmail(String to, String subject) {
        decoratedEmailSender.sendEmail(to,subject);
    }

    @Override
    public void createContent(String body, String source, String filename) {
        decoratedEmailSender.createContent(body,source,filename);
    }
}
