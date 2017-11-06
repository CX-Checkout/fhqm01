package befaster.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Checkout {

	private final HashMap<String, Item> productsMap;
	
	public Checkout() {
		productsMap = new HashMap<>();
	
		Item itemA = new Item("A", 50, Arrays.asList(new PriceDiscount(3, 130), new PriceDiscount(5, 200)), Collections.emptyList());
		Item itemB = new Item("B", 30, Collections.singletonList(new PriceDiscount(2, 45)), Collections.emptyList());
		Item itemC = new Item("C", 20, Collections.emptyList(), Collections.emptyList());
		Item itemD = new Item("D", 15, Collections.emptyList(), Collections.emptyList());
		Item itemE = new Item("E", 40, Collections.emptyList(), Collections.singletonList(new FreebieDiscount(2, "B")));
		
		productsMap.put("A", itemA);
		productsMap.put("B", itemB);
		productsMap.put("C", itemC);
		productsMap.put("D", itemD);
		productsMap.put("E", itemE);
	}
	
	public int getPrice(String items) {
		if(items == null) {
			return -1;
		}
		
		HashMap<String, Integer> countsMap = getEmptyCountsMap();
		
		for(char c: items.toCharArray()) {
			String item = Character.toString(c);

			if(productsMap.containsKey(item)) {
				int count = countsMap.get(item);
				countsMap.put(item, count + 1);
			} else {
				return -1;
			}
		}
		
		return getTotalPriceAfterApplyingFreebieDiscount(countsMap);
	}
	
	private int getTotalPriceAfterApplyingFreebieDiscount(HashMap<String, Integer> countsMap) {
		int bestPrice = getTotalPriceForCountsMap(countsMap);
		
		for(FreebieDiscount freebieDiscount: productsMap.get("E").getFreebieDiscounts()) {
			int countE = countsMap.get("E");
			int batchSizeForFreebie = freebieDiscount.getBatchSize();
			String freebieItemName = freebieDiscount.getFreebieItemName();
			int countApplicableFreebieDiscounts = countE / batchSizeForFreebie;
			int freeBitItemCount = countsMap.get(freebieItemName);
			
			for(int i = 1; i <= countApplicableFreebieDiscounts; i++) {
				if(i <= freeBitItemCount) {
					HashMap<String, Integer> countsMapCopy = new HashMap<>(countsMap);
					countsMapCopy.put(freebieItemName, freeBitItemCount - i);
					int newPrice = getTotalPriceForCountsMap(countsMapCopy);
					bestPrice = Math.min(bestPrice, newPrice);
				}
				
			}
		}
		
		return bestPrice;
	}
	
	private int getTotalPriceForCountsMap(HashMap<String, Integer> countsMap) {
		HashMap<String, Integer> totalPricesMap = getEmptyCountsMap();
		
		for(String item: countsMap.keySet()) {
			int countForItem = countsMap.get(item);
			int normalPriceForItem = productsMap.get(item).getNormalPricePerItem();
			List<PriceDiscount> priceDiscountsForItem = productsMap.get(item).getPriceDiscounts();
			int totalPriceForItem = getTotalPriceForItem(countForItem, normalPriceForItem, priceDiscountsForItem);
			
			totalPricesMap.put(item, totalPriceForItem);
		}
		
		return addTotalPrices(totalPricesMap);
	}
	
	private HashMap<String, Integer> getEmptyCountsMap() {
		HashMap<String, Integer> counts = new HashMap<>();
		counts.put("A", 0);
		counts.put("B", 0);
		counts.put("C", 0);
		counts.put("D", 0);
		counts.put("E", 0);
		
		return counts;
	}
	
	private int getTotalPriceForItem(int count, 
									int normalPriceForItem,
									List<PriceDiscount> priceDiscounts) {
		int bestPrice = count * normalPriceForItem;
		
		for(PriceDiscount priceDiscount: priceDiscounts) {
			List<PriceDiscount> priceDiscountsCopy = new ArrayList<>(priceDiscounts);
			priceDiscountsCopy.remove(priceDiscount);
			
			int numDiscountBatches = count / priceDiscount.getBatchSize();
			int numItemsNotDiscounted = count - (numDiscountBatches * priceDiscount.getBatchSize());
			
			int discountPrice = numDiscountBatches * priceDiscount.getBatchPrice();
			int remainderPrice = getTotalPriceForItem(numItemsNotDiscounted, normalPriceForItem, priceDiscountsCopy);
			
			int price = discountPrice + remainderPrice;
			
			bestPrice = Math.min(bestPrice, price); 
		}
		
		return bestPrice;
	}
	
	private int addTotalPrices(HashMap<String, Integer> totalPricesMap) {
		int totalPrice = 0;
		
		for(String item: totalPricesMap.keySet()) {
			int totalPriceForItem = totalPricesMap.get(item);
			totalPrice += totalPriceForItem;
		}
		
		return totalPrice;
	}
}
