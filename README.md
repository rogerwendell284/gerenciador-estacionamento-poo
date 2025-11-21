<div align="center">

# 🅿️ Gerenciador de Estacionamento  
### Sistema desenvolvido em **Java**, aplicando os pilares da **Programação Orientada a Objetos (POO)**  

🚗💨 Controle de entrada, saída, tickets, tarifas e vagas — tudo em um projeto simples, objetivo e estruturado para estudos de Java e POO.

---

## 🔰 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white)
![POO](https://img.shields.io/badge/POO-Programação%20Orientada%20a%20Objetos-blue?style=for-the-badge)
![Git](https://img.shields.io/badge/Git-Versionamento-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-Repositório-181717?style=for-the-badge&logo=github)
![Clean Code](https://img.shields.io/badge/Clean%20Code-Práticas%20Recomendadas-brightgreen?style=for-the-badge)

</div>

---

## 📌 Sobre o Projeto

O **Gerenciador de Estacionamento** é uma aplicação desenvolvida com o objetivo de exercitar os fundamentos da **Programação Orientada a Objetos** em Java, utilizando um cenário real e intuitivo: o controle de um estacionamento.

O sistema permite:
- Registrar **entrada de veículos**
- Registrar **saída de veículos** com cálculo de tarifa automática
- Controlar vagas ocupadas e disponíveis
- Gerar e manipular **tickets**
- Listar veículos ativos no estacionamento

Além disso, o projeto foi pensado para reforçar boas práticas, modularidade e organização do código.

---

## 🧠 Pilares de POO Aplicados

| Pilar | Como foi trabalhado |
|-------|----------------------|
| **Abstração** | Modelagem de entidades reais como `Veiculo`, `Estacionamento` e `Ticket` |
| **Encapsulamento** | Uso de atributos privados e métodos públicos de acesso |
| **Herança** | Especialização de tipos de veículos (`Carro`, `Moto`) derivados de `Veiculo` |
| **Polimorfismo** | Manipulação flexível de diferentes tipos de veículos por meio da classe base |

---

## 🚀 Funcionalidades

- 🚗 Registrar entrada de veículos  
- 🏁 Registrar saída e calcular valor devido  
- 📄 Criar tickets com horário de entrada e saída  
- 📊 Controlar e exibir o total de vagas disponíveis  
- 📃 Listar veículos atualmente estacionados  

---

## 🧱 Estrutura do Projeto

```text
src/
 ├── App.java
 ├── Estacionamento.java
 ├── Veiculo.java
 ├── Carro.java
 ├── Moto.java
 └── Ticket.java
