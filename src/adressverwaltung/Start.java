/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung;

import adressverwaltung.controller.ControllerExecute;
import adressverwaltung.view.Surface;

/**
 * Builder Class
 * @author nobody
 */
public class Start
{
  public Start()
  {
    Surface frm = new Surface();
    frm.setVisible(true);
    ControllerExecute controller = new ControllerExecute(frm);
    controller.registerEvents();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) 
  {
    new Start();
  }
}
