package cells;

import java.awt.Graphics;

public class Cell {

	public boolean alive = false;
	public boolean isAlive(){		return alive;	}
	public void die(){alive = false;}
	public void reborn(){alive = true;}
	
	public void draw(Graphics g,int i,int j,int a){
		g.drawRect(i, j, a, a);
		if(alive){g.fillRect(i, j, a, a);}
	}
}
