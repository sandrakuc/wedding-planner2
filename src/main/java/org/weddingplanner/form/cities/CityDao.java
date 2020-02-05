package org.weddingplanner.form.cities;

import org.weddingplanner.form.provinces.ProvinceDao;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {

    List<City> getCitiesList() throws SQLException;
}
