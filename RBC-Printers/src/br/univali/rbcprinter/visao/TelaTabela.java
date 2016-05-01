
package br.univali.rbcprinter.visao;

import br.univali.rbcprinter.controle.Conexao;
import br.univali.rbcprinter.modelo.Insercao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaTabela extends javax.swing.JFrame {
    private double[][] mCabeamento = new double[3][3];
    private double[][] mLEDPower = new double[3][3];
    private double[][] mLEDProcessamento = new double[3][3];
    private double[][] mTampa = new double[3][3];
    private double[][] mImprimindo = new double[4][4];
    private double[][] mAlimentador = new double[3][3];
    private double[][] mTonner = new double[3][3];
    private double[] pesos = {0.8, 0, 1, 1, 0.3, 0.5, 1, 1, 0.8, 0.3, 0.8};
    private double somatorioPesosSimilaridade = 0;
    
    public TelaTabela(List<Integer> tupla) {
        initComponents();
        this.setTitle("RBC Printers - Tabela de similaridade");
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        tableCasos.setRowSelectionAllowed(true);
        configuraTabelas();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cabo");
        modelo.addColumn("Fonte");
        modelo.addColumn("LED Power");
        modelo.addColumn("LED Processamento");
        modelo.addColumn("Iluminador Scanner");
        modelo.addColumn("Imprimindo");
        modelo.addColumn("Escaneando");
        modelo.addColumn("Alimnetador");
        modelo.addColumn("Estufa");
        modelo.addColumn("Tonner");
        modelo.addColumn("Solução");
        modelo.addColumn("Similaridade");
        
        double somatorioSimilaridade = 0;
        String[] vetorModel = new String[14]; // Tem id e solução + percentual
        List<Insercao> listaInsercoes = new ArrayList<>();
        String aux;
        Conexao con = new Conexao();
        ResultSet rs = con.consultaCaso();
        try {
            while (rs.next()) {
                for (int i=0; i < 13; i++) {
                    if (i != 0 && i < 12) {
                        somatorioSimilaridade += pesos[i-1] * sim(tupla.get(i-1), getIndexTabela(rs.getString(i), i), i);
                    }
                }
                System.out.println(somatorioSimilaridade);
                listaInsercoes.add(new Insercao(Integer.valueOf(rs.getString(1)), somatorioSimilaridade));
                this.somatorioPesosSimilaridade += somatorioSimilaridade;
                somatorioSimilaridade = 0;
            }
            Insercao.insere(listaInsercoes, this.somatorioPesosSimilaridade);
            rs = con.consultaCasoOrdenado();
            while (rs.next()) {
                for (int i=0; i < 14; i++) {
                    vetorModel[i] = rs.getString(i+1);
                }
                modelo.addRow(vetorModel);
            }
            tableCasos.setModel(modelo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public double sim(int a1, int a2, int index) {
        switch (index) {
            case 1: //  Tipo
                return (a1 == a2) ? 1 : 0;
            case 2: // Cabo
                return mCabeamento[a1][a2];
            case 3: //  Fonte
                return (a1 == a2) ? 1 : 0;
            case 4: //  LED Power
                return mLEDPower[a1][a2];
            case 5: //  LED Processamento
                return mLEDProcessamento[a1][a2];
            case 6: //  Iluminador scanner
                return mTampa[a1][a2];
            case 7: //  Imprimindo
                return mImprimindo[a1][a2];
            case 8: //  Escanenando
                return (a1 == a2) ? 1 : 0;
            case 9: //  Alimentador
                return mAlimentador[a1][a2];
            case 10://  Estufa
                return (a1 == a2) ? 1 : 0;
            case 11://  Tonner
                return mTonner[a1][a2];
        }
        return 0;
    }
    
    public int getIndexTabela(String r, int i) {
        switch(i) {
            case 1: //  Tipo
                if (r.equals("Matricial")) return 0;
                else return 1;
            case 2: //  Cabeamento
                if (r.equals("USB")) return 0;
                if (r.equals("Paralelo")) return 1;
                if (r.equals("Ethernet")) return 2;
            case 3: //  Fonte
                if (r.equals("Sim")) return 0;
                else return 1;
            case 4: //  LED Power
                if (r.equals("Ligado")) return 0;
                if (r.equals("Desligado")) return 1;
                if (r.equals("Piscando")) return 2;
            case 5: //  LED Processamento
                if (r.equals("Ligado")) return 0;
                if (r.equals("Desligado")) return 1;
                if (r.equals("Piscando")) return 2;
            case 6: //  Iluminador scanner
                if (r.equals("Aceso")) return 0;
                if (r.equals("Apagado")) return 1;
                if (r.equals("Não possui")) return 2;
            case 7: //  Imprimindo
                if (r.equals("Sim")) return 0;
                if (r.equals("Não")) return 1;
                if (r.equals("Impressão falhada")) return 2;
                if (r.equals("Imprime em branco")) return 3;
            case 8: //  Escanenado
                if (r.equals("Sim")) return 0;
                else return 1;
            case 9: //  Alimentador
                if (r.equals("Cheio")) return 0;
                if (r.equals("Poucas folhas")) return 1;
                if (r.equals("Vazio")) return 2;
            case 10://  Estufa
                if (r.equals("Sim")) return 0;
                else return 1;
            case 11://  Tonner
                if (r.equals("Cheio")) return 0;
                if (r.equals("Pouca carga")) return 1;
                if (r.equals("Não há tonner")) return 2;
        }
        return 0;
    }
    
    public void configuraTabelas() {
        mCabeamento[0][0] = 1;
        mCabeamento[0][1] = 0.5;
        mCabeamento[0][2] = 0;
        mCabeamento[1][0] = 0.5;
        mCabeamento[1][1] = 1;
        mCabeamento[1][2] = 0;
        mCabeamento[2][0] = 0;
        mCabeamento[2][1] = 0;
        mCabeamento[2][2] = 1;
        //  --
        mLEDPower[0][0] = 1;
        mLEDPower[0][1] = 0;
        mLEDPower[0][2] = 0.1;
        mLEDPower[1][0] = 0;
        mLEDPower[1][1] = 1;
        mLEDPower[1][2] = 0;
        mLEDPower[2][0] = 0.1;
        mLEDPower[2][1] = 0;
        mLEDPower[2][2] = 1;
        //  --
        mLEDProcessamento[0][0] = 1;
        mLEDProcessamento[0][1] = 0;
        mLEDProcessamento[0][2] = 0.1;
        mLEDProcessamento[1][0] = 0;
        mLEDProcessamento[1][1] = 1;
        mLEDProcessamento[1][2] = 0;
        mLEDProcessamento[2][0] = 0.1;
        mLEDProcessamento[2][1] = 0;
        mLEDProcessamento[2][2] = 1;
        //  --
        mTampa[0][0] = 1;
        mTampa[0][1] = 0;
        mTampa[0][2] = 0;
        mTampa[1][0] = 0;
        mTampa[1][1] = 1;
        mTampa[1][2] = 0;
        mTampa[2][0] = 0;
        mTampa[2][1] = 0;
        mTampa[2][2] = 1;
        //   --
        mImprimindo[0][0] = 1;
        mImprimindo[0][1] = 0;
        mImprimindo[0][2] = 0.5;
        mImprimindo[0][3] = 0.5;
        mImprimindo[1][0] = 0;
        mImprimindo[1][1] = 1;
        mImprimindo[1][2] = 0;
        mImprimindo[1][3] = 0;
        mImprimindo[2][0] = 0.5;
        mImprimindo[2][1] = 0;
        mImprimindo[2][2] = 1;
        mImprimindo[2][3] = 0.5;
        mImprimindo[3][0] = 0.5;
        mImprimindo[3][1] = 0;
        mImprimindo[3][2] = 0.5;
        mImprimindo[3][3] = 1;
        //  --
        mAlimentador[0][0] = 1;
        mAlimentador[0][1] = 0;
        mAlimentador[0][2] = 0;
        mAlimentador[1][0] = 0;
        mAlimentador[1][1] = 1;
        mAlimentador[1][2] = 0.2;
        mAlimentador[2][0] = 0;
        mAlimentador[2][1] = 0.2;
        mAlimentador[2][2] = 1;
        //  --
        mTonner[0][0] = 1;
        mTonner[0][1] = 0;
        mTonner[0][2] = 0;
        mTonner[1][0] = 0;
        mTonner[1][1] = 1;
        mTonner[1][2] = 0.2;
        mTonner[2][0] = 0;
        mTonner[2][1] = 0.2;
        mTonner[2][2] = 1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        labelDica = new javax.swing.JLabel();
        scrollPaneTabela = new javax.swing.JScrollPane();
        tableCasos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelDica.setText("Clique duas vezes sobre um item para expandir a solução.");

        tableCasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneTabela.setViewportView(tableCasos);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelDica)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(scrollPaneTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDica;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPaneTabela;
    private javax.swing.JTable tableCasos;
    // End of variables declaration//GEN-END:variables
}
