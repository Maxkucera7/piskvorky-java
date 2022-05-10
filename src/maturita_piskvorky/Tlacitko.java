/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maturita_piskvorky;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Tlacitko extends JButton{

    public Tlacitko() {
        this.setBackground(Color.white);
        this.setSize(50, 50);
        this.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }
    
    public void zmenStav(){
        if (this.getText().isEmpty()){
            this.setText("X");
        }
        
    }
    
    
}
