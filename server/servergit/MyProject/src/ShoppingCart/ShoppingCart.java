package ShoppingCart;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class ShoppingCart {
	 DecimalFormat twoDecimals = new DecimalFormat("0.00");
      ArrayList<Item> itemList;
      public ShoppingCart() {
    	  this.itemList = new ArrayList<Item>();
      }
      
public void add(Product name, int quantity) {
	 	Item itemToAdd = new Item(name,quantity);
	 	itemList.add(itemToAdd);
}
public void remove(Product name) {
 	Item itemToRemove = new Item(name);
 	for (int i=0;i<itemList.size();i++) {
 		if (itemToRemove.getProduct().getName().equals(itemList.get(i).getProduct().getName())) {
 			itemList.remove(itemList.get(i));
 		}
 	}
}
 public double getTotalPrice() {
	 double totalPrice = 0.00;
	 for (int i=0;i<itemList.size();i++) {
		 totalPrice+=itemList.get(i).getSubtotal();
	 }
	 return totalPrice;
 }
public String toString() {
	String result = "=== Shopping cart === \n";
	if (itemList.size()==0) {
		result = "Cart empty. \n";
	}
	else {
		for (int i=0;i<itemList.size();i++) {
			result +=  itemList.get(i).toString() + "\n" + "TOTAL PRICE: "+ getTotalPrice();
		}
		result+="\n";
	}
	return result;
	
}
}

