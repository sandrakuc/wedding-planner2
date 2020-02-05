package org.weddingplanner.form.weddingvenues;

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
@Table(name = "RegistryOffice")
public class RegistryOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Street")
    private String street;

    @Column(name = "PossessionNumber")
    private String possessionNumber;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "City")
    private String city;

}
