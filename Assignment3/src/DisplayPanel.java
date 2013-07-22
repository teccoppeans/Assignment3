import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DisplayPanel extends JPanel {
	private JPanel display;
	private JLabel text;
	private boolean error;

	public DisplayPanel() {
		display = new JPanel();
		text = new JLabel();
		text.setBounds(display.getX(), display.getY(), display.getWidth(), display.getHeight());
        text.setFont(new Font("Arial", Font.PLAIN, 24));
		display.add(text);
		this.add(display);
		error = false;
	}
	
	public JPanel getDisplay() {
		return display;
	}
	
	public String getOutput() {
		if (error) {
			error = false;
			return "";
		}
		return text.getText();
	}
	
	public void setOutput(String message) {
		text.setText(message);
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
