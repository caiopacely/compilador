// Arquivo: AST.java
import java.util.ArrayList;
import java.util.List;

// Classe base para todas as estruturas do nosso código
abstract class Node {
    abstract int executar();
}

// Representa um número solto (ex: 10, 20)
class Numero extends Node {
    int valor;
    Numero(int v) { this.valor = v; }
    int executar() { return valor; }
}

// Representa operações matemáticas e lógicas (+, -, ==, !=)
class Operacao extends Node {
    Node esq, dir;
    String op;
    Operacao(Node e, Node d, String o) { esq = e; dir = d; op = o; }
    
    int executar() {
        int vEsq = esq.executar();
        int vDir = dir.executar();
        switch(op) {
            case "+": return vEsq + vDir;
            case "-": return vEsq - vDir;
            case "==": return (vEsq == vDir) ? 1 : 0;
            case "!=": return (vEsq != vDir) ? 1 : 0;
            default: return 0;
        }
    }
}

// Representa o IF e o ELSE
class ComandoIf extends Node {
    Node condicao, blocoIf, blocoElse;
    
    ComandoIf(Node c, Node bIf, Node bElse) {
        condicao = c; blocoIf = bIf; blocoElse = bElse;
    }
    
    int executar() {
        // Aqui está a mágica do interpretador! Ele decide qual ramo executar.
        if (condicao.executar() == 1) {
            return blocoIf.executar();
        } else if (blocoElse != null) {
            return blocoElse.executar();
        }
        return 0; // Se for falso e não tiver else, não faz nada
    }
}

// Representa o comando Return
class ComandoReturn extends Node {
    Node expressao;
    ComandoReturn(Node e) { expressao = e; }
    
    int executar() {
        int resultado = expressao.executar();
        System.out.println("=> PROGRAMA RETORNOU: " + resultado);
        return resultado;
    }
}