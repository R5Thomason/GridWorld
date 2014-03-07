package gridworld.firstProject;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class DeathRock extends Rock
{
	public DeathRock()
	{
		this.setColor(Color.BLUE);
	}

	public void act()
	{
		if (getGrid() == null)
		{
			return;
		}
		ArrayList<Actor> neighbors = getActors();
		processActors(neighbors);
	}

	public void processActors(ArrayList<Actor> otherActors)
	{
		for (Actor neighbor : otherActors)
		{
			neighbor.removeSelfFromGrid();
		}
	}

	public ArrayList<Actor> getActors()
	{
		return getGrid().getNeighbors(getLocation());
	}
}
