package befaster.solutions;

import java.util.HashMap;

public class Checkout {

	private final HashMap<String, Item> productsMap;
	
	public Checkout() {
		productsMap = new HashMap<>();
		productsMap.put("A", new Item("A", 50, 3, 130));
		productsMap.put("B", new Item("B", 30, 2, 45));
		productsMap.put("C", new Item("C", 20, 1, 20));
		productsMap.put("D", new Item("D", 15, 1, 15));
	}
	
	public int getPrice(String name) {
		if(name == null) {
			return -1;
		}
		
		int price = 0;
		
		HashMap<String, Integer> countsMap = getEmptyCountsMap();
		
		for(char c: name.toCharArray()) {
			String item = Character.toString(c);

			if(productsMap.containsKey(item)) {
				int count = countsMap.get(item);
				countsMap.put(item, count + 1);
			} else {
				return -1;
			}
		}
		
		for(String item: countsMap.keySet()) {
			int count = countsMap.get(item);
			int itemsPrice = getItemsPrice(item, count);
			
			price += itemsPrice;
		}
		
		return price;
	}
	
	private HashMap<String, Integer> getEmptyCountsMap() {
		HashMap<String, Integer> counts = new HashMap<>();
		counts.put("A", 0);
		counts.put("B", 0);
		counts.put("C", 0);
		counts.put("D", 0);
		return counts;
	}
	
	private int getItemsPrice(String name, int count) {
		Item item = productsMap.get(name);
		
		int discountPrice = (count / item.getDiscountBatchSize()) * item.getDiscountBatchPrice();
		int normalPrice = (count % item.getDiscountBatchSize()) * item.getNormalPricePerItem();
		
		return discountPrice + normalPrice;
	}
}
