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
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import net.wessendorf.model.Player;

@Named("playersBean")
@SessionScoped
public class ViewParamsBean implements Serializable
{
  @PostConstruct
  public void initPlayers()
  {
    players.add(new Player("Lucas", "Barrios", "Borussia Dortmund"));
    players.add(new Player("Jens", "Wissing", "SC Preußen Münster"));
    players.add(new Player("Matze", "Hain", "St. Pauli"));
  }
  
  public List<Player> getPlayers()
  {
    return players;
  }

  public void setPlayers(List<Player> players)
  {
    this.players = players;
  }

  public Integer getSelect()
  {
    return select;
  }

  public void setSelect(Integer select)
  {
    this.select = select;
  }

  public void selectRightPlayer()
  {
    try
    {
      selectedPlayer = players.get(select);
    }
    catch (Exception e)
    {
      this.selectedPlayer = new Player("Franz", "Beckenbauer", "FC Bayern");
    }
  }

  public Player getSelectedPlayer()
  {
    return selectedPlayer;
  }

  public void setSelectedPlayer(Player selectedPlayer)
  {
    this.selectedPlayer = selectedPlayer;
  }

  private Integer select = null;
  private Player selectedPlayer = null;
  private List<Player> players = new ArrayList<Player>();
  private static final long serialVersionUID = -6614435946482156762L;
}