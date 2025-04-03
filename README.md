# Gerenciamento de EPIs

Este projeto implementa um sistema de gerenciamento de Equipamentos de Proteção Individual (EPIs), incluindo funcionalidades para empréstimos e devoluções, além do cadastro de usuários e controle de estoque de EPIs.

## Tecnologias Utilizadas
- **Java**
- **Java Collections (ArrayList)**
- **Java Time API (LocalDate)**

## Estrutura do Projeto

O projeto está organizado nas seguintes classes e pacotes:

### Pacote `entidades`

- **`Devolucao`**: Representa a devolução de um EPI emprestado.
- **`Emprestimo`**: Representa um empréstimo de um EPI a um usuário.
- **`Epi`**: Representa um equipamento de proteção individual, incluindo nome e quantidade.
- **`Usuario`**: Representa um usuário do sistema.

### Pacote `gerenciadores`

- **`GerenciadorDevolucao`**: Gerencia as devoluções de EPIs.
- **`GerenciadorEmprestimo`**: Gerencia os empréstimos de EPIs.
- **`GerenciadorEpi`**: Gerencia o cadastro e controle de estoque de EPIs.
- **`GerenciadorUsuario`**: Gerencia o cadastro de usuários.

## Funcionalidades

- **Cadastro de EPIs**
- **Cadastro de Usuários**
- **Empréstimo de EPIs**
- **Devolução de EPIs**
- **Listagem e gerenciamento de EPIs, usuários e empréstimos**

## Como Executar

1. Clone este repositório.

2. Abra o projeto em uma IDE como IntelliJ IDEA ou Eclipse.

3. Compile e execute o código.



## Melhorias Futuras

- Implementação de interface gráfica
- Persistência de dados com banco de dados
- Controle de permissões para usuários

## Autores
Este projeto foi desenvolvido para fins acadêmicos e práticos no estudo de Java.

## Colaboradores  

<table>
  <tr>
    <td align="center">
      <img src="https://github.com/gabibento.png" width="100" style="border-radius:50%"><br>
      <a href="https://github.com/gabibento">Gabriella Maurea</a>
    </td>
    <td align="center">
      <img src="https://github.com/Nathalia-Ohana.png" width="100" style="border-radius:50%"><br>
      <a href="https://github.com/tainaestefani">Nathália Ohana</a>
    </td>
    <td align="center">
      <img src="https://github.com/tainaestefani.png" width="100" style="border-radius:50%"><br>
      <a href="https://github.com/github2">Tainá Estefani</a>
    </td>
  </tr>
</table>
