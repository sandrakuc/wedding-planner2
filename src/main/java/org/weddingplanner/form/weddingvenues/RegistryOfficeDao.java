package org.weddingplanner.form.weddingvenues;

import java.sql.SQLException;
import java.util.List;

public interface RegistryOfficeDao {
    List<RegistryOffice> getRegistryOffices() throws SQLException;
}
