package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactService {
	
    @Autowired
    ContactRepo contactDao;

    public boolean saveMessage(Contact contact){
        contactDao.save(contact);
        return true;
    }

}
