package frame1;
import java.awt.event.*;
import java.util.EventListener;
public interface WindowListener  extends EventListener{
	public void windowActivated(WindowEvent e);
	public void windowClosed(WindowEvent e);
	public void windowClosing(WindowEvent e);
	public void windowDeactivated(WindowEvent e);
	public void windowDeiconified(WindowEvent e);
	public void windowIconified(WindowEvent e);
	public void windowOpened(WindowEvent e);
}
