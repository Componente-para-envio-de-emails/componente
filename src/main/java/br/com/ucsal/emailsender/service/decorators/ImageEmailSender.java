package br.com.ucsal.emailsender.service.decorators;

import br.com.ucsal.emailsender.service.EmailSender;
import br.com.ucsal.emailsender.service.JakartaMailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeBodyPart;

import java.io.File;

public class ImageEmailSender extends EmailDecorator {

    public ImageEmailSender(EmailSender decoratedEmailSender) {
        super(decoratedEmailSender);
    }

    @Override
    public void createContent(String body, String source, String filename) {
        super.createContent(body,source,filename);
        if (source != null && filename != null){
            try {
                MimeBodyPart imagePart = new MimeBodyPart();
                imagePart.attachFile(new File(source));
                imagePart.setHeader("Content-ID", "<" + filename + ">");
                imagePart.setDisposition("inline");
                ((JakartaMailSender) decoratedEmailSender).addContent(imagePart);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addContent(MimeBodyPart bodyPart) throws MessagingException {

    }
}
