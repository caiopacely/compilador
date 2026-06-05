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
    
    /* 1. PALAVRAS-CHAVE (CoachLang) */
    "se_acreditar"                  { return new Symbol(sym.IF); }
    "se_desistir"                   { return new Symbol(sym.ELSE); }
    "enquanto_nao_conquistar"       { return new Symbol(sym.WHILE); }
    "prospere"                      { return new Symbol(sym.RETURN); }
    "manifeste"                     { return new Symbol(sym.PRINT); }
    
    /* 2. OPERADORES COMPOSTOS COACHLANG (Devem vir ANTES dos simples) */
    "jamais"                        { return new Symbol(sym.NOT); }
    "e_tambem"                      { return new Symbol(sym.AND); }
    "ou_entao"                      { return new Symbol(sym.OR); }
    "=="                            { return new Symbol(sym.EQUAL); }
    "!="                            { return new Symbol(sym.NOTEQUAL); }
    ">="                            { return new Symbol(sym.BIGGEREQ); }
    "<="                            { return new Symbol(sym.MINEREQ); }
    
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
    "{"           { return new Symbol(sym.LBRACE); }
    "}"           { return new Symbol(sym.RBRACE); }
    "seja"        { return new Symbol(sym.ASSIGN); }
    
    /* 4. PADRÕES COMPLEXOS */
    {DIGIT}       { return new Symbol(sym.NUMBER, Integer.parseInt(yytext())); }
    {IDENTIFIER}  { return new Symbol(sym.ID, yytext()); }
    
    /* 5. REGRA DE ERRO */
    .             { System.err.println("Illegal character: " + yytext()); }
}
