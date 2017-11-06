package befaster.solutions;

public class FreebieDiscount {

	private final int batchSize;
	private final String freebieItemName;
	
	public FreebieDiscount(int batchSize, String freebieItemName) {
		this.batchSize = batchSize;
		this.freebieItemName = freebieItemName;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public String getFreebieItemName() {
		return freebieItemName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchSize;
		result = prime * result + ((freebieItemName == null) ? 0 : freebieItemName.hashCode());
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
		FreebieDiscount other = (FreebieDiscount) obj;
		if (batchSize != other.batchSize)
			return false;
		if (freebieItemName == null) {
			if (other.freebieItemName != null)
				return false;
		} else if (!freebieItemName.equals(other.freebieItemName))
			return false;
		return true;
	}
	
	
}
