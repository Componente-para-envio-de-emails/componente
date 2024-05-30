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


### Exemplos de Uso

- **Enviar um e-mail simples**:
![simples email](https://github.com/Componente-para-envio-de-emails/componente/assets/94656946/6a52dfc7-a334-48b1-95bd-462d2f5b0e3b)


- **Enviar um e-mail com anexo**:
![email com anexo](https://github.com/Componente-para-envio-de-emails/componente/assets/94656946/ab8f63e8-b699-4c8b-ab83-987aa4e2182c)


- **Enviar um e-mail com imagem embutida**:
![imagem](https://github.com/Componente-para-envio-de-emails/componente/assets/94656946/80e6f829-132f-4e47-8270-4d9e452545af)


- **Enviar um e-mail para múltiplos destinatários**:
![multiplos destinatarios](https://github.com/Componente-para-envio-de-emails/componente/assets/94656946/163e8398-c8e6-46fa-b59e-ecae19931927)


- **Usar um template de e-mail**:
![usar um template](https://github.com/Componente-para-envio-de-emails/componente/assets/94656946/08bb8753-d879-4f86-8d2d-0085eee3e6e0)

