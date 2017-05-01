/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Aplikasi;

/**
 *
 * @author BASISDATA
 */
public class Handler implements ActionListener{
    
    private Aplikasi model;
    private View view;
    
    public Handler(){
        model = new Aplikasi();
        view = new View();
        view.setVisible(true);
        view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
