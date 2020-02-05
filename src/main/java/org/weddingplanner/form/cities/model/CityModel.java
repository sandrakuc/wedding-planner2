package org.weddingplanner.form.cities.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.weddingplanner.form.provinces.model.ProvinceModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityModel {

    private long id;

    private String name;

    private ProvinceModel province;
}
