package shp;

import tools.Point;

public class ShapeCreater {
	public static Shape createShape(int clsNo, Point[] ptArray) {
		Shape shp = null;
		switch (clsNo) {
		case 0:
			shp = new Line(ptArray);
			break;
		case 1:
			shp = new Triangle(ptArray);
			break;
		case 2:
			shp = new Rectangle(ptArray);
			break;
		case 3:
			shp = new Oval(ptArray);
			break;
		default:
			shp = Shape.NULL;
			break;
		}
		return shp;
	}
}
