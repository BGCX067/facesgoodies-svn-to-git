package de.jug.cologne.jsf;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.jug.cologne.model.Player;

@ManagedBean(name="playersBean")
@SessionScoped
public class ViewParamsBean
{
    public ViewParamsBean()
    {
    	players.add(new Player("Alex", "Frei", "BVB 09"));
    	players.add(new Player("Lukas", "Podolski", "FC Kölle"));
    	players.add(new Player("Matze", "Hain", "St. Pauli"));
    }
    
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
    public Integer getSelect() {
		return select;
	}

	public void setSelect(Integer select) {
		this.select = select;
	}
	
	public void selectRightPlayer()
	{
		try
		{
		selectedPlayer = players.get(select);
		}
		catch(Exception e)
		{
		  this.selectedPlayer = new Player("Franz", "Beckenbauer", "FC Bayern");
		}
	}
	
	public Player getSelectedPlayer() {
		return selectedPlayer;
	}

	public void setSelectedPlayer(Player selectedPlayer)
	{
          this.selectedPlayer = selectedPlayer;
	}

	private Integer select = null;
	private Player selectedPlayer = null;
	private List<Player> players = new ArrayList<Player>();
}