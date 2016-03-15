package com.electricdroid.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.electricdroid.beans.WaContacts;
import com.electricdroid.util.HibernateUtil;

public class FindContact {
	// this is a singleton class i dont want it set again and again array list
	// and i have done everything in constructor so
	// dont want to get again db and then map of contacts and their name
	private static FindContact findContact = null;
	private static HashMap<String, String> hmKeyName;

	public FindContact(String username) {
		// big thing is my constructor is not public as i am following the
		// singleton design
		
		SessionFactory sf = HibernateUtil.getWASF(username);
		if(sf!=null){
			hmKeyName = new HashMap<String, String>();
		Session session = sf.openSession();
		String sql = "from WaContacts";
		Query query = session.createQuery(sql);
		List<WaContacts> list = query.list();
		Iterator<WaContacts> itr = list.iterator();
		WaContacts waContacts=null;
		while (itr.hasNext()) {
		waContacts	 =  (WaContacts) itr.next();
			if(waContacts.getDisplay_name()!=null)
			{
		hmKeyName.put(waContacts.getJid(), waContacts.getDisplay_name());		
			}
		
		}
		System.out.print(hmKeyName);
		session.close();
		sf.close();
		HibernateUtil.shutdownWA();
		}
		
	}

	public static FindContact getFindContactSinglton(String username) {
		if((findContact!=null)) return findContact;
			findContact = new FindContact(username);

		
		return findContact;
	}

	public String getDisplayName(String key) {
if(hmKeyName.get(key) == null){
	//if jid is not in map return his/her phone number with 91 prefix included
	if(key.endsWith("g.us")){
		return "Group";
	}
	return key.substring(0,key.indexOf("@")).toString();
} else
		return hmKeyName.get(key).toString();
	}

}
