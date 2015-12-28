package de.jug.cologne.webbeans;

import de.jug.cologne.webbeans.model.CocktailSet;

import java.io.Serializable;
import java.util.Arrays;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Current;
import javax.enterprise.inject.Named;

@RequestScoped
@Named("cocktailBean")
public class CocktailBean implements Serializable {

  private static final long serialVersionUID = -3501169454304213093L;

  private @Current Conversation conversation;

  private @Current CocktailSet cocktails;

  private String result;
  private String cocktail;

  public String startShopping() {
    conversation.begin();
    cocktails.setStarted(true);
    return null;
  }

  public String addCocktail() {
    cocktails.add(this.cocktail);
    return null;
  }

  public String endShopping() {
    cocktails.setStarted(false);
    conversation.end();
    setResult("PROST !!");
    return null;
  }

  public String[] getCocktails() {
    return cocktails.toArray(new String[cocktails.size()]);
  }

  public void setCocktail(String strs) {
    cocktails.addAll(Arrays.asList(strs));
  }

  public String getCocktail() {
    return null;
  }

  public void setResult(String res) {
    result = res;
  }

  public String getResult() {
    return result;
  }
  
  public boolean isInShopping() {
    return cocktails.isStarted();
  }

}
