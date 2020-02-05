package org.weddingplanner.form.weddingvenues.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueModel {

   private String name;

   private String street;

   private String possessionNumber;

   private String postalCode;

   private String city;
}
