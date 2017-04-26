/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.*;

public class Handler implements ActionListener{
    
    private Aplikasi model;
    private View view;
    
    public Handler() {
        model = new Aplikasi();
        view = new View();
        view.setVisible(true);
        view.addActionListener(this);
//        view.setDaftarPeserta(model.viewPeserta());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
