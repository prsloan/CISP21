import javax.swing.JOptionPane;


public class CoffeeShop {
	
private String nameString;
private int typeInt;
private int quantityInputInt;
private boolean isDecafBoolean;
private static int orderCount;
private float orderCostFloat;
private static float  subTotalFloat;
private static float grandTotalFloat ;


//CONSTANTS
private final float MOCHA_COST_FLOAT = 3.75f;
private final float LATTE_COST_FLOAT = 3.25f;
private final float DRIP_COST_FLOAT = 1.75f;
private final float TAX_RATE_FLOAT = .0975f;	
	
	
public CoffeeShop(){
	
}

public CoffeeShop(int orderQuantityint, String customerNameString, int coffeeTypeint, boolean decafBoolean){
	try
		{
		nameString = customerNameString;
		if (customerNameString.isEmpty())
			throw new NullPointerException();
		typeInt = coffeeTypeint;
		isDecafBoolean = decafBoolean;
		quantityInputInt=orderQuantityint;
		}
	catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null,  "Please Enter a valid order quantity!");	
		}
	catch (NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null , "Please Enter the Customer Name!");
		}

}

public int getOrderQuantity()
{
	return quantityInputInt;
}

public String getName()
{
	return nameString;
}

public int getCoffeeType()
{
	return typeInt;
}

public boolean isDecaf()
{
	return isDecafBoolean;
}

public float getOrderCost()
{
	return orderCostFloat;
}


//this calculates the totals and cost, and updates the appropriate variable
public void calculateTotals()
{
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





}	