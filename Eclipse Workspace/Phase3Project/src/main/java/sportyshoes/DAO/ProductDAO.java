package sportyshoes.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sportyshoes.CRUD.ProductCRUD;
import sportyshoes.MODELS.Product;
import sportyshoes.MODELS.Purchase_Entry;

@Repository
public class ProductDAO implements ProductCRUD{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	
	public Product getProduct(int product_id) {
		
		hibernateTemplate.clear();
		Product p=hibernateTemplate.get(Product.class, product_id);
		return p;
	}

	@Transactional
	public String addProduct(Product product) {
		
		hibernateTemplate.clear();
		Integer i=(Integer)hibernateTemplate.save("Product", product);
		
		if(i==null)
		{
			return "transaction-failed";
		}
		else
		{
			String msg="Product Added with Id= "+i+" details are "+product;
			return msg;
		}
	}

	@Transactional
	public String removeProduct(Product product) {
		
		hibernateTemplate.clear();
		try {
			hibernateTemplate.delete("Product", product);
			return "Delete Operation Successful, details "+product+" Removed";
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "transaction-failed";
		}
	}

	@Transactional
	public String updateProduct(int oldProductid, Product newProduct) {
		
		hibernateTemplate.clear();
		Product pe=hibernateTemplate.get(Product.class, oldProductid);
		hibernateTemplate.clear();
		try {
			hibernateTemplate.update("Product", newProduct);
			return "Update Successful Old : "+pe+" to New :"+newProduct;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "transaction-failed";
		}
	}

	public List<Product> getallProductlist() {
		
		hibernateTemplate.clear();
		return hibernateTemplate.loadAll(Product.class);
	}
}
