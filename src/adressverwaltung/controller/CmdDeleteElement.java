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
public class CmdDeleteElement implements CommandInterface
{
  private Surface view;
  private Application model;
  
  public CmdDeleteElement(Surface view, Application model)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
  }

  @Override
  public void undo()
  {
  }
}
