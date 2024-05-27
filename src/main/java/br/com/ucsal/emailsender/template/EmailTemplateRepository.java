package br.com.ucsal.emailsender.template;

import java.util.HashMap;
import java.util.Map;

public class EmailTemplateRepository {
    private static EmailTemplateRepository instance;
    private final Map<String, EmailTemplate> templates = new HashMap<>();

    private EmailTemplateRepository() {
        // Construtor privado para evitar instanciar a classe diretamente
    }

    public static synchronized EmailTemplateRepository getInstance() {
        if (instance == null) {
            instance = new EmailTemplateRepository();
        }
        return instance;
    }

    public void addTemplate(String templateName, EmailTemplate template) {
        templates.put(templateName, template);
    }

    public EmailTemplate getTemplate(String templateName) {
        return templates.get(templateName);
    }
}
