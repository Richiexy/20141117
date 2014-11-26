package com.xy.common;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.xy.model.Contact;

@Component
public class Util {

	public List<Contact> getContactsFromRequest(Object data){

		List<Contact> list;

		//it is an array - have to cast to array object
		if (data.toString().indexOf('[') > -1){

			list = getListContactsFromJSON(data);

		} else { //it is only one object - cast to object/bean

			Contact contact = getContactFromJSON(data);

			list = new ArrayList<Contact>();
			list.add(contact);
		}

		return list;
	}

	private Contact getContactFromJSON(Object data){
		JSONObject jsonObject = JSONObject.fromObject(data);
		Contact newContact = (Contact) JSONObject.toBean(jsonObject, Contact.class);
		return newContact;
	}

	private List<Contact> getListContactsFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Contact> newContacts = (List<Contact>) JSONArray.toCollection(jsonArray,Contact.class);
		return newContacts;
	}

	public List<Integer> getListIdFromJSON(Object data){
		JSONArray jsonArray = JSONArray.fromObject(data);
		List<Integer> idContacts = (List<Integer>) JSONArray.toCollection(jsonArray,Integer.class);
		return idContacts;
	}
}