package test;

public class MemcacheTest {

/*	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) MyCache.getInstance().get("AllProducts");
		if(products != null) {
			return products;
		}

		products = getAllProductsFromDB()
				if(products) {
					MyCache.getInstance().put("AllProducts", 3600, customer);
				}
		return products;
	}

	public void updateProduct(String id) {
		updateProductIntoDB(id)
		MyCache.getInstance().delete("AllProducts");
	}

	public void deleteProduct(String id) {
		deleteProductFromDB(id)
		MyCache.getInstance().delete("AllProducts");
	}*/
	@org.junit.Test
	public void setTest () {
		Object ob = new String();
		ob = "values";
		MyCache.getInstance().delete("abc");
		MyCache.getInstance().set("abc", 3600, ob);
		Object resultOb = (String)MyCache.getInstance().get("abc");
		System.out.println("get Value: "+resultOb);
	}
	
}
