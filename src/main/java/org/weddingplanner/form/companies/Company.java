package org.weddingplanner.form.companies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;

    @Column(name="Category")
    private String category;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private int price;

    @Column(name="Guests")
    private int guests;

    @Column(name="Website")
    private String website;

    @Column(name="City")
    private String city;

    @Column(name="Address")
    private String address;

    @Column(name="Image")
    private String image;
}
