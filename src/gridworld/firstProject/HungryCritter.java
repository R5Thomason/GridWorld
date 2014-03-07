package gridworld.firstProject;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

public class HungryCritter extends Critter
{
	public HungryCritter()
	{
		this.setColor(Color.PINK);
	}
	
	public void processActors(ArrayList<Actor> otherActors)
	{
		for(Actor others : otherActors)
		{
			if(!(others instanceof HungryCritter))
			{
				others.removeSelfFromGrid();
			}
		}
	}
}
