package org.weddingplanner.form.provinces;

import org.springframework.stereotype.Repository;
import org.weddingplanner.utils.DaoUtils;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.List;

@Repository
@Transactional
public class ProvinceDaoImpl implements ProvinceDao {

    private static final String GET_PROVINCES_QUERY = "SELECT * FROM \"Province\"";

    private List<Province> getConvertedProvinces(ResultSet resultSet) throws SQLException {
        ResultSetToProvinceListConverter converter = new ResultSetToProvinceListConverter();
        return converter.convert(resultSet);
    }

    @Override
    public List<Province> getProvinceList() throws SQLException {
        Connection connection = DaoUtils.INSTANCE.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_PROVINCES_QUERY);
        List<Province> provinces = getConvertedProvinces(resultSet);
        return provinces;
    }

}
