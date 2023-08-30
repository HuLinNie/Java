package neuq.eb.painter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import neuq.eb.shapes.SHAPE_Category;
import neuq.eb.shapes.ShapeCreater;
import neuq.eb.shapes._Shape;

public class Painter extends JFrame { 
	private Vector<_Shape> shapes = new Vector<_Shape>();
	
	private _Shape current = _Shape.NULL;
	private SHAPE_Category shape = SHAPE_Category.NULL;
	
	private JPanel canvas = null;

	public Painter() {
		this.setTitle("Painter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initCanvas();
		initToolBar();
	}

	public void paint(Graphics g) {
		super.paint(g);				//绘制窗体所有组件
		
		Graphics cg = this.canvas.getGraphics();
		for (_Shape s : shapes) {	//绘制已保存的所有图形
			s.draw(cg);
		}
		current.draw(cg);			//绘制当前未正式保存的图形
		cg.dispose();
	}

	private void initCanvas() {
		canvas = new JPanel();
		canvas.setBackground(Color.white);
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON1)
					return;
				current = ShapeCreater.create(shape);
				int x = e.getX();
				int y = e.getY();
				current.setTopleftX(x);
				current.setTopleftY(y);
				current.setBottomrightX(x);
				current.setBottomrightY(y);
			}
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON1)
					return;
				if (current.equals(_Shape.NULL))
					return;
				shapes.add(current);
				current = _Shape.NULL;
			}
		});
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (current.equals(_Shape.NULL))
					return;
				current.setBottomrightX(e.getX());
				current.setBottomrightY(e.getY());
				Painter.this.repaint();
			}
		});
		
		this.add(canvas, BorderLayout.CENTER);
	}

	private void initToolBar() {
		JToolBar toolbar = new JToolBar();
		ButtonGroup btGroup = new ButtonGroup();	
		for(SHAPE_Category shp : SHAPE_Category.values()){
			JRadioButton btShp = new JRadioButton(shp.toString());
			btShp.setBorderPainted(true);
			btShp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					shape = shp;
				}
			});
			toolbar.add(btShp);
			btGroup.add(btShp);
		}
		this.add(toolbar,BorderLayout.NORTH);
	}
}


