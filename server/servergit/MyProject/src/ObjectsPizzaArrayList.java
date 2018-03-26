import java.util.ArrayList;
public class ObjectsPizzaArrayList {

	public static void main(String[] args) {
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		Pizza pizzaOne = new Pizza("Diavolo",8.75);
		Pizza pizzaTwo = new Pizza("Frutti al Mare",9.00);
		Pizza pizzaThree = new Pizza("Alla Pollo",7.50);
		pizzaList.add(pizzaOne);
		pizzaList.add(pizzaTwo);
		pizzaList.add(pizzaThree);
		for (int i = 0; i<pizzaList.size();i++) {
			System.out.println(pizzaList.get(i));
		}

	}

}
