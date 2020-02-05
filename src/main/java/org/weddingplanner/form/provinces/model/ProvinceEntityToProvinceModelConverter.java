package org.weddingplanner.form.provinces.model;

import org.weddingplanner.form.provinces.Province;

import java.util.ArrayList;
import java.util.List;

public class ProvinceEntityToProvinceModelConverter {

    public ProvinceModel convert(Province province){
        ProvinceModel provinceModel = new ProvinceModel().builder()
                .id(province.getId())
                .name(province.getName())
                .build();
        return provinceModel;
    }

    public List<ProvinceModel> convertList(List<Province> provinces){
        List<ProvinceModel> provinceModels = new ArrayList<>();
        for(Province province : provinces){
            provinceModels.add(convert(province));
        }
        return provinceModels;
    }

}
