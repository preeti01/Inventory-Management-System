import java.util.Hashtable;



	public interface InventoryManagementSystem 
	{
		/**
		* Deduct 'amountToPick' of the given 'productId' from inventory.
		* @param productId The ID of the product to pick
		* @param amountToPick The quantity of the product to pick
		* @return TODO: to be implemented
		*/
		PickingResult pickProduct(String productId, int amountToPick);
		/**
		* Add 'amountToRestock' of the given productId to inventory.
		* @param productId The ID of the product to restock
		* @param amountToRestock The quantity of the product to restock
		* @return TODO: to be implemented
		*/
		RestockingResult restockProduct(String productId, int amountToRestock);
}

class IMSystem implements InventoryManagementSystem
{
	
	Hashtable<String, Product> productsMap = new Hashtable<String,Product>();
     
	public PickingResult pickProduct(String productId, int amountToPick) 
	{
		
		if(productsMap.containsKey(productId))
	    {
		Product product=productsMap.get(productId);
		product.inventoryLevel=product.inventoryLevel-amountToPick;//update inventory
		return new PickingResult(product);
		}
		return null;
	}

	public RestockingResult restockProduct(String productId, int amountToRestock) 
	{
		
		if(productsMap.containsKey(productId))
		{
		Product product = productsMap.get(productId);
        product.inventoryLevel=product.inventoryLevel+amountToRestock;
        return new RestockingResult(product);
	    }
		return null;
	}
	
		
	public void addNewProduct(Product product) {
        productsMap.put(product.getProductId(), product);
    }

}