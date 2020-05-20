package complements;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MoveWindows {
	int xx,xy;
	
	public MoveWindows(JPanel ini, JFrame frame) {
		MovedFrame movedFrame= new MovedFrame();
		ini.addMouseListener(movedFrame);
		PositionFrame positionFrame= new PositionFrame(frame);
		ini.addMouseMotionListener(positionFrame);
	}
	
	class MovedFrame extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			xx=e.getX();
			xy=e.getY();	
		}
	}
	//********************Permite cambiar la posicion del frame**************************//
	class PositionFrame extends MouseMotionAdapter{
		JFrame frame = new JFrame();
		public PositionFrame(JFrame frame) {
			this.frame= frame;
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			int x= e.getXOnScreen();
			int y= e.getYOnScreen();
			frame.setLocation(x-xx,y-xy);
		}
	}
	
}
