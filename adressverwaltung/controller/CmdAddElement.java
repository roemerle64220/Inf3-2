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
public class CmdAddElement implements CommandInterface
{
  private Surface view;
  private Application model;
  private Stack<String> addedElements;
  
  public CmdAddElement(Surface view, Application model)
  {
    this.view=view;
    this.model=model;
    addedElements=new Stack();
  }

  @Override
  public void execute()
  { 
    String eintrag;
    eintrag = "Name: " + view.getTfName().getText() + "\n" +
              "Telefon: " + view.getTfTel().getText() + "\n"+
              "Handy: " + view.getTfHandy().getText() + "\n"+
              "Email: " + view.getTfEmail().getText() + "\n\n";
    addedElements.push(eintrag);
    view.getTaOuput().setText(view.getTaOuput().getText()+eintrag);
  }

  @Override
  public void undo()
  {
      if (!addedElements.empty())
      {
          view.getTaOuput().setText(view.getTaOuput().getText().replaceAll(addedElements.pop(),""));
      }
  }
}
