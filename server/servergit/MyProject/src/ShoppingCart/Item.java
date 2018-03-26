package ShoppingCart;
import java.text.DecimalFormat;
public class Item {
	DecimalFormat twoDecimals = new DecimalFormat("0.00");
	Product product;
	int quantity;
	double subtotal;
	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.subtotal = 1;
	}
	public Item(Product product) {
		this.product = product;
		this.quantity = 0;
		this.subtotal = 1;
	}
	
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	 public double getSubtotal() {
		 subtotal = product.getPrice()*quantity;
		 return subtotal;
	 }
	 public String toString() {
		 return product.getNumber()+": "+product.getName()+", quantity: "+ quantity+ ", unit price: "+ twoDecimals.format(product.getPrice()).replace(".", ",")+", subtotal: "+twoDecimals.format(getSubtotal()).replace(".",",");
	 }
}
