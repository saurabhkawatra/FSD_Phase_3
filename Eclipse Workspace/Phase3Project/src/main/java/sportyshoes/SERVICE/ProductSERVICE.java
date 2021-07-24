package sportyshoes.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sportyshoes.DAO.ProductDAO;
import sportyshoes.MODELS.Product;

@Service
public class ProductSERVICE {
	
	@Autowired
	private ProductDAO productDAO;
	
	public ProductSERVICE() {
		super();
	}


	public Product getProduct(int product_id) {
		
		return productDAO.getProduct(product_id);
	}
	
	
	public String addProduct(Product product) {
		
		return productDAO.addProduct(product);
	}
	
	
	public String removeProduct(Product product) {
		
		return productDAO.removeProduct(product);
	}
	
	
	public String updateProduct(int oldProductid, Product newProduct) {
		
		return productDAO.updateProduct(oldProductid, newProduct);
	}
	
	
	public List<Product> getallProductlist() {
		
		return productDAO.getallProductlist();
	}

}
