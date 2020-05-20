package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import complements.MoveWindows;
import controller.ControllerLogin;

public class Login extends JPanel{
	private Font FONT_LABEL = new Font("Calibri Light", Font.ITALIC, 14);
	private Font FONT_TEXT= new Font("Calibri Light", Font.PLAIN, 15);
	private Font FONT_BUTTON= new Font("Gadugi", Font.BOLD, 13);
	
	private String PATH_ICON_LOOK = "/images/icon_login/lock.png";
	private String PATH_ILUSTRATION = "/images/security.png";
	private String PATH_BG_IMAGE = "/images/nutrition.jpg";
	
	private JLabel lblUser,lblPassword,lblWarning,ilustration;
	private JSeparator separatorUser,separatorPassword;
	private JButton btnLogin,btnExit, btnShow;
	private JPasswordField txtPassword;
	private JTextField txtUser;	
	private JPanel panelLogin;
	
	private Image bg_image;
	private URL url;
	
	private int MOVY = 70;
	private int MOVX = 40;
	
	private JFrame f;
	
	public Login() {
		setLayout(null);
		f=new JFrame();
		MoveWindows moveWindows= new MoveWindows(this, f);
		setBorder(new LineBorder(new Color(128, 128, 128)));
		f.setSize(815, 450);
		f.setUndecorated(true);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(this);
		
		imageBackgroung();
		initComponents();
		f.setVisible(true);
	}

	private void initComponents() {
		panelLogin = new JPanel();
		panelLogin.setBorder(null);
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(1, 1, 382, 448);
		panelLogin.setLayout(null);
		add(panelLogin);
		
		lblUser = new JLabel("User");
		lblUser.setForeground(Color.GRAY);
		lblUser.setFont(FONT_LABEL);
		lblUser.setBounds(45, 70, 290, 14);
		panelLogin.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setSelectionColor(Color.WHITE);
		txtUser.setOpaque(false);
		txtUser.setFont(FONT_TEXT);
		txtUser.requestFocus();
		txtUser.setBounds(MOVX, MOVY+20, 290, 23);
		txtUser.setBorder(null);
		txtUser.setColumns(10);
		panelLogin.add(txtUser);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(FONT_LABEL);
		lblPassword.setBounds(45, 155, 290, 14);
		panelLogin.add(lblPassword);
		
		separatorUser = new JSeparator();
		separatorUser.setBounds(MOVX, MOVY+45, 290, 2);
		panelLogin.add(separatorUser);
		
		btnLogin = new JButton("Login");
		btnLogin.setFocusable(false);
		btnLogin.setFont(FONT_BUTTON);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(80,200,80));
		btnLogin.setBounds(MOVX, MOVY+305, 290, 34);
		panelLogin.add(btnLogin);
		
		separatorPassword = new JSeparator();
		separatorPassword.setBounds(MOVX, MOVY+130, 290, 2);
		panelLogin.add(separatorPassword);
		
		lblWarning = new JLabel();
		lblWarning.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWarning.setFont(new Font("Arial", Font.PLAIN, 12));
		lblWarning.setBorder(null);
		lblWarning.setForeground(Color.RED);
		lblWarning.setBackground(Color.WHITE);
		lblWarning.setBounds(MOVX, MOVY+150, 290, 25);
		panelLogin.add(lblWarning);
		
		ilustration = new JLabel();
		ilustration.setHorizontalAlignment(SwingConstants.CENTER);
		ilustration.setBounds(MOVX, MOVY+155, 290, 141);
		ilustration.setIcon(new ImageIcon(Login.class.getResource(PATH_ILUSTRATION)));
		panelLogin.add(ilustration);
		
		btnExit = new JButton("X");
		btnExit.setForeground(Color.DARK_GRAY);
		btnExit.setFont(new Font("Dubai Light", Font.PLAIN, 18));
		btnExit.setBorder(null);
		btnExit.setFocusable(false);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(5, 5, 24, 20);
		panelLogin.add(btnExit);
		
		txtPassword = new JPasswordField();
		txtPassword.setOpaque(false);
		txtPassword.setFont(FONT_TEXT);
		txtPassword.setBorder(null);
		txtPassword.setBounds(MOVX, MOVY+105, 269, 23);
		panelLogin.add(txtPassword);
		
		btnShow = new JButton();
		btnShow.setOpaque(false);
		btnShow.setFocusable(false);
		btnShow.setVisible(false);
		btnShow.setBorder(null);
		btnShow.setIcon(new ImageIcon(Login.class.getResource(PATH_ICON_LOOK)));
		btnShow.setForeground(Color.WHITE);
		btnShow.setBackground(Color.WHITE);
		btnShow.setBounds(313, MOVY+103, 24, 25);
		panelLogin.add(btnShow);
	}
	
	public void connectController(ControllerLogin control) {
		
		btnLogin.addActionListener(control);
		btnLogin.setActionCommand("LOGIN");
				
		btnShow.addActionListener(control);
		btnShow.setActionCommand("SHOW");
		
		txtPassword.addKeyListener(control);
		
		txtUser.addFocusListener(control);
		txtPassword.addFocusListener(control);
		
		btnExit.addActionListener(control);
		btnExit.setActionCommand("EXIT");
		
		txtPassword.addKeyListener(control);
		txtUser.addKeyListener(control);
		
		addKeyListener(control);
	}
	
	private void imageBackgroung() {
		url = this.getClass().getResource(PATH_BG_IMAGE);
		bg_image = new ImageIcon(url).getImage();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(bg_image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
	}
	
	public String getTxtUser(){
		return txtUser.getText(); 	
	}
	
	public JTextField getCTxtUser() {
		return txtUser;
	}
	
	public String getPassword(){
		return String.valueOf(txtPassword.getPassword());
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}
	
	public JButton getBtnShow() {
		return btnShow;
	}

	public JSeparator getSeparatorUser() {
		return separatorUser;
	}

	public JSeparator getSeparatorPassword() {
		return separatorPassword;
	}

	public void setlblWarning(String lblWarning) {
		this.lblWarning.setText(lblWarning);
	}

	public JFrame getF() {
		return f;
	}	
}
