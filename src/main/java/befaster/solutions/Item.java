package befaster.solutions;

import java.util.List;

public class Item {

	private final String name;
	private final int normalPricePerItem;
	private final List<PriceDiscount> priceDiscounts;
	private final List<FreebieDiscount> freebieDiscounts;
	
	public Item(String name, 
			int normalPricePerItem,
			List<PriceDiscount> priceDiscounts,
			List<FreebieDiscount> freebieDiscounts) {
		this.name = name;
		this.normalPricePerItem = normalPricePerItem;
		this.priceDiscounts = priceDiscounts;
		this.freebieDiscounts = freebieDiscounts;
	}

	public String getName() {
		return name;
	}

	public int getNormalPricePerItem() {
		return normalPricePerItem;
	}

	public List<PriceDiscount> getPriceDiscounts() {
		return priceDiscounts;
	}

	public List<FreebieDiscount> getFreebieDiscounts() {
		return freebieDiscounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((freebieDiscounts == null) ? 0 : freebieDiscounts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + normalPricePerItem;
		result = prime * result + ((priceDiscounts == null) ? 0 : priceDiscounts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (freebieDiscounts == null) {
			if (other.freebieDiscounts != null)
				return false;
		} else if (!freebieDiscounts.equals(other.freebieDiscounts))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (normalPricePerItem != other.normalPricePerItem)
			return false;
		if (priceDiscounts == null) {
			if (other.priceDiscounts != null)
				return false;
		} else if (!priceDiscounts.equals(other.priceDiscounts))
			return false;
		return true;
	}
	
	
}
