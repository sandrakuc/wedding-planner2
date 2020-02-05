package org.weddingplanner.form.provinces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetToProvinceListConverter {

    public List<Province> convert(ResultSet resultSet) throws SQLException {
        List<Province> provinces = new ArrayList<>();
        while (resultSet.next()) {
            Province province = Province.builder()
                    .id(resultSet.getLong("Id"))
                    .name(resultSet.getString("Name"))
                    .build();
            provinces.add(province);
        }
        return provinces;
    }
}
