package shp;


import tools.Point;
import tools.GeometryHelper;

public class Line extends Shape {
	//ShapePoint[] ptArray; // 线段两个顶点，参数数组的长度为2
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
