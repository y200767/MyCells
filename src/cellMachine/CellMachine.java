package cellMachine;

import javax.swing.JFrame;

import cells.Cell;
import field.Field;
import field.View;

public class CellMachine {

	public static void main(String[] args) {
		Field field = new Field(50,50);
		for(int i=0;i<field.getWidth();i++)
			for(int j=0;j<field.getHeight();j++){
				field.place(i, j, new Cell());
			}
		for(int i=0;i<field.getWidth();i++)
			for(int j=0;j<field.getHeight();j++){
				Cell cell =field.get(i,j);
				if(Math.random()<0.2){
					cell.reborn();
				}
			}
		
		View view = new View(field);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("测试标题");
		frame.setResizable(true);
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
//		使用后面代码实现是否重生，是否死亡，是否保持。
		for(int ix =0 ;ix<10;ix++){
			for(int i=0;i<field.getWidth();i++)
				for(int j=0;j<field.getHeight();j++){
//					判断每一个邻居的状态
					int numOfAlive = 0;
					for(Cell c:field.getNeighbour(i, j)){
						if(c.alive) {numOfAlive++;}
					}
					Cell s = new Cell();
					s=field.get(i, j);
					if(field.get(i, j).isAlive()&&(numOfAlive>3||numOfAlive<2)){
						s.die();
						field.place(i, j, s);
					}else if((!field.get(i, j).isAlive())&&numOfAlive==3){
						s.reborn();
						field.place(i, j, s);
					}
						
				}
			frame.repaint();
			System.out.print("----------------------------------");
			System.out.print("UPDATE");
			System.out.println("----------------------------------");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
