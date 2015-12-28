package de.jug.cologne.webbeans.model;

import java.util.HashSet;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Named;

@ConversationScoped
@Named
public class CocktailSet extends HashSet<String> {

  private static final long serialVersionUID = 3168113051521759428L;

  private boolean started;

  public boolean isStarted() {
    return started;
  }

  public void setStarted(boolean started) {
    this.started = started;
  }
}
