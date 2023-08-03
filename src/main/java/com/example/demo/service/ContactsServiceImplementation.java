package com.example.demo.service;

import com.example.demo.entity.ContactEntity;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactsServiceImplementation implements ContactService{
    private final ContactRepository contactRepository;

    public ContactsServiceImplementation(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public Contact saveContact(Contact contact) {
        ContactEntity contactEntity=new ContactEntity();
        BeanUtils.copyProperties(contact,contactEntity);
        contactRepository.save(contactEntity);
        return contact;
    }

    @Override
    public List<Contact> fetchAllContacts() {
       List<ContactEntity> contactEntities=contactRepository.findAll();
       List<Contact> contacts=contactEntities
               .stream()
               .map(contactEntity -> new Contact(
                       contactEntity.getId(),
                       contactEntity.getName(),
                       contactEntity.getAddress(),
                       contactEntity.getPhoneNumber(),
                       contactEntity.getEmail()
               )).collect(Collectors.toList());
       return contacts;
    }

    @Override
    public boolean deleteContact(Long id) {
      ContactEntity contact=contactRepository.findById(id).get();
         contactRepository.delete(contact);
         return false;
        }

}
