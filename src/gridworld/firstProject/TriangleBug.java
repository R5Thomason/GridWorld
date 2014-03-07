package gridworld.firstProject;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class TriangleBug extends Bug
{
	private int steps;
	private int sideLength;
	private int corners;

	public TriangleBug(int length)
	{
		this.setColor(Color.ORANGE);
		steps = 0;
		sideLength = length;
		corners = 0;
	}

	public void act()
	{
		if (sideLength < 3)
		{
			sideLength = 2;
		}
		if (steps < sideLength && canMove())
		{
			move();
			steps++;
		} else
		{
			if (corners == 2)
			{
				turn();
				turn();
				corners = 0;
				steps = 0;
			} else
			{
				turn();
				turn();
				turn();
				corners++;
				steps = 0;
			}
		}

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
		} else
		{
			removeSelfFromGrid();
		}
		Rock currentRock = new Rock(getColor());
		currentRock.putSelfInGrid(gr, loc);
	}

	public boolean canMove()
	{
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		return (neighbor == null) || (neighbor instanceof Rock);
	}
}
