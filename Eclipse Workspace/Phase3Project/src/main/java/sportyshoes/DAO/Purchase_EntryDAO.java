package sportyshoes.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sportyshoes.CRUD.Purchase_EntryCRUD;
import sportyshoes.MODELS.Purchase_Entry;

@Repository
public class Purchase_EntryDAO implements Purchase_EntryCRUD {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	
	public Purchase_Entry getpurchase_entry(int purchase_entry_id) {
		
		hibernateTemplate.clear();
		Purchase_Entry pe=hibernateTemplate.get(Purchase_Entry.class, purchase_entry_id);
		return pe;
	}
	
	@Transactional
	public String addPurchase_Entry(Purchase_Entry purchase_entry) {
		
		hibernateTemplate.clear();
		Integer i=(Integer)hibernateTemplate.save("Purchase_Entry", purchase_entry);
		
		if(i==null)
		{
			return "transaction-failed";
		}
		else
		{
			String msg="Purchase Entry Added with Id= "+i+" details are "+purchase_entry;
			return msg;
		}
		
	}

	@Transactional
	public String removePurchase_Entry(Purchase_Entry purchase_entry) {
		
		hibernateTemplate.clear();
		try {
			hibernateTemplate.delete("Purchase_Entry", purchase_entry);
			return "Delete Operation Successful, details "+purchase_entry+" Removed";
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "transaction-failed";
		}
	}

	@Transactional
	public String updatePurchase_Entry(int oldpurchaseid, Purchase_Entry newPurchase_Entry) {
		
		hibernateTemplate.clear();
		Purchase_Entry pe=hibernateTemplate.get(Purchase_Entry.class, oldpurchaseid);
		hibernateTemplate.clear();
		try {
			hibernateTemplate.update("Purchase_Entry", newPurchase_Entry);
			return "Update Successful Old : "+pe+" to New :"+newPurchase_Entry;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "transaction-failed";
		}
	}

	public List<Purchase_Entry> getallPurchase_Entrylist() {
		
		hibernateTemplate.clear();
		return hibernateTemplate.loadAll(Purchase_Entry.class);
		
	}

}
