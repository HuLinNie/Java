package richanglianxi;

public class Box2 {
	double  length,  width, height;
	public Box2(double length,double  width,double  height) {
		this.length=length;
		this.width=width;
		this.height=height;
		System.out.println(this.height+","+this.length+","+this.width);
	}
	public String toString() {
		return "{"+this.length+","+this.width+","+this.height+"}";
	}public static void main(String []args) {
		Box2 box1 = new Box2(1,2,3);
		WeightBox box=new WeightBox(7,8,9,10);
		
	}
}
class WeightBox extends Box2{
	double weight;
	public WeightBox(double length,double width,double height,double weight) {
		
		super(length,width,height);
		System.out.println(super.toString());
		this.weight=weight;
		System.out.println(super.toString());
	}
	public String toString() {
		return "{"+length+","+width+","+height+","+weight+"}";
		
	}	
}
