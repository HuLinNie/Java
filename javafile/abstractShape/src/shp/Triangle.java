package shp;
import tools.Point;
import tools.GeometryHelper;

public class Triangle extends Shape {

	// ShapePoint[] ptArray; //Èý¶¥µã×ø±ê

	public Triangle(Point[] ptArray) {
		super.name = "triangle";
		if (ptArray != null && ptArray.length == 3) {
			this.vertexArray = ptArray.clone();
		}
		
	}

	@Override
	public double area() {
		double a = GeometryHelper.distance(vertexArray[0],vertexArray[1]);
		double b = GeometryHelper.distance(vertexArray[1],vertexArray[2]);
		double c = GeometryHelper.distance(vertexArray[2],vertexArray[0]);
		return Math.sqrt((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
	}

	@Override
	public double perimeter() {
		double a = GeometryHelper.distance(vertexArray[0],vertexArray[1]);
		double b = GeometryHelper.distance(vertexArray[1],vertexArray[2]);
		double c = GeometryHelper.distance(vertexArray[2],vertexArray[0]);
		return a + b + c;
	}
	public static double getTriangleArea(Point pt1, Point pt2, Point pt3) {
		double a = GeometryHelper.distance(pt1,pt2);
		double b = GeometryHelper.distance(pt2,pt3);
		double c = GeometryHelper.distance(pt3,pt1);
		return Math.sqrt((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
	}
}

