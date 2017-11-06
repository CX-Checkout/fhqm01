package befaster.solutions;

public class PriceDiscount {

	private final int batchSize;
	private final int batchPrice;
	
	public PriceDiscount(int batchSize, int batchPrice) {
		this.batchSize = batchSize;
		this.batchPrice = batchPrice;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public int getBatchPrice() {
		return batchPrice;
	}

	@Override
	public int hashCode() {
		int result = batchSize;
		result = 31 * result + batchSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		PriceDiscount other = (PriceDiscount) obj;
		if (batchSize != other.batchSize) return false;
		return batchPrice == other.batchPrice;
	}
	
	
}
