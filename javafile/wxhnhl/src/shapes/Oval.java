package shapes;
import java.awt.Graphics;
public final class Oval extends  _Shape{
	@Override
	public void draw (Graphics g) {
		int w =this.bottomrightX - this.topleftX;
		int h = this.bottomrightY- this.topleftY;
		int x = this.topleftX;
		int y = this.topleftY;
		if (h<0) {
			y=y+h;
		}
		if(w<0) {
			x=x+w;
		}
		g.drawOval(x,y,Math.abs(w),Math.abs(h));
	}

}
