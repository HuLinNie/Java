package shp;
public class Paint {
	public double getPaintQuantity(double area,double thickness) {
		return area * thickness;
	}
	public void doPaint(Shape shp,double h) {
		double area = shp.area();
		double q = this.getPaintQuantity(area, h);
		//‡ŠÆá
		System.out.println(q + " Painted!");
	}
}
