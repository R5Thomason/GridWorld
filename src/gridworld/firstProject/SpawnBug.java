package gridworld.firstProject;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class SpawnBug extends Bug
{
	public SpawnBug()
	{
		this.setColor(Color.MAGENTA);
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
		Location backRight = loc.getAdjacentLocation(90);
		Location backLeft = loc.getAdjacentLocation(270);

		if (gr.isValid(next))
		{
			moveTo(next);
		} else
		{
			removeSelfFromGrid();
		}
		SpawnBug backBug = new SpawnBug();
		backBug.putSelfInGrid(gr, loc);
		SpawnBug backLeftBug = new SpawnBug();
		SpawnBug backRightBug = new SpawnBug();
		if (gr.isValid(backRight))
		{
			backLeftBug.putSelfInGrid(gr, backRight);
		}
		if (gr.isValid(backLeft))
		{
			backRightBug.putSelfInGrid(gr, backLeft);
		}

	}

}
