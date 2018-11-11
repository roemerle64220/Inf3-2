/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressverwaltung.controller;

import adressverwaltung.model.Application;
import adressverwaltung.view.Surface;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;

/**
 *
 * @author Leonhard Römer
 */
public class ControllerExecute implements ActionListener{
    
    private Surface view;
    private Application model;
    File selectedFile;
    private CommandInvoker invoker;
    
    
            
    public ControllerExecute(Surface view, Application model)
    {
        this.view = view;
        this.model = model;
    }
    
    
    
    public void registerEvents()
    {
        view.getMiOpen().addActionListener(this);
        view.getBtnOpen().addActionListener(this);
        view.getBtnAdd().addActionListener(this);
        view.getBtnDelete().addActionListener(this);
    }
            
    public void registerCommands()
    {
        invoker.addCommand(view.getBtnAdd(), 
                           new CmdAddElement(this.view, this.model));
        invoker.addCommand(view.getBtnDelete(), 
                           new CmdDeleteElement(view, model));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        String path;
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        if ((src == view.getMiOpen()||(src == view.getBtnOpen())))
        {                    
            JFileChooser fc = view.getFcOpen();
            if ((path = prefs.get("directory", "NULL")) != "NULL")
            {
                fc.setCurrentDirectory(new File(path));
            }
            int choice = fc.showDialog(view, "Open File");
            if (choice == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = fc.getSelectedFile();
                view.getLbPfad().setText("File: " + selectedFile.getAbsolutePath());
                prefs.put("directory",selectedFile.getParent());
                try{
                    view.getTfOutput().setText(model.loadText(selectedFile));
                }
                catch (FileNotFoundException es)
                {
                    fc.showDialog(null, es.getMessage());
                } 
                catch (IOException ex) {
                    Logger.getLogger(ControllerExecute.class.getName()).log(Level.SEVERE, null, ex);
                }                         
            }
        }
        else
        {
          Component key = (Component)e.getSource();
          invoker.executeCommand(key);
          
        }
            
    }
    
    
    
}
