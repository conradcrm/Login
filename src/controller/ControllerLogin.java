package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.Login;
import view.Pop_up;

public class ControllerLogin implements ActionListener, KeyListener, FocusListener {

	public Login view;
	boolean show;
	public ControllerLogin(Login view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case "INGRESAR":
			isEmpy();
			comprobarAcceso();
		break;
		case "SHOW":
			if (show == false) {
				view.getTxtPassword().setEchoChar((char) 0);
				show = true;
			}else {
				view.getTxtPassword().setEchoChar('*');
				show = false;
			}
		break;
		case "SALIR":
			new Pop_up("You leave me? It's okay" );
			break;
		}
	}

	public void actionFields(String campo) {
		switch (campo) {
		case "BOTH":
			view.getSeparatorPassword().setForeground(Color.RED);
			view.getSeparatorUser().setForeground(Color.RED);
			view.setlblWarning("Enter a username and password");
			break;
		case "USER":
			view.getSeparatorUser().setForeground(Color.RED);
			view.setlblWarning("Enter a nameuser");
			break;
		case "PASSWORD":
			view.getSeparatorPassword().setForeground(Color.RED);
			view.setlblWarning("Enter a password");
			break;
		}
	}

	public void isEmpy() {
		view.setlblWarning("");
		boolean empty=view.getPassword().trim().isEmpty();
		if (view.getTxtUser().trim().isEmpty() && empty)	actionFields("BOTH");
		if (view.getTxtUser().trim().isEmpty())		actionFields("USER");
		if (view.getPassword().trim().isEmpty())		actionFields("PASSWORD");
	}
	
	private void comprobarAcceso() {
		view.getSeparatorPassword().setForeground(Color.BLACK);
		view.getSeparatorUser().setForeground(Color.BLACK);
		String user = view.getTxtUser();
		String password = view.getPassword();
		if (user.equalsIgnoreCase("Jasive") && password.equalsIgnoreCase("Love")) {
			Pop_up.get("Welcome to my life, Do you want to break my heart? to know");
		}
		else{
			view.setlblWarning("Username or password incorrect");
			view.getSeparatorPassword().setForeground(Color.RED);
			view.getSeparatorUser().setForeground(Color.RED);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		boolean empty=view.getPassword().isEmpty();
		if (empty)	view.getBtnShow().setVisible(false) ;
		else	 	view.getBtnShow().setVisible(true);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			isEmpy();
			comprobarAcceso();
        }
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == view.getTxtPassword()) {
			view.getSeparatorPassword().setForeground(new Color(10,200,10));
			view.getSeparatorUser().setForeground(new Color(190,220,190));
		}
		else if(e.getSource()==view.getCTxtUser()) {
			view.getSeparatorUser().setForeground(new Color(10,200,10));
			view.getSeparatorPassword().setForeground(new Color(190,220,190));
		}
	}

	@Override
	public void focusLost(FocusEvent e) {}
	}
