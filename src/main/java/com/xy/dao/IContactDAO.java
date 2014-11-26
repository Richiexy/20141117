package com.xy.dao;

import java.util.List;

import com.xy.model.Contact;

public interface IContactDAO {

	public List<Contact> getContacts() ;
	
	public void deleteContact(int id);
	
	public Contact saveContact(Contact contact);
}
