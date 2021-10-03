package com.searchengine.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.searchengine.DAO.Purchase_EntryDAO;

@Controller
public class SearchController {
	
	@Autowired
	private Purchase_EntryDAO purchaseEntryDAO;
	
	@RequestMapping("/search/{keyword}")
	@ResponseBody
	//@CrossOrigin(origins = "http://127.0.0.1:5500")
	@CrossOrigin(origins = "*")
	public List<String> returnresults(@PathVariable("keyword") String keyword) {
		
		System.out.println("Search Handler executed");
		System.out.println("Keyword Received : "+keyword);
		String key="%"+keyword+"%";
		System.out.println("key= "+key);
		List<String> searchlist = purchaseEntryDAO.searchkeyword(key);
		System.out.println("Is searchlist isEmpty ::: "+searchlist.isEmpty());
//		for(String o:searchlist) {
//			System.out.println(o);
//		}
		System.out.println("returning");
		return searchlist;
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("home Handler executed");
		return "searchengine";
	}

}
