
package br.univali.rbcprinter.modelo;

import br.univali.rbcprinter.controle.Conexao;
import java.util.List;

public class Insercao {
    private int id;
    private double similaridade;

    public Insercao(int id, double similaridade) {
        this.id = id;
        this.similaridade = similaridade;
    }
    
    public static void insere(List<Insercao> lista, double divisor) {
        Conexao con = new Conexao();
        for (Insercao l : lista) {
            con.alterarSimilaridade(l.id, (l.similaridade*100.0)/divisor);
        }
    }
}