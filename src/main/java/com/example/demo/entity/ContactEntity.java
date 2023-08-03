package com.example.demo.entity;


import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Contacts")
public  class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" ,nullable = false)
    private  String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber" ,nullable = false,unique = true)
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
