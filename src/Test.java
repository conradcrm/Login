import controller.ControllerLogin;
import view.Login;

public class Test {
	public static void main(String[] args) {
		Login log= new Login();
		ControllerLogin controller = new ControllerLogin(log);
		log.connectController(controller);
	}
}
