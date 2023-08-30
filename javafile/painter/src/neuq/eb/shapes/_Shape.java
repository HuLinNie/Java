package neuq.eb.shapes;

import java.awt.Graphics;

public abstract class _Shape 
{
	public static final _Shape NULL = new _Shape(){
		public void draw(Graphics g){}
	};
	public abstract void draw(Graphics g);
	
	protected int topleftX;
	protected int topleftY;
	protected int bottomrightX;
	protected int bottomrightY;

	public int getTopleftX() {
		return topleftX;
	}
	public void setTopleftX(int topleftX) {
		this.topleftX = topleftX;
	}
	public int getTopleftY() {
		return topleftY;
	}
	public void setTopleftY(int topleftY) {
		this.topleftY = topleftY;
	}
	public int getBottomrightX() {
		return bottomrightX;
	}
	public void setBottomrightX(int bottomrightX) {
		this.bottomrightX = bottomrightX;
	}
	public int getBottomrightY() {
		return bottomrightY;
	}
	public void setBottomrightY(int bottomrightY) {
		this.bottomrightY = bottomrightY;
	}
}

