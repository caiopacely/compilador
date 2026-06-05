# CoachLang

> A linguagem de programacao que acredita no seu potencial.

CoachLang e uma mini-linguagem de programacao imperativa com sintaxe motivacional,
inspirada no universo do coaching e desenvolvimento pessoal.
Cada palavra reservada foi escolhida para reforcar uma mentalidade de crescimento,
tornando a programacao uma experiencia de automotivacao.

---

## Filosofia

| Principio CoachLang | Significado |
|---|---|
| `se_acreditar` | Voce so executa um bloco se realmente acreditar na condicao |
| `se_desistir` | Plano B — se nao acreditar, execute a alternativa sem culpa |
| `enquanto_nao_conquistar` | Persista ate alcancar seu objetivo |
| `seja` | Declare quem voce quer ser (atribuicao) |
| `manifeste` | Manifeste seus resultados para o universo (print) |
| `prospere` | Retorne um valor com prosperidade |
| `jamais` | Negacao absoluta — jamais aceite o contrario |
| `e_tambem` | Conjuncao poderosa — isso E TAMBEM aquilo |
| `ou_entao` | Disjuncao estrategica — isso OU ENTAO aquilo |

---

## Palavras Reservadas

| CoachLang | Tradicional | Tipo |
|---|---|---|
| `se_acreditar` | `if` | Controle de fluxo |
| `se_desistir` | `else` | Controle de fluxo |
| `enquanto_nao_conquistar` | `while` | Repeticao |
| `manifeste` | `print` | Saida |
| `prospere` | `return` | Retorno |
| `seja` | `=` | Atribuicao |
| `jamais` | `!` | Negacao logica |
| `e_tambem` | `&&` | AND logico |
| `ou_entao` | `\|\|` | OR logico |

## Operadores Aritmeticos

| Simbolo | Significado |
|---|---|
| `+` | Adicao |
| `-` | Subtracao / Negacao unaria |
| `*` | Multiplicacao |
| `/` | Divisao |

## Operadores Relacionais

| Simbolo | Significado |
|---|---|
| `>` | Maior que |
| `<` | Menor que |
| `>=` | Maior ou igual |
| `<=` | Menor ou igual |
| `==` | Igual |
| `!=` | Diferente |

## Delimitadores

| Simbolo | Significado |
|---|---|
| `(` `)` | Agrupamento de expressoes |
| `{` `}` | Blocos de codigo |
| `;` | Terminador de comandos |

---

## Gramatica BNF

```
<programa>      ::= <comando>*

<comando>       ::= <se>
                  | <enquanto>
                  | <manifeste>
                  | <prospere>
                  | <atribuicao>
                  | <expressao> ";"

<se>            ::= "se_acreditar" "(" <expressao> ")" <corpo>
                  | "se_acreditar" "(" <expressao> ")" <corpo> "se_desistir" <corpo>

<enquanto>      ::= "enquanto_nao_conquistar" "(" <expressao> ")" <corpo>

<manifeste>     ::= "manifeste" <expressao> ";"

<prospere>      ::= "prospere" <expressao> ";"

<atribuicao>    ::= <identificador> "seja" <expressao> ";"

<corpo>         ::= <comando>
                  | "{" <comando>* "}"

<expressao>     ::= <expressao> "+"  <expressao>
                  | <expressao> "-"  <expressao>
                  | <expressao> "*"  <expressao>
                  | <expressao> "/"  <expressao>
                  | <expressao> ">"  <expressao>
                  | <expressao> "<"  <expressao>
                  | <expressao> ">=" <expressao>
                  | <expressao> "<=" <expressao>
                  | <expressao> "==" <expressao>
                  | <expressao> "!=" <expressao>
                  | <expressao> "e_tambem" <expressao>
                  | <expressao> "ou_entao"  <expressao>
                  | "jamais" <expressao>
                  | "-" <expressao>
                  | "(" <expressao> ")"
                  | <numero>
                  | <identificador>

<numero>        ::= [0-9]+
<identificador> ::= [a-zA-Z_][a-zA-Z0-9_]*
```

## Precedencia de Operadores (da menor para a maior)

| Nivel | Operadores | Associatividade |
|---|---|---|
| 1 | `seja` | Direita |
| 2 | `ou_entao` | Esquerda |
| 3 | `e_tambem` | Esquerda |
| 4 | `==` `!=` `>` `<` `>=` `<=` | Esquerda |
| 5 | `+` `-` | Esquerda |
| 6 | `*` `/` | Esquerda |
| 7 | `jamais` `-` (unario) | Esquerda |

---

## Semantica

### Tipos de dados
CoachLang trabalha exclusivamente com **numeros inteiros**. Valores booleanos sao representados como:
- `1` — verdadeiro (acreditou!)
- `0` — falso (nao acreditou...)

### Variaveis
Variaveis sao criadas dinamicamente no momento da atribuicao e persistem durante toda a sessao.
Nao ha declaracao explicita de tipo.

```
meta seja 365;
```

Tentar ler uma variavel nao atribuida resulta em erro com mensagem motivacional.

### Blocos
Os comandos `se_acreditar`, `se_desistir` e `enquanto_nao_conquistar` aceitam:
- Um unico comando (sem chaves)
- Um bloco de multiplos comandos (entre `{` `}`)

```
se_acreditar (x > 0) manifeste x;

se_acreditar (x > 0) {
    manifeste x;
    prospere 1;
}
```

### Divisao por zero
CoachLang trata divisao por zero com uma mensagem de encorajamento em vez de crashar.

---

## Exemplos

### Exemplo 1: Primeiro programa
```
manifeste 42;
```
Saida: `>> 42`

### Exemplo 2: Variaveis e condicao
```
nota seja 7;
se_acreditar (nota >= 7) {
    manifeste nota;
}
```
Saida: `>> 7`

### Exemplo 3: Loop motivacional
```
foco seja 3;
enquanto_nao_conquistar (foco > 0) {
    manifeste foco;
    foco seja foco - 1;
}
prospere 0;
```
Saida:
```
>> 3
>> 2
>> 1
>>> PROSPEROU: 0
```

### Exemplo 4: Logica com coaching
```
disciplina seja 5;
motivacao seja 3;
se_acreditar (disciplina > 3 e_tambem motivacao > 2) {
    manifeste 100;
} se_desistir {
    manifeste 0;
}
```
Saida: `>> 100`

### Exemplo 5: Contagem regressiva motivacional
```
contador seja 5;
enquanto_nao_conquistar (contador > 0) {
    se_acreditar (contador == 1) {
        manifeste 999;
    } se_desistir {
        manifeste contador;
    }
    contador seja contador - 1;
}
```
Saida:
```
>> 5
>> 4
>> 3
>> 2
>> 999
```

---

## Instalacao e Uso

### Pre-requisitos
- Java JDK 8 ou superior

### Linux
```bash
chmod +x cleanup.sh run.sh    # apenas na primeira vez
./run.sh
```

### Windows
```batch
.\run.bat
```

### Comandos do REPL
- Digite comandos CoachLang terminados em `;`
- Use `exit` para sair
- Blocos `{}` podem ocupar multiplas linhas — o REPL detecta automaticamente

---

## Arquitetura

```
Entrada (CoachLang) → Scanner (JFlex) → Parser (CUP) → Execucao (Java)
```

| Componente | Arquivo | Tecnologia |
|---|---|---|
| Lexer | `calc.flex` | JFlex 1.9.1 |
| Parser | `calc.cup` | Java CUP 11b |
| Driver | `Main.java` | Java |
| Runtime | `parser.java`, `scanner.java`, `sym.java` | Gerados |

---

## Limitacoes

- Apenas numeros inteiros
- Sem suporte a strings ou tipos alem de inteiros
- Sem funcoes definidas pelo usuario
- Booleanos representados como `1`/`0` (sem literais `true`/`false`)
- Sem operadores de input (apenas output com `manifeste`)
