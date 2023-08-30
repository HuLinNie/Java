package richanglianxi;

public class Ecopy { 
	final static char EOF='#';
	char readKeyboard() {
		return  'w';
	}
	void writePrinter(char ch) {
		
	}
	public void copy() {
		char c;
		while((c=readKeyboard())!=Ecopy.EOF) {
			writePrinter(c);
		}
	}
	public static void main (String[] args) {
		Ecopy ec = new Ecopy();
		ec.copy();
	}
}
