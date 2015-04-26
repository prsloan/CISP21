/*------------------------------------------------------------------------------------------
 * folder/Project name: Project 4
 * Programmer Name: Philip Sloan
 * Date: October 21st, 2013
 * Class Name: CoffeeShop
 * 
 * Project Description:  Creates, in a JFrame, an interface for accumulating customer orders for 3 
 * different coffee types. The project makes use of exception handling, radio buttons, the grid layout for formatting,
 * as well as the actionListener and logical statements.
 */

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat ;
import javax.swing.*;


public class CoffeeShopGUI extends JFrame implements ActionListener
{

//instance level variable declarations




//variables to get values from the customer input
String[] typeStringArray = {"Mocha", "Latte","Drip"};
String customerNameString, coffeeTypeString ;
int quantityInputInt;
//variables to be calculated from the inputs
float subTotalFloat, grandTotalFloat, orderCostFloat;


//The GUI for the program

GridLayout inputPanelLayout = new GridLayout(3,2);
GridLayout buttonPanelLayout = new GridLayout(1,3);
GridLayout outputPanelLayout = new GridLayout(0,1);
GridLayout totalsPanelLayout = new GridLayout(1,2);

JPanel mainPanel = new JPanel();
JPanel inputPanel = new JPanel();
JPanel buttonPanel = new JPanel();
JPanel totalsPanel = new JPanel();
JPanel outputPanel = new JPanel();
JPanel coffeeTypePanel = new JPanel();

JLabel coffeeshopLabel = new JLabel("Morning Lift Coffee Shop");
JLabel customerNameLabel = new JLabel("Customer Name :");
JLabel quantityLabel = new JLabel("Quantity Purchased :");
JLabel coffeeTypeLabel = new JLabel("Type of Coffee :");
JLabel subTotalLabel = new JLabel("Subtotal :");
JLabel grandTotalLabel = new JLabel("Grand Total");

JComboBox coffeeTypeComboBox = new JComboBox(typeStringArray);
JCheckBox decafCheckBox = new JCheckBox("Decaf");

JButton addToOrderButton = new JButton("Add to Order");
JButton completeOrderButton = new JButton("Complete Order");
JButton clearButton = new JButton("Clear");

JTextField nameInputTextField = new JTextField(8);
JTextField quantityInputTextField = new JTextField(2);

JTextArea outputTextArea = new JTextArea(10,50);
JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
JLabel programmerLabel = new JLabel("Programmed by Philip Sloan.");

Font textAreaFont = new Font("Courier", Font.PLAIN, 12);
Font coffeeshopLabelFont = new Font("Lucida Sans", Font.ITALIC, 24);
ButtonGroup coffeeTypeGroup = new ButtonGroup();

//The Constructor Method
public CoffeeShopGUI()
{
		super(" Mt. SAC Morning Lift Coffee Shop Ordering Interface");
		
		//Constuct the layout with the components declared above
		coffeeshopLabel.setFont(coffeeshopLabelFont);
		
		inputPanel.setLayout(inputPanelLayout);
		buttonPanel.setLayout(buttonPanelLayout);
		outputPanel.setLayout(outputPanelLayout);
		totalsPanel.setLayout(totalsPanelLayout);
		
		coffeeTypePanel.add(coffeeTypeComboBox);
		coffeeTypePanel.add(decafCheckBox);
		
		buttonPanel.add(addToOrderButton);
		buttonPanel.add(completeOrderButton);
		buttonPanel.add(clearButton);
		
		totalsPanel.add(subTotalLabel);
		totalsPanel.add(grandTotalLabel);
		
		inputPanel.add(customerNameLabel);
		inputPanel.add(nameInputTextField);
		inputPanel.add(quantityLabel);
		inputPanel.add(quantityInputTextField);
		inputPanel.add(coffeeTypeLabel);
		inputPanel.add(coffeeTypePanel);
		
		
		outputPanel.add(totalsPanel);
		outputPanel.add(programmerLabel);
		
		mainPanel.add(coffeeshopLabel);
		mainPanel.add(inputPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(outputScrollPane);
		mainPanel.add(outputPanel);
		
		add(mainPanel);
		
		clearButton.setEnabled(false);
		completeOrderButton.setEnabled(false);
		
		grandTotalLabel.setVisible(false);
		outputTextArea.setFont(textAreaFont);
		outputTextArea.setText(String.format("%-15s  %-8s    %-6s    %-8s%n%n","Name", "Quantity","Type","Cost" ));
		
		setListeners();
		
		this.setSize(400,450);
		this.setVisible(true);
		
		
}
/*--------------------------------------------METHODS----------------------------------------------------*/

//This attaches Listeners to the objects we want to monitor for user input
public void setListeners()
{
	addToOrderButton.addActionListener(this);
	completeOrderButton.addActionListener(this);
	clearButton.addActionListener(this);
	quantityInputTextField.addActionListener(this);
}

//This Method executes when an action is performed on one of the listened to objects
public void actionPerformed (ActionEvent e)
{
	//check to make sure the fields inputs are valid, then run calculations and printing
	if ((e.getSource()==addToOrderButton) || (e.getSource()==quantityInputTextField) )
	{
		if (completeOrderButton.isEnabled() == false)
			completeOrderButton.setEnabled(true);
		CoffeeShop coffeeOrder = new CoffeeShop(Integer.parseInt(quantityInputTextField.getText()), nameInputTextField.getText(), coffeeTypeComboBox.getSelectedIndex(), decafCheckBox.isSelected());
		//outputTextArea.append(formatOutput());
		//subTotalLabel.setText("Subtotal : $"+ String.format("%6.2f", subTotalFloat));
		grandTotalLabel.setVisible(false);
		clearButton.setEnabled(true);
	}
	//calculate the grandTotal and reset the ordering interface
	if (e.getSource()==completeOrderButton)
	{
		grandTotalLabel.setText("Grand Total : $"+ String.format("%6.2f", grandTotalFloat));
		grandTotalLabel.setVisible(true);
		completeOrderButton.setEnabled(false);
		resetOrderForm();
		outputTextArea.setText(String.format("%-15s  %-8s    %-6s    %-8s%n%n","Name", "Quantity","Type","Cost" ));
	}
	//clear the user input fields
	if (e.getSource()==clearButton)
		resetOrderForm();
}
	


//this calculates the totals and cost, and updates the appropriate variable
public void calculateTotals()
{
	orderCostFloat = 0.0f;
	switch(coffeeTypeString)
		{
		case "Mocha":
			orderCostFloat +=quantityInputInt*MOCHA_COST_FLOAT;
			break;
		case "Latte":
			orderCostFloat +=quantityInputInt*LATTE_COST_FLOAT;
			break;
		case "Drip":
			orderCostFloat +=quantityInputInt*DRIP_COST_FLOAT;
		}
	subTotalFloat+=orderCostFloat;
	grandTotalFloat= subTotalFloat*(1+TAX_RATE_FLOAT);
}

//this method formats a string to be placed in the outputTextArea and returns it
public String formatOutput()
{
String outputString =String.format("%-15s  %-8s    %-6s    $%-8.2f%n", customerNameString, quantityInputInt, coffeeTypeString, orderCostFloat);

return outputString;

}

//this method resets the order form
public void resetOrderForm()
{
	
	addToOrderButton.setEnabled(true);
	completeOrderButton.setEnabled(false);
	clearButton.setEnabled(false);
	nameInputTextField.setText("");
	quantityInputTextField.setText("");
	nameInputTextField.requestFocus(); 
	
	subTotalFloat=0.0f;
	grandTotalFloat=0.0f;
	
}

//------------Main Method Calls the GUI
public static void main(String[] args)
{

	CoffeeShopGUI basicGUI= new CoffeeShopGUI();
	basicGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

}
