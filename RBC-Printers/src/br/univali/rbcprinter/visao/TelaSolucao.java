
package br.univali.rbcprinter.visao;

import br.univali.rbcprinter.controle.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaSolucao extends javax.swing.JFrame {

    private List<Integer> tupla;
    private List<String> tuplaInserida = new ArrayList();
    private String solucao;
    
    public TelaSolucao(List<Integer> tupla, String solucao) {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("RBC Printers - Solução proposta");
        this.setLocationRelativeTo(null);
        this.tupla = tupla;
        this.solucao = solucao;
        labelSolucao.setText(solucao);
        
        buttonAceitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexao con = new Conexao();
                ResultSet rs = con.consultaCaso();
                configuraLista(tupla);
                int count = 0;
                try {
                    while(rs.next()) {
                        for (int i=1; i < 12; i++) {
                            if (tuplaInserida.get(i-1).equals(rs.getString(i+1))) {
                                count++;
                            }
                        }
                        if (count == 11){
                            break;
                        } else count = 0;
                    }
                    if (count != 11) {
                        con.inserirCaso(tuplaInserida.get(0), tuplaInserida.get(1), tuplaInserida.get(2), tuplaInserida.get(3), tuplaInserida.get(4), tuplaInserida.get(5), tuplaInserida.get(6), tuplaInserida.get(7), tuplaInserida.get(8), tuplaInserida.get(9), tuplaInserida.get(10), solucao);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        });
    }
    
    public void configuraLista(List<Integer> tupla) {
        for (int i=0; i < tupla.size(); i++) {
            switch(i) {
                case 0: //  Tipo
                    if (tupla.get(i) == 0)  tuplaInserida.add("Matricial");
                    else tuplaInserida.add("Jato de tinta");
                    break;
                case 1: //  Cabemaneto
                    if (tupla.get(i) == 0)  tuplaInserida.add("USB");
                    if (tupla.get(i) == 1)  tuplaInserida.add("Paralelo");
                    if (tupla.get(i) == 2)  tuplaInserida.add("Ethernet");
                    break;
                case 2: //  Fonte
                    if (tupla.get(i) == 0) tuplaInserida.add("Sim");
                    else tuplaInserida.add("Não");
                    break;
                case 3: // LED Power
                    if (tupla.get(i) == 0) tuplaInserida.add("Ligado");
                    if (tupla.get(i) == 1) tuplaInserida.add("Desligado");
                    if (tupla.get(i) == 2) tuplaInserida.add("Piscando");
                    break;
                case 4: //  LED Processamento
                    if (tupla.get(i) == 0) tuplaInserida.add("Ligado");
                    if (tupla.get(i) == 1) tuplaInserida.add("Desligado");
                    if (tupla.get(i) == 2) tuplaInserida.add("Piscando");
                    break;
                case 5: //  Iluminador scanner
                    if (tupla.get(i) == 0) tuplaInserida.add("Aceso");
                    if (tupla.get(i) == 1) tuplaInserida.add("Apagado");
                    if (tupla.get(i) == 2) tuplaInserida.add("Não possui");
                    break;
                case 6: //  Imprimindo
                    if (tupla.get(i) == 0) tuplaInserida.add("Sim");
                    if (tupla.get(i) == 1) tuplaInserida.add("Não");
                    if (tupla.get(i) == 2) tuplaInserida.add("Impressão falhada");
                    if (tupla.get(i) == 3) tuplaInserida.add("Imprime em branco");
                    break;
                case 7: //  Escaneando
                    if (tupla.get(i) == 0) tuplaInserida.add("Sim");
                    else tuplaInserida.add("Não");
                    break;
                case 8: //  Alimentador
                    if (tupla.get(i) == 0) tuplaInserida.add("Cheio");
                    if (tupla.get(i) == 1) tuplaInserida.add("Poucas folhas");
                    if (tupla.get(i) == 2) tuplaInserida.add("Vazio");
                    break;
                case 9: //  Estufa
                    if (tupla.get(i) == 0) tuplaInserida.add("Sim");
                    else tuplaInserida.add("Não");
                    break;
                case 10://  Tonner
                    if (tupla.get(i) == 0) tuplaInserida.add("Cheio");
                    if (tupla.get(i) == 0) tuplaInserida.add("Poucas carga");
                    if (tupla.get(i) == 0) tuplaInserida.add("Não há tonner");
                    break;                    
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelSolucao = new javax.swing.JLabel();
        buttonAceitar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonAceitar.setText("Aceitar solução");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSolucao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addComponent(buttonAceitar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(buttonAceitar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonAceitar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelSolucao;
    // End of variables declaration//GEN-END:variables
}
