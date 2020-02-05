package org.weddingplanner.form.cities;

import org.springframework.stereotype.Repository;
import org.weddingplanner.form.provinces.ProvinceDao;
import org.weddingplanner.form.provinces.ResultSetToProvinceListConverter;
import org.weddingplanner.utils.DaoUtils;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
@Transactional
public class CityDaoImpl implements CityDao {

    private static final String GET_CITIES_QUERY = "SELECT \"City\".\"ProvinceId\", \"City\".\"Name\", \"City\".\"Id\", \"Province\".\"Name\" AS \"provinceName\" FROM \"City\", \"Province\" WHERE \"City\".\"ProvinceId\" = \"Province\".\"Id\"";

    private List<City> getConvertedCities(ResultSet resultSet) throws SQLException {
        ResultSetToCityListConverter converter = new ResultSetToCityListConverter();
        return converter.convert(resultSet);
    }

    @Override
    public List<City> getCitiesList() throws SQLException {
        Connection connection = DaoUtils.INSTANCE.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_CITIES_QUERY);
        List<City> cities = getConvertedCities(resultSet);
        return cities;
    }
}
