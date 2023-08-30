package shp;

import java.util.Scanner;
import tools.Point;

public class ShapeTest2 {

	public static void main(String[] args) {
		System.out.println("Which Shape need to be created:");
		System.out.println("Line(0)/Triangle(1)/Rectangle(2)/Oval(3)");
		
		try (Scanner scr = new Scanner(System.in)) {
			String tmp = scr.nextLine();
			int kind = Integer.parseInt(tmp);
			
			System.out.println("please input the point array:");
			tmp =  scr.nextLine();
			Point[] ptArray =Point.fromArrayString(tmp);
			
			Shape shp = ShapeCreater.createShape(kind, ptArray);

			System.out.println("The Shape is " + shp.getName());
			System.out.println("Shape' area is " + shp.area());
			System.out.println("Shape' perimeter is " + shp.perimeter());
			Paint p = new Paint();
			p.doPaint(shp,2);
		}
	}
}

