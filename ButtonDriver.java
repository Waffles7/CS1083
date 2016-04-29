import javax.swing.*;
import java.awt.*;
public class ButtonDriver extends JFrame {

	private ProductButton button;
	private String name = "Popcorn";
	private double price = 12.45;

	public ButtonDriver () {
		setSize(300,200);

		button = new ProductButton(name, price);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(button);

	}
	public static void main(String[] args) {
		new ButtonDriver().setVisible(true);
	}
}