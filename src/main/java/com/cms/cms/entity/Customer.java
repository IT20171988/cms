package com.cms.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(nullable = false, unique = true)
    private String nicNumber;

    @ElementCollection
    private List<String> mobileNumbers;

    @OneToMany
    private List<Customer> familyMembers;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

}