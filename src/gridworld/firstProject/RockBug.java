package gridworld.firstProject;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class RockBug extends Bug
{
    public RockBug()
    {
	this.setColor(Color.GREEN);
    }
    
    public void move()
    {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	{
	    return;
	}
	
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	
	if (gr.isValid(next))
	{
	    moveTo(next);
	}
	else
	{
	    removeSelfFromGrid();
	}
	Rock currentRock = new Rock(getColor());
	currentRock.putSelfInGrid(gr, loc);
    }
    
}
