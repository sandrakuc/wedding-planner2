package org.weddingplanner.form.cities.model;

import org.weddingplanner.form.cities.City;
import org.weddingplanner.form.provinces.model.ProvinceEntityToProvinceModelConverter;

import java.util.ArrayList;
import java.util.List;

public class CityEntityToCityModelConverter {

    public CityModel convert(City city){
        ProvinceEntityToProvinceModelConverter converter = new ProvinceEntityToProvinceModelConverter();
        CityModel cityModel = new CityModel().builder()
                .id(city.getId())
                .name(city.getName())
                .province(converter.convert(city.getProvince()))
                .build();
        return cityModel;
    }

    public List<CityModel> convertList(List<City> cities){
        List<CityModel> cityModels = new ArrayList<>();
        for(City city : cities){
            cityModels.add(convert(city));
        }
        return cityModels;
    }
}
