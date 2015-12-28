/*
 * Copyright (C) 2010 Bernd Bohmann, Matthias Weßendorf.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wessendorf.facesgoodies;

import java.io.Serializable;
import java.util.Arrays;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import net.wessendorf.model.CocktailSet;

@RequestScoped
@Named("cocktailBean")
public class CocktailBean implements Serializable
{

  private static final long serialVersionUID = -3501169454304213093L;

  private @Inject @Default Conversation conversation;

  private @Inject @Default CocktailSet cocktails;

  private String result;
  private String cocktail;

  public String startShopping()
  {
    conversation.begin();
    cocktails.setStarted(true);
    return null;
  }

  public String addCocktail()
  {
    cocktails.add(this.cocktail);
    return null;
  }

  public String endShopping()
  {
    cocktails.setStarted(false);
    conversation.end();
    setResult("PROST !!");
    return null;
  }

  public String[] getCocktails()
  {
    return cocktails.toArray(new String[cocktails.size()]);
  }

  public void setCocktail(String strs)
  {
    cocktails.addAll(Arrays.asList(strs));
  }

  public String getCocktail()
  {
    return null;
  }

  public void setResult(String res)
  {
    result = res;
  }

  public String getResult()
  {
    return result;
  }

  public boolean isInShopping()
  {
    return cocktails.isStarted();
  }

}
