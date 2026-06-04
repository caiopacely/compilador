import java_cup.runtime.*;

%%

%class scanner
%unicode
%cup

WHITESPACE = [ \t\n\r]+
DIGIT = [0-9]+
IDENTIFIER = [a-zA-Z_][a-zA-Z0-9_]*

%%

<YYINITIAL> {
    {WHITESPACE}  { /**/ }
    
    /* 1. PALAVRAS-CHAVE (Keywords - Devem vir ANTES de IDENTIFIER) */
    "if"          { return new Symbol(sym.IF); }
    "else"        { return new Symbol(sym.ELSE); }
    "while"       { return new Symbol(sym.WHILE); }
    "return"      { return new Symbol(sym.RETURN); }
    "print"       { return new Symbol(sym.PRINT); }
    
    /* 2. OPERADORES COMPOSTOS (Devem vir ANTES dos simples como '=' ou '>') */
    "=="          { return new Symbol(sym.EQUAL); }
    "!="          { return new Symbol(sym.NOTEQUAL); }
    
    /* 3. OPERADORES SIMPLES */
    ";"           { return new Symbol(sym.SEMI); }
    "+"           { return new Symbol(sym.PLUS); }
    "-"           { return new Symbol(sym.MINUS); }
    "*"           { return new Symbol(sym.TIMES); }
    "/"           { return new Symbol(sym.DIV); }
    ">"           { return new Symbol(sym.BIGGER); }
    "<"           { return new Symbol(sym.MINER); }
    "("           { return new Symbol(sym.LPAREN); }
    ")"           { return new Symbol(sym.RPAREN); }
    "="           { return new Symbol(sym.ASSIGN); }
    
    /* 4. PADRÕES COMPLEXOS */
    {DIGIT}       { return new Symbol(sym.NUMBER, Integer.parseInt(yytext())); }
    {IDENTIFIER}  { return new Symbol(sym.ID, yytext()); }
    
    /* 5. REGRA DE ERRO (OBRIGATORIAMENTE A ÚLTIMA LINHA DO BLOCO) */
    .             { System.err.println("Illegal character: " + yytext()); }
}