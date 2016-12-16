/**
 * 
 * Product class with product information 
 *
 */
public class Product 
{
	String productId;
	int inventoryLevel;
	String location;
	
	public Product(String productId, int inventoryLevel, String location)
	{	
		this.productId = productId;
		this.inventoryLevel = inventoryLevel;
		this.location = location;
	}
	
	public String getProductId() 
	{
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getInventoryLevel() {
		return inventoryLevel;
	}

	public void setInventoryLevel(int inventoryLevel) {
		this.inventoryLevel = inventoryLevel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	
}
