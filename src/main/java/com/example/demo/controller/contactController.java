package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("cms/api/v1")
public class contactController {
    private final ContactService contactService;


    public contactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @PostMapping("/saveContact")
    public Contact saveContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }
@DeleteMapping("/deleteContactBy/{id}")
   public ResponseEntity<Map<String,Boolean>>deleteContact(@PathVariable("id") Long id){
        boolean deleted=false;
        deleted= contactService.deleteContact(id);
        Map<String,Boolean>response=new HashMap<>();
        response.put("contact deleted successfully", deleted=true);
                return ResponseEntity.ok(response);
   }
   @GetMapping("/fetchContacts")
   public List <Contact> fetchAllContacts(){
        return contactService.fetchAllContacts();
   }
}
