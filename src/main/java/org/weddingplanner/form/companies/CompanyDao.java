package org.weddingplanner.form.companies;

import java.sql.SQLException;

public interface CompanyDao {

    Company getCompanyByNameAndCity(String name, String city) throws SQLException;

}
