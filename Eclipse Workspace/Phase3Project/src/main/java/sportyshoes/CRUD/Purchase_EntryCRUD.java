package sportyshoes.CRUD;

import java.util.List;

import sportyshoes.MODELS.Purchase_Entry;

public interface Purchase_EntryCRUD {
	
	public Purchase_Entry getpurchase_entry(int purchase_entry_id);
	
	public String addPurchase_Entry(Purchase_Entry purchase_entry);
	
	public String removePurchase_Entry(Purchase_Entry purchase_entry);
	
	public String updatePurchase_Entry(int oldpurchaseid,Purchase_Entry newPurchase_Entry);
	
	public List<Purchase_Entry> getallPurchase_Entrylist();

}
