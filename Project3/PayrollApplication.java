//Complete documentation here please

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class PayrollApplication extends JFrame
	implements ActionListener
{
	//Declare objects and fields (instance variables)
	JLabel companyLabel = new JLabel("A B C   Company");
	JTextField nameTextField = new JTextField(15);
	JTextField hoursTextField = new JTextField(15);
	JTextField rateTextField = new JTextField(15);
	JButton displayButton = new JButton("Display Calculation");
	JButton clearButton = new JButton("  Clear textfields     ");
	JButton summaryButton = new JButton("       Summary        ");
	JTextArea outputTextArea = new JTextArea(5, 20);
	JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
	JPanel mainPanel = new JPanel();
	Font companyFont = new Font("Times New Roman", Font.BOLD, 24);
	Color tealColor = new Color(0,128, 128);
	JLabel empCountLabel = new JLabel();
	
	
	// the main method will create an object of itself and 
	//set the default close operation
	public static void main(String[] args) 
	{
		
		PayrollApplication abcPayrollApplication = new PayrollApplication();
		abcPayrollApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//end of main method
	
	//the constructor will call methods to set up the panel 
	//and frame, and set the listeners
	public PayrollApplication()
	{
		//call a method to set up the components
		super("Payroll");
		addComponents();
		addListeners();
		
	}//end of the constructor
	
	//this method will add the components to the panel, add the
	//panel to the frame, and set the frame properties
	public void addComponents()
	{
		
		//Set up the UI components
		
		mainPanel.add(companyLabel);
		mainPanel.add(new JLabel("Name:     "));
		mainPanel.add(nameTextField);
		mainPanel.add(new JLabel("Hours:     "));
		mainPanel.add(hoursTextField);
		mainPanel.add(new JLabel("Rate:       "));
		mainPanel.add(rateTextField);
		mainPanel.add(displayButton);
		mainPanel.add(clearButton);
		mainPanel.add(summaryButton);
		mainPanel.add(outputScrollPane);
		mainPanel.add(empCountLabel);
		this.add(mainPanel);
		companyLabel.setFont(companyFont);
		companyLabel.setForeground(tealColor);
		mainPanel.setBackground(Color.YELLOW);
		
		
		//set defaults for JFrame display
		setSize(250, 400);
		setLocation(100, 100);
		setVisible(true);
		
	}//end of addComponents
	
	//this method will add the listeners to the appropriate components
	public void addListeners()
	{
		//set the listeners
		displayButton.addActionListener(this);
		rateTextField.addActionListener(this);
		clearButton.addActionListener(this);
		summaryButton.addActionListener(this);
		
	}//end of addListeners

	//the actionListener will be called automatically
	//when an action gets triggered
	//this method calls the displayResults method, the
	//clearTextFields method, or the displaySummary method
	//depending on the button that triggered this event
	public void actionPerformed(ActionEvent thisEvent)
	{
		
		if (thisEvent.getSource() == displayButton || thisEvent.getSource() == rateTextField)
				displayResults();
		else if (thisEvent.getSource() == clearButton)
			clearTextFields();
		else if (thisEvent.getSource()== summaryButton)
			displaySummary();
		
	}//end of actionPerformed
	
	//The displayResults method will retrieve and convert items from the panel,
	//create an object of the Payroll class, send and retrieve values from this Payroll
	//class, and display the results
	public void displayResults()
	{
		//Declare needed local variables and objects
		int hoursInteger = 0;
		double rateDouble = 0.0;
		double grossPayDouble = 0.0;
		DecimalFormat currencyDF = new DecimalFormat("$#,##0.00");
		String tempString = "";
		
		//Retrieve and convert the hours and rate
		hoursInteger = Integer.parseInt(hoursTextField.getText());
		rateDouble = Double.parseDouble(rateTextField.getText());
		
	}//end of displayResults
	//This method clears out the textfields and resets the insertion point
	//for the next entry
	public void clearTextFields()
	{
		
		nameTextField.setText("");
		rateTextField.setText("");
		hoursTextField.setText("");
		nameTextField.requestFocus();
	}//end of clearTextFields
	
	//This method displays the accumulated gross pay and the total employees processed
	public void displaySummary()
	{
		String summaryString = "Total Payroll: " + "\nTotal Employees: " ;
		JOptionPane.showMessageDialog (null, summaryString);
		
	}//end of displaySummary

}//end of PayrollApplication class











