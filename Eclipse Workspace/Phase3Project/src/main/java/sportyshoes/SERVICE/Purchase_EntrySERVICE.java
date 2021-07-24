package sportyshoes.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sportyshoes.DAO.Purchase_EntryDAO;
import sportyshoes.MODELS.Purchase_Entry;


@Service
public class Purchase_EntrySERVICE {
	
	@Autowired
	private Purchase_EntryDAO purchase_entryDAO;
	

	public Purchase_Entry getpurchase_entry(int purchase_entry_id) {
		
			return purchase_entryDAO.getpurchase_entry(purchase_entry_id);
	}

	
	
	public String addPurchase_Entry(Purchase_Entry purchase_entry) {
		
			return purchase_entryDAO.addPurchase_Entry(purchase_entry);
	}

	public String removePurchase_Entry(Purchase_Entry purchase_entry) {
		
			return purchase_entryDAO.removePurchase_Entry(purchase_entry);
	}
	

	public String updatePurchase_Entry(int oldpurchaseid, Purchase_Entry newPurchase_Entry) {
		
			return purchase_entryDAO.updatePurchase_Entry(oldpurchaseid, newPurchase_Entry);
	}

	
	public List<Purchase_Entry> getallPurchase_Entrylist() {
		
		return purchase_entryDAO.getallPurchase_Entrylist();
	}

}
