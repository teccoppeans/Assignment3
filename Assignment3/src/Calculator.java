
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Calculator {

	private LinkedStack<Integer> numberStack;
	private LinkedStack<String> operatorStack;
	private DisplayPanel display;
	private KeypadPanel keypad;
	
	public Calculator(){
		JFrame mainFrame = new JFrame("Calculator");
		mainFrame.setSize(300, 500);
		mainFrame.setVisible(true);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		display = new DisplayPanel();
		keypad = new KeypadPanel(this);
		mainPanel.add(display);
		mainPanel.add(keypad);
		
		mainFrame.setLayout(new GridLayout());
		mainFrame.setContentPane(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setSize(300, 400);
		
		numberStack = new LinkedStack<Integer>();
		operatorStack = new LinkedStack<String>();
	}
	
	public DisplayPanel getDisplay() {
		return display;
	}
	
	public LinkedStack<Integer> getNumberStack() {
		return numberStack;
	}

	public LinkedStack<String> getOperatorStack() {
		return operatorStack;
	}

	public String calculate(String input) throws RuntimeException {
		//split input into numbers/whitespace/operators
		String[] inputArray = parseString (input);
		
		if (inputArray.length > 1) {
			if (!isInteger(inputArray[0]))
				return calculatePrefix(inputArray);
			else if (!isInteger(inputArray[1]))
				return calculateInfix(inputArray);
			else
				return calculatePostfix(inputArray);
		}
		else {
			try {
				if (inputArray.length == 0){
					throw new RuntimeException("No Input.");
				}
				else if (isInteger(inputArray[0])) {
					return inputArray[0];
				}
				else {
					throw new RuntimeException("Invalid Input.");
				}
			}
			catch (RuntimeException e) {
				return e.getMessage();
			}
		}
	}
	
	public String calculatePostfix(String[] input) {
		for (int i = 0; i < input.length; ++i) {
			if (isInteger(input[i]))
				numberStack.push(Integer.parseInt(input[i]));
			else {
				int first;
				int second;
				try {
					second = numberStack.top();
					numberStack.pop();
					first = numberStack.top();
					numberStack.pop();
				}
				catch (StackUnderflowException e) {
					//output to display
					numberStack.clear();
					return "Not enough operands.";
				}
				if (input[i].equals("+")) {
					numberStack.push(first + second);
				}
				else if (input[i].equals("-")) {
					numberStack.push(first - second);
				}
				else if (input[i].equals("*")) {
					numberStack.push(first * second);
				}
				else if (input[i].equals("/")) {
					if (second == 0) {
						numberStack.clear();
						return "Divide by 0 error.";
					}
					numberStack.push(first / second);
				}
				else
					return "Unrecognized operator.";
			}
		}
		String result = "";
		try {
		result += numberStack.top();
		numberStack.pop();
		}
		catch (StackUnderflowException e) {
			//output to display
			numberStack.clear();
			return "Invalid Input.";
		}
		//check for not enough operators
		if (numberStack.isEmpty())
			return result;
		else
			return "Not enough operators.";
	}
	
	public String calculatePrefix(String[] input) {
		for (int i = input.length - 1; i >= 0; --i) {
			if (isInteger(input[i]))
				numberStack.push(Integer.parseInt(input[i]));
			else {
				int first;
				int second;
				try {
					first = numberStack.top();
					numberStack.pop();
					second = numberStack.top();
					numberStack.pop();
				}
				catch (StackUnderflowException e) {
					//output to display
					numberStack.clear();
					return "Not enough operands.";
				}
				if (input[i].equals("+")) {
					numberStack.push(first + second);
				}
				else if (input[i].equals("-")) {
					numberStack.push(first - second);
				}
				else if (input[i].equals("*")) {
					numberStack.push(first * second);
				}
				else if (input[i].equals("/")) {
					if (second == 0) {
						numberStack.clear();
						return "Divide by 0 error.";
					}
					numberStack.push(first / second);
				}
			}
		}
		String result = "";
		try {
		result += numberStack.top();
		numberStack.pop();
		}
		catch (StackUnderflowException e) {
			//output to display
			return "Invalid Input.";
		}
		//check for not enough operators
		if (numberStack.isEmpty())
			return result;
		else
			return "Not enough operators.";
	}
	
	public String calculateInfix(String[] input) {
		//implement shunting-yard algorithm
		String output = "";
		for (int i = 0; i < input.length; ++i) {
			if (isInteger(input[i])) {
				output += input[i] + " ";
			}
			else { 
				while (!operatorStack.isEmpty() && 
						((input[i].equals(operatorStack.top())) ||
						((input[i].equals("+") || input[i].equals("-") ) && (operatorStack.top().equals("/") || operatorStack.top().equals("*"))))
						) {
				output += operatorStack.top() + " ";
				operatorStack.pop();
				}
				operatorStack.push(input[i]);
			}
		}
		while (!operatorStack.isEmpty()) {
			output += operatorStack.top() + " ";
			operatorStack.pop();
		}
		//split input into numbers/whitespace/operators
		String[] outputArray = parseString(output);
		
		return calculatePostfix(outputArray);
	}
	
	public static boolean isInteger(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch(NumberFormatException e) {
	        return false;
	    }
	}
	
	public static String[] parseString(String input) {
		//split input into numbers/whitespace/operators
		String[] inputArray = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		
		//split operators
		inputArray = splitOperators(inputArray);
		
		//remove whitespace elements from the String array
		inputArray = removeWhitespace(inputArray);
		
		
		return inputArray;
	}
	
	public static String[] removeWhitespace(String[] arr) {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i].trim().length() > 0)
				temp.add(arr[i].trim());
		}
		return temp.toArray(new String[temp.size()]);
	}
	
	public static String[] splitOperators(String[] arr) {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < arr.length; ++i) {
			if (!isInteger(arr[i].trim())) {
				String[] tempArr = arr[i].split("(?<=[-+*/])|(?=[-+*/])");
				for (int j = 0; j < tempArr.length; ++j)
					temp.add(tempArr[j].trim());
			}
			else
				temp.add(arr[i].trim());
		}
		return temp.toArray(new String[temp.size()]);
	}
}
