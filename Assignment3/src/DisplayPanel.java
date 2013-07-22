import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DisplayPanel extends JPanel {
	private JPanel display;
	private JLabel text;

	public DisplayPanel() {
		display = new JPanel();
		text = new JLabel();
		text.setBounds(display.getX(), display.getY(), display.getWidth(), display.getHeight());
        text.setFont(new Font("Arial", Font.PLAIN, 24));
		display.add(text);
		this.add(display);	
	}
	
	public JPanel getDisplay() {
		return display;
	}
	
	public String getOutput() {
		return text.getText();
	}
	
	public void setOutput(String message) {
		text.setText(message);
	}
}
