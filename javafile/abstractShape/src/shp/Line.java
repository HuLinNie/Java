package shp;


import tools.Point;
import tools.GeometryHelper;

public class Line extends Shape {
	//ShapePoint[] ptArray; // �߶��������㣬��������ĳ���Ϊ2
	public Line(Point[] ptArray) {
		super.name = "line";
		if (ptArray != null && ptArray.length == 2) {
			this.vertexArray = ptArray.clone();
		}
		
	}
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return GeometryHelper.distance(vertexArray[0],vertexArray[1]);
	}

}
