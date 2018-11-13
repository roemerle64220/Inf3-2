/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressverwaltung.controller;

import adressverwaltung.model.Application;
import adressverwaltung.view.Surface;
import java.util.Stack;

/**
 *
 * @author nobody
 */
public class CmdDeleteElement implements CommandInterface
{
  private Surface view;
  private Application model;
  private Stack<String> deletedElements;
  
  public CmdDeleteElement(Surface view, Application model)
  {
    this.view = view;
    this.model = model;
    this.deletedElements = new Stack();
  }

  @Override
  public void execute()
  {
        String eintrag;
      
        eintrag =   "Name: " + view.getTfName().getText() + "\n" +
                    "Telefon: " + view.getTfTel().getText() + "\n"+
                    "Handy: " + view.getTfHandy().getText() + "\n"+
                    "Email: " + view.getTfEmail().getText() + "\n\n";
        
        if (view.getTaOuput().getText().contains(eintrag))
                {
                    view.getTaOuput().setText(view.getTaOuput().getText().
                    replaceAll(eintrag,""));
                    deletedElements.push(eintrag);
                }                          
  }

  @Override
  public void undo()
  {
      view.getTaOuput().setText(view.getTaOuput().getText()+
                        deletedElements.pop());
  }
}
 