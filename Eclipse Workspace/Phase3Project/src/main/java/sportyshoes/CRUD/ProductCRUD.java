package sportyshoes.CRUD;

import java.util.List;

import sportyshoes.MODELS.Product;

public interface ProductCRUD {
	
	public Product getProduct(int product_id);
	
	public String addProduct(Product product);
	
	public String removeProduct(Product product);
	
	public String updateProduct(int oldProductid,Product newProduct);
	
	public List<Product> getallProductlist();
	
}
