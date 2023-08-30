package shapes;
public class ShapeCreater {
	public static _Shape create(SHAPE_Category shape) {
		if(shape == null)
			return _Shape.NULL;
		switch(shape) {
		case LINE:
			return new Line();
		case RECTAGE:
			return new Rectage();
		case OVAL:
			return new Oval();
		default:
			return _Shape.NULL;
		}		
	}
}
