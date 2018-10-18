package field;

import java.util.ArrayList;

import cells.Cell;

public class Field {

	private int height;
	private int width;
	private Cell[][] field ;
	
	public Field(int width, int height){
		this.width = width;
		this.height = height;
		field = new Cell[width][height];		
	}
	
	public void clear(){
		for (int i=0;i<width;i++) 
			for (int j=0;j<height;j++){
				field[i][j] = null;
			}
	}
	
	public Cell get(int x,int y){
		return field[x][y];
	}
	
	public Cell place(int row,int col,Cell s){
		Cell ret =new Cell();
		ret = field[row][col];
		field[row][col] = s;
		return ret;
	}
	
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	public Cell[] getNeighbour(int row,int col){
		ArrayList<Cell> neighbour = new ArrayList<Cell>();
		for(int i = -1;i<2;i++)
			for(int j = -1;j<2;j++){
				int r=row+i;
				int c=col+j;
				if (!(i==0&&j==0)&&r<width&&c<height&&r>-1&&c>-1){
				neighbour.add(field[r][c]);
				}
			}
		return neighbour.toArray(new Cell[neighbour.size()]);
	}
}
