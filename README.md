# EmailSender

Este projeto fornece uma biblioteca para enviar e-mails com diferentes tipos de conteúdo utilizando o padrão Decorator e Templates. Ele utiliza a API Jakarta Mail para enviar e-mails e permite adicionar anexos, imagens embutidas, enviar e-mails para múltiplos destinatários, e utilizar templates de e-mail.

## Estrutura do Projeto

### Interfaces

- **EnviadorDeEmail**: Define os métodos necessários para enviar e-mails, criar conteúdo e adicionar conteúdo ao e-mail.

### Implementações

- **EnviadorDeEmailJakarta**: Implementa a interface `EnviadorDeEmail` usando a API Jakarta Mail para enviar e-mails.

### Decoradores

- **DecoradorDeEmail**: Classe abstrata que implementa `EnviadorDeEmail` e serve como base para os decoradores concretos.
- **EnviadorDeEmailComArquivo**: Decorador que permite adicionar anexos ao e-mail.
- **EnviadorDeEmailComImagem**: Decorador que permite embutir imagens no e-mail.
- **EnviadorDeEmailParaMultiplosDestinatarios**: Decorador que permite enviar e-mails para múltiplos destinatários.

### Templates

- **EmailTemplate**: Representa um template de e-mail com assunto e corpo.
- **EmailTemplateRepository**: Armazena e gerencia os templates de e-mail.

## Como Usar

### Configuração Inicial

### Exemplos de Uso

- **Enviar um e-mail simples:
EnviadorDeEmail enviador = new EnviadorDeEmailJakarta("smtp.example.com", "usuario@example.com", "senha");
enviador.criarConteudo("Corpo do e-mail", null, null);
enviador.enviarEmail("destinatario@example.com", "Assunto do E-mail");

- **Enviar um e-mail com anexo
EnviadorDeEmail enviador = new EnviadorDeEmailComArquivo(new EnviadorDeEmailJakarta("smtp.example.com", "usuario@example.com", "senha"));
enviador.criarConteudo("Corpo do e-mail", "/caminho/para/anexo.txt", "anexo.txt");
enviador.enviarEmail("destinatario@example.com", "Assunto do E-mail");

- **Enviar um e-mail com imagem embutida
EnviadorDeEmail enviador = new EnviadorDeEmailComImagem(new EnviadorDeEmailJakarta("smtp.example.com", "usuario@example.com", "senha"));
enviador.criarConteudo("Corpo do e-mail", "/caminho/para/imagem.jpg", "imagem.jpg");
enviador.enviarEmail("destinatario@example.com", "Assunto do E-mail");

- **Enviar um e-mail para múltiplos destinatários
Set<String> destinatarios = new HashSet<>(Arrays.asList("dest1@example.com", "dest2@example.com"));
EnviadorDeEmail enviador = new EnviadorDeEmailParaMultiplosDestinatarios(new EnviadorDeEmailJakarta("smtp.example.com", "usuario@example.com", "senha"));
enviador.criarConteudo("Corpo do e-mail", null, null);
((EnviadorDeEmailParaMultiplosDestinatarios) enviador).enviarEmail(destinatarios, "Assunto do E-mail");

- **Usar um template de e-mail
EmailTemplateRepository templateRepository = EmailTemplateRepository.getInstance();
templateRepository.addTemplate("bemVindo", new EmailTemplate("Bem-vindo!", "Olá, seja bem-vindo ao nosso serviço!"));

EmailTemplate template = templateRepository.getTemplate("bemVindo");
EnviadorDeEmail enviador = new EnviadorDeEmailJakarta("smtp.example.com", "usuario@example.com", "senha");
enviador.criarConteudo(template.getBody(), null, null);
enviador.enviarEmail("destinatario@example.com", template.getSubject());
