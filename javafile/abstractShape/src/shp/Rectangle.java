package shp;

import tools.Point;

public class Rectangle extends Shape {
	// ShapePoint[] ptArray; // 矩形的对角线，参数数组的长度为2

	public Rectangle(Point[] ptArray) {
		if(ptArray[0].x==ptArray[1].x||ptArray[0].y==ptArray[1].y) {
			System.out.println("只能构成一条直线，构不成矩形");
		}
			
		super.name = "rectangle";
		if (ptArray != null && ptArray.length == 2) {
			this.vertexArray = ptArray.clone();
		}
	}

	@Override
	public double area() {
		double a = Math.abs(vertexArray[0].x - vertexArray[1].x);
		double b = Math.abs(vertexArray[0].y - vertexArray[1].y);
		return a * b;
	}

	@Override
	public double perimeter() {
		double a = Math.abs(vertexArray[0].x - vertexArray[1].x);
		double b = Math.abs(vertexArray[0].y - vertexArray[1].y);
		return 2 * (a + b);
	}
}
