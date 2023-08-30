package richanglianxi;

public class Box {
		double  length=1,  width=2, height=3;
		public Box(double length,double  width,double  height) {
			this.length=length;
			this.width=width;
			this.height=height;
			System.out.println(this.height+","+this.length+","+this.width);		
		}
		public static  void main(String []args) {
	 Box b1= new Box(2,3,4);
		 Box b2 = new Box(6,7,8);
		Apple wxh=new Apple("hh");
		}
}
abstract class AFruit{
	protected String name;
	public AFruit(String name) {
		this.name=name;		
	}
	public void dispaly() {
		System.out.println("this is a "+name);
	}
	
}
class Apple extends AFruit{
	public Apple(String name) {
		super(name);
		super.dispaly();
	}

}


