package neuq.eb.shapes;

import java.awt.Graphics;

public final class Rectage extends _Shape {
	@Override
	public void draw(Graphics g) {
		int w = this.bottomrightX - this.topleftX;
		int h = this.bottomrightY - this.topleftY;
		int x = this.topleftX;
		int y = this.topleftY;
		if ( h < 0) {
			y = y + h;
		}
		if (w < 0) {
			x = x + w;
		}
		g.drawRect(x, y, Math.abs(w), Math.abs(h));
	}
}
