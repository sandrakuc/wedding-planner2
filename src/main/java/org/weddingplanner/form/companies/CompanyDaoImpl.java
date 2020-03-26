package org.weddingplanner.form.companies;

import org.springframework.stereotype.Repository;
import org.weddingplanner.utils.DaoUtils;

import javax.transaction.Transactional;
import java.sql.*;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {

    private static final String GET_COMPANY_QUERY = "SELECT * FROM \"Companies\" WHERE \"Name\" = ? AND \"City\" = ?";

    private Company getConvertedCompany(ResultSet resultSet) {
        ResultToCompanyConverter converter = new ResultToCompanyConverter();
        return converter.convert(resultSet);
    }

    @Override
    public Company getCompanyByNameAndCity(String name, String city) throws SQLException {
        Connection connection = DaoUtils.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_COMPANY_QUERY);
        statement.setString(1, name);
        statement.setString(2, city);
        ResultSet resultSet = statement.getResultSet();
        Company company = getConvertedCompany(resultSet);
        return company;
    }
}
