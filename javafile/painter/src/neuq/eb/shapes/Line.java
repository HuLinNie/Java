package neuq.eb.shapes;

import java.awt.Graphics;

public final class Line extends _Shape{
	@Override
	public void draw(Graphics g) {
		g.drawLine(
				this.topleftX,
				this.topleftY, 
				this.bottomrightX, 
				this.bottomrightY
				);
	}
}
