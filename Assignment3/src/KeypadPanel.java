import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class KeypadPanel extends JPanel {
	private JPanel panel1;
	private JPanel panel2;
	private Calculator calc;
	
	public KeypadPanel(Calculator c) {
		calc = c;
		//panel for 0-9, =, and _
		panel1 = new JPanel(new GridLayout(4, 3));
		panel1.add(new OneButton());
		panel1.add(new TwoButton());
		panel1.add(new ThreeButton());
		panel1.add(new FourButton());
		panel1.add(new FiveButton());
		panel1.add(new SixButton());
		panel1.add(new SevenButton());
		panel1.add(new EightButton());
		panel1.add(new NineButton());
		panel1.add(new SpaceButton());
		panel1.add(new ZeroButton());
		panel1.add(new EqualButton());
		//panel for +, -, *, /, clear
		panel2 = new JPanel(new GridLayout(5, 1));
		panel2.add(new AddButton());
		panel2.add(new SubtractButton());
		panel2.add(new MultiplyButton());
		panel2.add(new DivideButton());
		panel2.add(new ClearButton());
		
		this.setLayout(new GridLayout(1, 2));
		this.add(panel1);
		this.add(panel2);
	}
	
	//buttons
	private class ZeroButton extends JButton {
		public ZeroButton(){
			super("0");
			this.addActionListener(new ZeroListener());
		}
	}
	private class OneButton extends JButton {
		public OneButton(){
			super("1");
			this.addActionListener(new OneListener());
		}
	}
	private class TwoButton extends JButton {
		public TwoButton(){
			super("2");
			this.addActionListener(new TwoListener());
		}
	}
	private class ThreeButton extends JButton {
		public ThreeButton(){
			super("3");
			this.addActionListener(new ThreeListener());
		}
	}
	private class FourButton extends JButton {
		public FourButton(){
			super("4");
			this.addActionListener(new FourListener());
		}
	}
	private class FiveButton extends JButton {
		public FiveButton(){
			super("5");
			this.addActionListener(new FiveListener());
		}
	}
	private class SixButton extends JButton {
		public SixButton(){
			super("6");
			this.addActionListener(new SixListener());
		}
	}
	private class SevenButton extends JButton {
		public SevenButton(){
			super("7");
			this.addActionListener(new SevenListener());
		}
	}
	private class EightButton extends JButton {
		public EightButton(){
			super("8");
			this.addActionListener(new EightListener());
		}
	}
	private class NineButton extends JButton {
		public NineButton(){
			super("9");
			this.addActionListener(new NineListener());
		}
	}
	private class EqualButton extends JButton {
		public EqualButton(){
			super("=");
			this.addActionListener(new EqualListener());
		}
	}
	private class SpaceButton extends JButton {
		public SpaceButton(){
			super("_");
			this.addActionListener(new SpaceListener());
		}
	}
	private class AddButton extends JButton {
		public AddButton(){
			super("+");
			this.addActionListener(new AddListener());
		}
	}
	private class SubtractButton extends JButton {
		public SubtractButton(){
			super("-");
			this.addActionListener(new SubtractListener());
		}
	}
	private class MultiplyButton extends JButton {
		public MultiplyButton(){
			super("*");
			this.addActionListener(new MultiplyListener());
		}
	}
	private class DivideButton extends JButton {
		public DivideButton(){
			super("/");
			this.addActionListener(new DivideListener());
		}
	}
	private class ClearButton extends JButton {
		public ClearButton(){
			super("C");
			this.addActionListener(new ClearListener());
		}
	}
	//listeners
	private class ZeroListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "0");
		}
		
	}
	private class OneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "1");
		}
		
	}
	private class TwoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "2");
		}
		
	}
	private class ThreeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "3");
		}
		
	}
	private class FourListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "4");
		}
		
	}
	private class FiveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "5");
		}
		
	}
	private class SixListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "6");
		}
		
	}
	private class SevenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "7");
		}
		
	}
	private class EightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "8");
		}
		
	}
	private class NineListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "9");
		}
		
	}
	private class EqualListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.calculate(calc.getDisplay().getOutput()));
		}
		
	}
	private class SpaceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + " ");
		}
		
	}
	private class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "+");
		}
		
	}
	private class SubtractListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "-");
		}
		
	}
	private class MultiplyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "*");
		}
		
	}
	private class DivideListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput(calc.getDisplay().getOutput() + "/");
		}
		
	}
	private class ClearListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			calc.getDisplay().setOutput("");
			calc.getNumberStack().clear();
			calc.getOperatorStack().clear();
		}
		
	}
}
