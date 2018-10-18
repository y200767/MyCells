package field;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cells.Cell;

public class View extends JPanel{
	
	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 16;
	private Field theField;

	 
	public View(Field field) {
//		super();
		theField = field;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<theField.getWidth();i++)
			for(int j=0;j<theField.getHeight();j++){
//				g.drawRect(j*GRID_SIZE, i*GRID_SIZE, GRID_SIZE, GRID_SIZE);//自己尝试
				Cell ce = theField.get(i, j);
				if(ce != null){
					ce.draw(g, i*GRID_SIZE, j*GRID_SIZE, GRID_SIZE);
				}
			}
	}

	public static void main(String[] args) {
		Field theField = new Field(10,10);
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++){
				theField.place(i, j, new Cell());
			}
		View view = new View(theField);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("测试标题");
		frame.setResizable(true);
		frame.add(view);
		frame.pack();
		frame.setVisible(true);

	}

}
