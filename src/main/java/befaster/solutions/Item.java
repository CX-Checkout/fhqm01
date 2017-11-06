package befaster.solutions;

public class Item {

	private final String name;
	private final int normalPricePerItem;
	private final int discountBatchSize;
	private final int discountBatchPrice;
	
	public Item(String name, 
			int normalPricePerItem, 
			int discountBatchSize, 
			int discountBatchPrice) {
		this.name = name;
		this.normalPricePerItem = normalPricePerItem;
		this.discountBatchSize = discountBatchSize;
		this.discountBatchPrice = discountBatchPrice;
	}

	public String getName() {
		return name;
	}

	public int getNormalPricePerItem() {
		return normalPricePerItem;
	}

	public int getDiscountBatchSize() {
		return discountBatchSize;
	}

	public int getDiscountBatchPrice() {
		return discountBatchPrice;
	}
}
