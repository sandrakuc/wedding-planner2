package org.weddingplanner.form.weddingvenues;

import org.springframework.stereotype.Repository;
import org.weddingplanner.utils.DaoUtils;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
@Transactional
public class RegistryOfficeDaoImpl implements RegistryOfficeDao{
    private static final String GET_REGISTRY_OFFICES_QUERY = "SELECT * FROM \"Registry Office\"";

    private List<RegistryOffice> getConvertedRegistryOffices(ResultSet resultSet) throws SQLException {
        ResultSetToRegistryOfficeListConverter converter = new ResultSetToRegistryOfficeListConverter();
        return converter.convert(resultSet);
    }


    @Override
    public List<RegistryOffice> getRegistryOffices() throws SQLException {
        Connection connection = DaoUtils.INSTANCE.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_REGISTRY_OFFICES_QUERY);
        List<RegistryOffice> registryOffices = getConvertedRegistryOffices(resultSet);
        return registryOffices;
    }
}
