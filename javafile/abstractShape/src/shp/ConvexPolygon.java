package shp;


import tools.Point;
import tools.GeometryHelper;

// concave �������
public class ConvexPolygon extends Shape {

	// ��������ĳ���Ϊ���ڵ���4��Ϊ����εĸ������㣬
	// ����Ӧ��֤�����Ϊ͹����Σ��Ҷ���˳����ʱ���˳ʱ�뷽����������
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
		//������д��������������㣬Ч�ʿ��ܸ���Щ
		for (int i = 0; i < vertexArray.length - 1; i++) {
			perimeter += GeometryHelper.distance(vertexArray[i],vertexArray[i + 1]);
		}
		perimeter += GeometryHelper.distance(vertexArray[0],vertexArray[vertexArray.length - 1]);
		
		return perimeter;
	}
	
}
