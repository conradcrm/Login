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

public class Pop_up extends JPanel implements ActionListener,MouseListener{
	private Color BGSI = new Color(255, 50, 65);
	private static Pop_up pop_up;
	private JLabel lblMensaje;
	private JButton btnSi, btnNo;
	private JButton btnSalir;
	private JDialog frame;
	
	//Borra esto xd es solo para la prueba
	  public static Pop_up get(String message) {
	    	if(pop_up == null) pop_up = new Pop_up(message);
	    	return pop_up;
	  }
	  //
	public Pop_up(String mensaje) {
		
		frame=new JDialog();
		frame.getContentPane().add(this);
		frame.setSize(460, 215);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setModal(true);
		setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 492, 176);
		setLayout(null);

		lblMensaje = new JLabel(mensaje);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensaje.setBounds(30, 60, 388, 24);
		add(lblMensaje);
		
		btnSi = new JButton("Si");
		btnSi.setBackground(BGSI);
		btnSi.setBorder(null);
		btnSi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnSi.setForeground(Color.WHITE);
		btnSi.setFocusable(false);
		btnSi.setBounds(266, 170, 66, 24);
		add(btnSi);

		btnSalir = new JButton("X");
		btnSalir.setFont(new Font("Dubai Light", Font.PLAIN, 14));
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setFocusable(false);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(425, 6, 25, 25);
		add(btnSalir);

		btnNo = new JButton("No");			
		btnNo.setForeground(Color.BLACK);
		btnNo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNo.setBackground(Color.WHITE);
		btnNo.setFocusable(false);
		btnNo.setBorder(new LineBorder(new Color(192, 192, 192)));
		btnNo.setBounds(350, 170, 66, 24);
		add(btnNo);

		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("NO");
		btnSi.addActionListener(this);
		btnSi.setActionCommand("SI");
		btnNo.addActionListener(this);
		btnNo.setActionCommand("NO");
		
		btnSalir.addMouseListener(this);
		btnSi.addMouseListener(this);
		btnNo.addMouseListener(this);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(80, 200, 80));
		separator.setBounds(10, 40, 440, 1);
		add(separator);
		
		frame.setVisible(true);
	}

	public void shooseOption(MouseEvent e, Color color) {
		if(e.getSource()==btnSalir)
			btnSalir.setBackground(color);
		else if(e.getSource()==btnSi) {
			btnSi.setBackground(BGSI);
		}
		else
			btnNo.setBackground(new Color(255,255,255));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comanString = e.getActionCommand();
		switch (comanString) {	
		case "SI":
			System.exit(0);
			break;
		case "NO":
			frame.dispose();
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		shooseOption(e,new Color(0,240,240));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		shooseOption(e,new Color(255,255,255));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}