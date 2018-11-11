/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung.controller;

import adressverwaltung.model.Application;
import adressverwaltung.view.Surface;

/**
 *
 * @author nobody
 */
public class CmdAddElement implements CommandInterface
{
  private Surface view;
  private Application model;
  public CmdAddElement(Surface view, Application model)
  {
    this.view=view;
    this.model=model; 
  }

  @Override
  public void execute()
  { 
    String eintrag;
    eintrag = "Name: " + view.getTfName().getText() + "\n" +
              "Telefon: " + view.getTfTel().getText() + "\n"+
              "Handy: " + view.getTfHandy().getText() + "\n"+
              "Email: " + view.getTfEmail().getText() + "\n"+
              "**********************************************\n";
    view.getTfOutput().
    
  }

  @Override
  public void undo()
  {
  }
}
