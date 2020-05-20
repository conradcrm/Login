package complements;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JDialog;
import javax.swing.JFrame;

import view.Login;
import view.MessageDialog;

public class MoveWindows {
	int xx,xy;
	
	public MoveWindows(Login ini, JFrame frame) {
		Moved moved= new Moved();
		ini.addMouseListener(moved);
		Position position= new Position(frame);
		ini.addMouseMotionListener(position);
	}

	
	public MoveWindows(MessageDialog ini, JDialog dialog) {
		Moved moved= new Moved();
		ini.addMouseListener(moved);
		PositionDialog position= new PositionDialog(dialog);
		ini.addMouseMotionListener(position);
	}
	
	class Moved extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			xx=e.getX();
			xy=e.getY();	
		}
	}
	
	class Position extends MouseMotionAdapter{
		JFrame frame;
		public Position(JFrame frame) {
			this.frame= frame;
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			int x= e.getXOnScreen();
			int y= e.getYOnScreen();
			frame.setLocation(x-xx,y-xy);
		}
	}
	
	class PositionDialog extends MouseMotionAdapter{
		JDialog dialog;
		public PositionDialog(JDialog dialog) {
			this.dialog= dialog;
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			int x= e.getXOnScreen();
			int y= e.getYOnScreen();
			dialog.setLocation(x-xx,y-xy);
		}
	}
	
}
