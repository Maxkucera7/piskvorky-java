
package maturita_piskvorky;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Okno extends javax.swing.JFrame {
    Tlacitko poleTlacitek[][];
    boolean hrac1 = false;
   
    public Okno() {
        initComponents();
        this.setSize(700, 700);
    }
    
    public void vytvorPole(int velikost){
        //System.out.println(velikost);
        poleTlacitek = new Tlacitko[velikost][velikost];
        
        for (int i = 0; i < poleTlacitek.length; i++) {
            for (int j = 0; j < poleTlacitek[i].length; j++) {
                Tlacitko aktualniTlacitko;
                poleTlacitek[i][j] = new Tlacitko();
                poleTlacitek[i][j].setLocation(i*50+100, j*50+100);
                aktualniTlacitko = poleTlacitek[i][j];
                poleTlacitek[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(aktualniTlacitko.getText() == ""){
                            if(hrac1){
                                aktualniTlacitko.setText("X");
                            }else{
                                aktualniTlacitko.setText("O");
                            }
                            hrac1 = !hrac1;
                            zkontrolujViteze();
                        }
                       
                    }
                });
                this.add(poleTlacitek[i][j]);
            }
        }
        this.repaint();       
    }
    
    
    public void zkontrolujViteze(){
        int serie = 0;
        int serie2 = 0;
        //SVISLE
        for (int i = 0; i < poleTlacitek.length; i++) {
            for (int j = 0; j < poleTlacitek[i].length; j++) {
                if (poleTlacitek[i][j].getText() == "X"){
                    serie++;
                    if(serie == 5){
                        JOptionPane.showMessageDialog(this, "Vyhrál hráč s X!");
                        smazTlacitka();
                    }
                }else{
                    serie = 0;
                }
                if (poleTlacitek[i][j].getText() == "O"){
                    serie2++;
                    if(serie2 == 5){
                        JOptionPane.showMessageDialog(this, "Vyhrál hráč s O!");
                        smazTlacitka();
                    }
                }else{
                    serie2 = 0;
                }
            }
            serie = 0;
            serie2 = 0;
        }
        //VODOROVNE
        for (int i = 0; i < poleTlacitek.length; i++) {
            for (int j = 0; j < poleTlacitek[i].length; j++) {
                if (poleTlacitek[j][i].getText() == "X"){
                    serie++;
                    if(serie == 5){
                        JOptionPane.showMessageDialog(this, "Vyhrál hráč s X!");
                        smazTlacitka();
                    }
                }else{
                    serie = 0;
                }
                if (poleTlacitek[j][i].getText() == "O"){
                    serie2++;
                    if(serie2 == 5){
                        JOptionPane.showMessageDialog(this, "Vyhrál hráč s O!");
                        smazTlacitka();
                    }
                }else{
                    serie2 = 0;
                }
            }
            serie = 0;
            serie2 =0;
        }
        //DIAGONALNE
        
        for (int i = 0; i < poleTlacitek.length; i++) {
            for (int j = 0; j < poleTlacitek[i].length; j++) {
                
            }
        }
        
    }
    public void smazTlacitka(){
        for (int i = 0; i < poleTlacitek.length; i++) {
            for (int j = 0; j < poleTlacitek[i].length; j++) {
                this.remove(poleTlacitek[i][j]);
            }
        }
        repaint();
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vstupniVelikost = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vstupniVelikost.setPreferredSize(new java.awt.Dimension(100, 26));

        submitButton.setText("Potvrdit");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(vstupniVelikost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(submitButton)
                .addContainerGap(489, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vstupniVelikost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addContainerGap(458, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        int vstupniCislo;
        if (vstupniVelikost.getText().isEmpty()){
            System.out.println("Zadej cele cislo!!");
        }else{
            try {
                vstupniCislo = Integer.parseInt(vstupniVelikost.getText());
                if (vstupniCislo > 5){
                    vytvorPole(vstupniCislo);
                }
                
            } catch (Exception e) {
                System.out.println("Zadej cele cislo!");
            }
        } 
        
        //mame velikost pole yeey    
    }//GEN-LAST:event_submitButtonMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField vstupniVelikost;
    // End of variables declaration//GEN-END:variables
}
