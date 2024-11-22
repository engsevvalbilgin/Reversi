/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sevval_bilgin_project_reversi;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;


/**
 *
 * @author hp
 */
public class SevvalBilginMyButton extends JButton {

    private int gid;
    public int id;
    public int cx;
    public int cy;
    public char type = 'g';

    public SevvalBilginMyButton(int cx, int cy) {
        super();
        gid++;
        this.setId(gid);
        this.cx = cx;
        this.cy = cy;
        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    MyButtonActionPerformed(evt);
                } catch (Exception ex) {
                    Logger.getLogger(SevvalBilginMyButton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        gid++;
    }
    
    private void MyButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
 
        SevvalBilginMyButton my_button = (SevvalBilginMyButton) evt.getSource();
    
        SevvalBilginData.checkStatus(my_button);

    }

    public int getCx() {
        return cx;
    }

    public int getCy() {
        return cy;
    }

    public void setColor(java.awt.Color color, char c) {
        this.setBackground(color);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.type = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
