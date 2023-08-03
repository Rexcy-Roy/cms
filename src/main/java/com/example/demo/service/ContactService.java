package com.example.demo.service;

import com.example.demo.model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {
    Contact saveContact(Contact contact);
    List <Contact> fetchAllContacts();
    boolean deleteContact(Long id);
}
