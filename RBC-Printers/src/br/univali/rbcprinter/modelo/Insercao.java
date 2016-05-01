
package br.univali.rbcprinter.modelo;

import br.univali.rbcprinter.controle.Conexao;
import java.text.DecimalFormat;
import java.util.List;

public class Insercao {
    private int id;
    private double similaridade;
    private static DecimalFormat format = new DecimalFormat("#.##");

    public Insercao(int id, double similaridade) {
        this.id = id;
        this.similaridade = similaridade;
    }
    
    public static void insere(List<Insercao> lista, double divisor) {
        Conexao con = new Conexao();
        System.out.println("porra" + divisor);
        //divisor = Double.valueOf(format.format(divisor));
        for (Insercao l : lista) {
            con.alterarSimilaridade(l.id, String.valueOf((l.similaridade*100.0)/divisor));
        }
    }
}
