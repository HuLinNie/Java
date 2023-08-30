package shp;


import tools.Point;
import tools.GeometryHelper;

// concave 凹多边形
public class ConvexPolygon extends Shape {

	// 参数数组的长度为大于等于4，为多边形的各个顶点，
	// 顶点应保证多边形为凸多边形，且顶点顺序按逆时针或顺时针方向依次排列
	// ShapePoint[] ptArray;

	public ConvexPolygon(Point[] ptArray) {
		if (ptArray != null && ptArray.length >= 3) {
			this.vertexArray = ptArray.clone();
		}
	}

	@Override
	public double area() {
		double area = 0;
		for (int i = 0; i < vertexArray.length - 2; i++) {
			area += Triangle.getTriangleArea(vertexArray[0], vertexArray[i + 1], vertexArray[i + 2]);
		}
		return area;
	}

	@Override
	public double perimeter() {
		double perimeter = 0;
		
//		for (int i = 0; i < ptArray.length; i++) {
//			perimeter += ptArray[i].getDistance(ptArray[(i + 1) % ptArray.length]);
//		}
		//较上面写法，少了求余计算，效率可能更高些
		for (int i = 0; i < vertexArray.length - 1; i++) {
			perimeter += GeometryHelper.distance(vertexArray[i],vertexArray[i + 1]);
		}
		perimeter += GeometryHelper.distance(vertexArray[0],vertexArray[vertexArray.length - 1]);
		
		return perimeter;
	}
	
}
