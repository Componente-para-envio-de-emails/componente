package br.com.ucsal.emailsender.service.decorators;

import br.com.ucsal.emailsender.service.EmailSender;
import br.com.ucsal.emailsender.service.JakartaMailSender;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.Part;
import jakarta.mail.internet.MimeBodyPart;


public class FileEmailSender extends EmailDecorator {

    public FileEmailSender(EmailSender decoratedEmailSender) {
        super(decoratedEmailSender);
    }

    @Override
    public void createContent(String body, String source, String filename) {
        super.createContent(body,source,filename);
        if (source != null && filename != null){
            try {

                MimeBodyPart attachmentPart = new MimeBodyPart();

                DataSource fds = new FileDataSource(source);
                attachmentPart.setDisposition(Part.ATTACHMENT);
                attachmentPart.setDataHandler(new DataHandler(fds));
                attachmentPart.setFileName(fds.getName());

                ((JakartaMailSender) decoratedEmailSender).addContent(attachmentPart);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addContent(MimeBodyPart bodyPart) throws MessagingException {
    }
}
