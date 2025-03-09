package com.ecommerse.app.applayer;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name ="categories")//if name is not specified it will give the class name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="CUSTOMER_NAME")
    private  String name;
    @Column(name="PICK_UP")
    private String from;
    @Column(name="DROP_OFF")
    private String to;
    @Column(name = "PHONE_NUMBER")
    private long number;
    @Column(unique = true, nullable = false)
    private String pnrNumber;
    @PrePersist
    public void generatePnrNumber() {
        this.pnrNumber = "PNR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }


//    public Category(long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Category() {
//
//    }
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

}
