package org.weddingplanner.form.weddingvenues;

import org.springframework.stereotype.Repository;
import org.weddingplanner.form.cities.City;
import org.weddingplanner.utils.DaoUtils;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
@Transactional
public class ChurchDaoImpl implements ChurchDao {
    private static final String GET_CHURCHES_QUERY = "SELECT * FROM \"Church\"";

    private List<Church> getConvertedChurches(ResultSet resultSet) throws SQLException {
        ResutltSetToChurchListConverter converter = new ResutltSetToChurchListConverter();
        return converter.convert(resultSet);
    }

    @Override
    public List<Church> getChurchesList() throws SQLException {
        Connection connection = DaoUtils.INSTANCE.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_CHURCHES_QUERY);
        List<Church> churches = getConvertedChurches(resultSet);
        return churches;
    }
}
