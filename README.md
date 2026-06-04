# 🧮 Interpretador Interativo de Expressões Matemáticas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JFlex](https://img.shields.io/badge/Lexer-JFlex-blue?style=for-the-badge)
![CUP](https://img.shields.io/badge/Parser-Java--CUP-green?style=for-the-badge)

Este projeto consiste num **Interpretador Interativo** para uma linguagem de programação matemática simplificada. Ele analisa o código fornecido pelo utilizador a nível léxico (caracteres) e sintático (regras gramaticais) utilizando as ferramentas **JFlex** e **CUP** para executar comandos em tempo real diretamente na consola.

---

## Funcionalidades Suportadas

* **Operações Aritméticas:** Adição (`+`), Subtração (`-`), Multiplicação (`*`) e Divisão (`/`).
* **Operações Relacionais:** Comparadores maior (`>`), menor (`<`), igual (`==`) e diferente (`!=`).
* **Gestão de Variáveis:** Atribuição dinâmica (ex: `x = 10;`) com persistência em memória durante a sessão (`HashMap`).
* **Estruturas de Controlo:** Condicionais (`if` / `else`) e laços de repetição (`while`).
* **Funções de Output:** Comando `print` dedicado para exibir resultados na consola.

---

## Arquitetura e Fluxo do Compilador

O fluxo de processamento do interpretador segue a arquitetura clássica do Front-End de um compilador:

1. **Entrada do Utilizador:** Uma linha de código terminada em ponto e vírgula (`;`).
2. **Analisador Léxico (`calc.flex`):** O JFlex converte o fluxo de caracteres num fluxo de tokens válidos e ignora os espaços em branco.
3. **Analisador Sintático (`calc.cup`):** O CUP valida se a ordem dos tokens respeita a gramática livre de contexto (CFG) e executa as ações semânticas associadas.
4. **Execução Dinâmica:** Utilização de expressões Lambda do Java (`Supplier` e `Runnable`) para realizar uma avaliação adiada (*lazy evaluation*) e executar os comandos imediatamente.

---

## 📝 Especificações Técnicas

### 1. Analisador Léxico (`calc.flex`)
Define as expressões regulares da linguagem. A ordem das regras é rigorosa para garantir que palavras-chave tenham prioridade sobre identificadores genéricos e que a regra de erro (`.`) seja avaliada por último.

* **Palavras-chave:** `if`, `else`, `while`, `return`, `print`
* **Operadores Compostos:** `==`, `!=`
* **Operadores Simples:** `=`, `>`, `<`, `+`, `-`, `*`, `/`
* **Identificadores:** `[a-zA-Z_][a-zA-Z0-9_]*`
* **Números:** `[0-9]+`

### 2. Analisador Sintático (`calc.cup`)
Define a gramática e as regras de precedência para evitar conflitos de *Ambiguidades (Shift/Reduce)*.

```cup
precedence right ASSIGN;
precedence right ELSE; 
precedence left PLUS, MINUS;
precedence left TIMES, DIV, EQUAL, NOTEQUAL, BIGGER, MINER;
precedence left UMINUS;

```
### Como rodar no Windows
Abra o terminal (PowerShell ou CMD) na raiz do projeto e execute:

Limpar arquivos antigos de cache (Recomendado):

Bash
.\cleanup.bat
Compilar e rodar o interpretador:

Bash
.\run.bat


### Como rodar no Linux
No terminal do Linux, é necessário dar permissão de execução aos ficheiros .sh antes de rodá-los pela primeira vez:

Dar permissão de execução (Apenas na primeira vez):

Bash
chmod +x cleanup.sh run.sh
Limpar arquivos antigos de cache:

Bash
./cleanup.sh
Compilar e rodar o interpretador:

Bash
./run.sh

