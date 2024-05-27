package br.com.ucsal.emailsender.template;

public class EmailTemplate {
    private String subject;
    private String body;

    public EmailTemplate(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
