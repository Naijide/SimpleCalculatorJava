import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Issues with this program:
 * 1. need to account for when user clicks operator more than once
 * 	possible solutions:  (Solved)
 * 			try catch block
 * 2. need to account for when user clicks decimal button twice
 * 	possible solutions:   (Solved)
 * 			AND condition check if textField contains '.' already 
 * 
 * 3. after clicking one operator, clicking another won't change
 * 		to the new operator
 * 	possible solutions:
 * 
 * 4. clicking '=' twice causes exception due to parsing empty
 * possible solutions:   (solved)
 * 		try catch
 */

public class Calculator implements ActionListener{

	JFrame myFrame;
	JTextField textField;
	JButton[] numButtons = new JButton[10];
	JButton[] specButtons = new JButton[8];
	JButton addB, subB, divB, mulB;
	JButton decB, equB, delB, clrB;
	JPanel panel;
	
	Font myFont = new Font("Arial", Font.PLAIN, 30);
	
	double num1=0, num2=0, result=0;
	char operator;
	
	Calculator(){
		myFrame = new JFrame("Calculator");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(400,550);
		myFrame.setLayout(null);
		myFrame.setLocationRelativeTo(null);
		myFrame.setResizable(false);
		
		
		textField = new JTextField();
		textField.setBounds(25, 20, 350, 60);
		textField.setFont(myFont);
		textField.setEditable(false);
		
		addB = new JButton("+");
		subB = new JButton("-");
		divB = new JButton("/");
		mulB = new JButton("x");
		decB = new JButton(".");
		equB = new JButton("=");
		delB = new JButton("DELETE");
		clrB = new JButton("CLEAR");
		
		specButtons[0] = addB;
		specButtons[1] = subB;
		specButtons[2] = divB;
		specButtons[3] = mulB;
		specButtons[4] = decB;
		specButtons[5] = equB;
		specButtons[6] = delB;
		specButtons[7] = clrB;
		
		for(int i=0; i<8; i++) {
			specButtons[i].addActionListener(this);
			specButtons[i].setFont(myFont);
			specButtons[i].setFocusable(false);
		}
		
		for(int i=0; i<10; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].setFont(myFont);
			numButtons[i].setFocusable(false);
		}
		
		delB.setBounds(50,430,145,50);
		clrB.setBounds(205,430,145,50);
		
		panel = new JPanel();
		panel.setBounds(25, 100, 350, 300);
		panel.setLayout(new GridLayout(4,3,10,10));
		//panel.setBackground(Color.GRAY);
		
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(addB);
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subB);
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulB);
		panel.add(decB);
		panel.add(numButtons[0]);
		panel.add(equB);
		panel.add(divB);	


		myFrame.add(panel);
		myFrame.add(delB);
		myFrame.add(clrB);
		myFrame.add(textField);
		myFrame.setVisible(true);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for (int i=0; i<10; i++) {
			if (e.getSource() == numButtons[i]) {
				textField.setText(textField.getText().
						concat(numButtons[i].getText()));
			}
		}
		
		if (e.getSource() == decB) {
			if (textField.getText().contains(".")) {
				textField.setText(textField.getText());
			}else {
				textField.setText(textField.getText().concat("."));
			}
		}
		
		if (e.getSource() == addB) {
			try {
				num1 = Double.parseDouble(textField.getText());
				operator = '+';
				textField.setText(null);
			} catch(NumberFormatException j) {
				textField.setText(null);
			}
		}
		
		if (e.getSource() == subB) {
			try {
				num1 = Double.parseDouble(textField.getText());
				operator = '-';
				textField.setText(null);
			} catch(NumberFormatException j) {
				textField.setText(null);
			}
		}
		if (e.getSource() == divB) {
			try {
				num1 = Double.parseDouble(textField.getText());
				operator = '/';
				textField.setText(null);
			} catch (NumberFormatException j) {
				textField.setText(null);

			}
		}
		if (e.getSource() == mulB) {
			try {
				num1 = Double.parseDouble(textField.getText());
				operator = '*';
				textField.setText(null);
			} catch (NumberFormatException j) {
				textField.setText(null);
			}
		}
		if (e.getSource() == equB) {
			try {
				num2 = Double.parseDouble(textField.getText());
				
				switch(operator) {
				
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				}
				textField.setText(String.valueOf(result));
			}catch (NumberFormatException j) {
				textField.setText(null);
			}
				
		}
		
		if (e.getSource() == clrB) {
			textField.setText(null);
		}
		
		if (e.getSource() == delB) {	
			try {
			textField.setText(textField.getText().substring(0,
					textField.getText().length() - 1));
			}
			catch(StringIndexOutOfBoundsException j) {
				textField.setText(null);
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}
}
