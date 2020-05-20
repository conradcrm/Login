package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import complements.MoveWindows;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MessageDialog extends JPanel implements ActionListener,MouseListener{
	private Color BG_BTNCOLOR = new Color(255, 50, 65);
	private static MessageDialog messageDialog;
	private JLabel lblMessage;
	private JButton btnYes, btnNo;
	private JButton btnExit;
	private JDialog frame;
	
	//Borra esto xd es solo para la prueba
	  public static MessageDialog get(String message) {
	    	if(messageDialog == null) messageDialog = new MessageDialog(message);
	    	return messageDialog;
	  }
	  //
	public MessageDialog(String mensaje) {
		
		frame=new JDialog();
		MoveWindows moveWindows= new MoveWindows(this, frame);
		frame.getContentPane().add(this);
		frame.setSize(460, 215);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setModal(true);
		setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 492, 176);
		setLayout(null);

		lblMessage = new JLabel(mensaje);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessage.setBounds(10, 40, 440, 24);
		add(lblMessage);
		
		btnYes = new JButton("Yes");
		btnYes.setBackground(BG_BTNCOLOR);
		btnYes.setBorder(null);
		btnYes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnYes.setForeground(Color.WHITE);
		btnYes.setFocusable(false);
		btnYes.setBounds(286, 170, 66, 24);
		add(btnYes);

		btnExit = new JButton("X");
		btnExit.setFont(new Font("Dubai Light", Font.PLAIN, 14));
		btnExit.setBorder(null);
		btnExit.setBackground(Color.WHITE);
		btnExit.setFocusable(false);
		btnExit.setBounds(425, 6, 25, 25);
		add(btnExit);

		btnNo = new JButton("No");			
		btnNo.setForeground(Color.BLACK);
		btnNo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNo.setBackground(Color.WHITE);
		btnNo.setFocusable(false);
		btnNo.setBorder(new LineBorder(new Color(192, 192, 192)));
		btnNo.setBounds(370, 170, 66, 24);
		add(btnNo);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(80, 200, 80));
		separator.setBounds(10, 70, 440, 1);
		add(separator);
		
		JLabel icon = new JLabel();
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setIcon(new ImageIcon(MessageDialog.class.getResource("/images/icon_message/decision.png")));
		icon.setBounds(52, 80, 160, 119);
		add(icon);
		
		btnExit.addActionListener(this);
		btnYes.addActionListener(this);
		btnNo.addActionListener(this);
		
		btnExit.setActionCommand("NO");
		btnYes.setActionCommand("YES");
		btnNo.setActionCommand("NO");
		
		btnExit.addMouseListener(this);
		btnYes.addMouseListener(this);
		btnNo.addMouseListener(this);
		
		
		frame.setVisible(true);
	}

	public void shooseOption(Color colorb,Color colorf) {
			btnExit.setBackground(colorb);
			btnExit.setForeground(colorf);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comanString = e.getActionCommand();
		switch (comanString) {	
		case "YES":
			System.exit(0);
			break;
		case "NO":
			frame.dispose();
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnExit) {
			btnExit.setBackground(BG_BTNCOLOR);
			btnExit.setForeground(Color.WHITE);
		}
		if(e.getSource()==btnYes) btnYes.setBackground(new Color(255, 95, 95));
		if (e.getSource()==btnNo) btnNo.setBackground(new Color(225,225,225));
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnExit) {
			btnExit.setBackground(Color.WHITE);
			btnExit.setForeground(Color.BLACK);
		}
		if(e.getSource()==btnYes) btnYes.setBackground(BG_BTNCOLOR);
		if (e.getSource()==btnNo) btnNo.setBackground(new Color(255,255,255));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}