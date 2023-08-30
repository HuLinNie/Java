package tools;

import java.util.Vector;

public class GeometryHelper {
	public static Point subtract(Point pt1, Point pt2) {
		return new Point(pt1.x - pt2.x, pt1.y - pt2.y);
	}

	public static double crossMultiply(Point vec1, Point vec2) {
		return vec1.x * vec2.y - vec1.y * vec2.x;
	}
	/**
	 * 
	 * @param pt1
	 * @param pt2
	 * @param pt3
	 * @return  ���  pt3-pt1 �� pt2 - pt1
	 */
	public static double crossMultiply(Point pt1, Point pt2,Point pt3) {
		Point vec1  = GeometryHelper.subtract(pt2, pt1);
		Point vec2 =  GeometryHelper.subtract(pt3, pt1);
		return vec1.x * vec2.y - vec1.y * vec2.x;
	}
	public static double distance(Point pt1,Point pt) {
		if (pt == null || pt1 == null)
			return 0;
		double a = Math.abs(pt1.x - pt.x);
		double b = Math.abs(pt1.y - pt.y);
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	/**
	 * �ж϶�����Ƿ���͹����Ρ������ߡ�
	 */
	public static boolean isConvex(Point[] ptArray) {

		Point vec1 = GeometryHelper.subtract(ptArray[1], ptArray[0]);
		Point vec2 = GeometryHelper.subtract(ptArray[2], ptArray[1]);
		int current = MathHelper.dcmp(GeometryHelper.crossMultiply(vec1, vec2));

		for (int i = 3; i < ptArray.length + 2; i++) { // �߽�������ע��
			Point vec3 = GeometryHelper.subtract(ptArray[i % ptArray.length], ptArray[(i - 1) % ptArray.length]);
			int next = MathHelper.dcmp(GeometryHelper.crossMultiply(vec2, vec3));
			if (current * next < 0)
				return false;
			vec1 = vec2;
			vec2 = vec3;
			current = next;
		}
		return true;
	}

	public static int findLeftBottom(Point[] ptArray) {
		int leftBtm = 0;
		for (int i = 1; i < ptArray.length; i++) {
			if (ptArray[i].y < ptArray[leftBtm].y
					|| ptArray[i].y == ptArray[leftBtm].y && ptArray[i].x < ptArray[leftBtm].x) {
				leftBtm = i;
			}
		}
		return leftBtm;
	}

	public static int findNearest(Point pt, Point[] ptArray) {
		int n = 0;

		return n;
	}
	//����ʱ������
	//��˳ʱ�������������MathHelper.dcmp(VectorHelper.cross(ptArray[0], ptArray[nearest], ptArray[j]))  > 0 
	public static void sortVertex(Point[] ptArray) {

		// ��y������С�ĵ� ����λ��0�����y������ͬ����ѡ��x��С��
		int leftBtm = findLeftBottom(ptArray);
		Point tmp = ptArray[0];
		ptArray[0] = ptArray[leftBtm];
		ptArray[leftBtm] = tmp;

		// �Զ��㰴�����PointSet[0]�ļ��Ǵ�С�����������
		// ������ͬ�İ��վ���PointSet[0]�ӽ���Զ��������
		// ѡ������
		for (int i = 1; i < ptArray.length - 1; i++) {
			int nearest = i;
			for (int j = i + 1; j < ptArray.length; j++) {
				int dcmp = MathHelper.dcmp(GeometryHelper.crossMultiply(ptArray[0], ptArray[nearest], ptArray[j]));
				if(dcmp < 0 ) // ѡ�񼫽Ǹ�С�ĵ�,����nearest-0 λ�� j-0 ��࣬nearest�����0��Զ��j�����0�������¼
				{
					nearest = j;
				}
				else if(dcmp ==0 )// �������
				{
					double d1 =  GeometryHelper.distance(ptArray[0], ptArray[j]);
					double d2 =  GeometryHelper.distance(ptArray[0],ptArray[nearest]) ;
					if(d1 < d2)// ѡ�������̵ĵ� 
					{
						nearest = j;
					}
				}
//				else// if(dcmp > 0) 
//				{
//					
//				}
			}
			tmp = ptArray[i];
			ptArray[i] = ptArray[nearest];
			ptArray[nearest] = tmp;
		}
	}
	//ptArray Ϊ��ʱ�������ĵ�����
	//���ص��͹��
	public static Point[] getConvex(Point[] ptArray) {
		
		Vector<Point> ch = new Vector<Point>(ptArray.length);
		ch.add(ptArray[0]);
		ch.add(ptArray[1]);
		int top = 1;
		for (int i = 2; i<ptArray.length; i++) 
		{ 
			while (MathHelper.dcmp( GeometryHelper.crossMultiply(ch.get(top-1), ch.get(top),ptArray[i]) ) < 0 && top > 0) {
				ch.remove(top--);
			}
			ch.add(ptArray[i]);
			top++;
		} 
		Point[] pts = new Point[ch.size()];
		ch.copyInto(pts);
		return pts;
	}
}
