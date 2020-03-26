package org.weddingplanner.form.cities;

import org.weddingplanner.form.provinces.Province;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetToCityListConverter {

    public List<City> convert(ResultSet resultSet) throws SQLException {
        List<City> cities = new ArrayList<>();
        while (resultSet.next()) {
            Province province = new Province().builder()
                    .id(resultSet.getLong("ProvinceId"))
                    .name(resultSet.getString("provinceName"))
                    .build();
            City city = City.builder()
                    .id(resultSet.getLong("Id"))
                    .name(resultSet.getString("Name"))
                    .province(province)
                    .build();
            cities.add(city);
        }
        return cities;
    }
}
