package shp;
import tools.Point;

public abstract class Shape {
	public static Shape NULL = new Shape() {
		{
			name = "NULL";
			vertexArray = new Point[0];
		}
		public double area() {
			return 0;
		};
		public double perimeter() {
			return 0;
		};
	};
	protected String name;
	
	protected Point[] vertexArray;

	public abstract double area();

	public abstract double perimeter();

	public String getName() {
		return name;
	}
}
