/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.sevval_bilgin_project_reversi;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hp
 */
public class sevval_bilgin_project_reversi {

//    public static JFrame LoginFrame;

    public static void main(String[] args)  {
   try {
       
      
        SevvalBilginLogInFrame Login_frame = new SevvalBilginLogInFrame();
        Login_frame.setVisible(true);
     
            SevvalBilginData.ReadFromFileToUserList();

        } catch (IOException ex) {
            Logger.getLogger(sevval_bilgin_project_reversi.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
