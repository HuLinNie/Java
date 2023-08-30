package shp;



import tools.Point;

public class Oval extends Shape {
	// ShapePoint[] ptArray; // ��Բ��Ӿ��εĶԽ��ߣ���������ĳ���Ϊ2

	public Oval(Point[] ptArray) {
		super.name = "Oval";
		if (ptArray != null && ptArray.length == 2) {
			this.vertexArray = ptArray.clone();
		}
	}

	@Override
	public double area() {
		//��Բ�������᳤�� A B 
		double a = Math.abs(vertexArray[0].x - vertexArray[1].x) / 2;
		double b = Math.abs(vertexArray[0].y - vertexArray[1].y) / 2;
		return Math.PI * a * b;
	}

	@Override
	public double perimeter() {
		double a = Math.abs(vertexArray[0].x - vertexArray[1].x) / 2;
		double b = Math.abs(vertexArray[0].y - vertexArray[1].y) / 2;
		if (a > b) {
			return 2 * Math.PI * b + 4 * (a - b);
		} else {
			return 2 * Math.PI * a + 4 * (b - a);
		}
	}
}

