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

- **Enviar um e-mail simples**:


- **Enviar um e-mail com anexo**:


- **Enviar um e-mail com imagem embutida**:


- **Enviar um e-mail para múltiplos destinatários**:


- **Usar um template de e-mail**:

