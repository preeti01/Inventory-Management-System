import java.util.Scanner;

/**
 * 
 * Main class with main function providing functionality to perform basic
 * inventory management system
 *
 */

public class Main 
{

	/**
	 * @param unused args
	 */
	public static void main(String[] args) 
	{
		
			 IMSystem obj = new IMSystem();
			 int choice = 0;
             Scanner in = new Scanner(System.in);
             System.out.println("Please select an option");
             System.out.println("1 : Picking a product");
             System.out.println("2 : Restocking a product");
             System.out.println("3 : Adding a new product");
             System.out.println("4 : Exit system");
             
        try{
        	do
        	{
        		
        	 choice = Integer.parseInt(in.nextLine());
             switch (choice)
             {
             
               case 1:
            	 String product_id;
            	 int amountToPick;
                 System.out.println("Enter product id");
                 product_id=in.nextLine().trim();
                 System.out.println("Enter amount to restock ");
                 amountToPick=Integer.parseInt(in.nextLine().trim());
                 PickingResult pickingResult = obj.pickProduct(product_id,amountToPick);
                 if(pickingResult==null)
                 {
                	  System.out.println("there is no product");
                	  System.exit(0);
                 }
                 else
                 {
                   System.out.println("The number of " + pickingResult.getProduct().getProductId() + "'s left is " +
                   pickingResult.getProduct().getInventoryLevel());
                 }
            	 
              break;
             
             case 2:
            	 String id;
            	 int amountToStock;
                 System.out.println("Enter product id");
                 id=in.nextLine().trim();
                 System.out.println("Enter amount to restock ");
                 amountToStock=Integer.parseInt(in.nextLine().trim());
        	     RestockingResult restockingResult = obj.restockProduct(id,amountToStock);
        	     if(restockingResult==null)
        	     {
        	    	 System.out.println("No product with this id earlier");
        	    	 System.out.println("It's a new product. Add it as newproduct");
        	    	 System.exit(0);
            	 
        	     }
        	     else
        	     {
        	    	 System.out.println("The number of " + restockingResult.getProduct().getProductId() + "stored at"
                     + restockingResult.getProduct().getInventoryLevel());
             
        	     }
             
        	     break;
             
             case 3:
            	 String newProductId, location;
            	 int amount;
                 System.out.println("Enter product id");
                 newProductId=in.nextLine().trim();
                 System.out.println("Enter amount ");
                 amount=Integer.parseInt(in.nextLine().trim());
                 System.out.println("Enter some location like ZONE-1 etc");
                 location=in.nextLine().trim();
                 for(String productId:obj.productsMap.keySet())
                 {
                	if(obj.productsMap.get(productId).getLocation().equals(location))
                	{
                	System.out.println("Location exists. Try with new location");
                	System.exit(0);
                	}
                 }
                 obj.addNewProduct(new Product(newProductId, amount, location));
                 System.out.println("The product is stored at " + obj.productsMap.get(newProductId).location + " having items "
                         + obj.productsMap.get(newProductId).inventoryLevel);
                 break;
             
             case 4:
                 System.exit(0);
            }
        	
          }while(choice!=4);
             
        }
        catch(NumberFormatException e)
        {
        	System.out.print("Invalid argument");
        }
	}
	
}
