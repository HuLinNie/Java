package tools;

public class MathHelper {
	public final static double eps = 1e-10;

	public static int dcmp(double x) {
		if (Math.abs(x) < eps)
			return 0;
		else
			return x < 0 ? -1 : 1;
	}
}

