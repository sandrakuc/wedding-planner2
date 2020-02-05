package org.weddingplanner.form.weddingvenues;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetToRegistryOfficeListConverter {

    public List<RegistryOffice> convert(ResultSet resultSet) throws SQLException {
        List<RegistryOffice> registryOffices = new ArrayList<>();
        while (resultSet.next()){
            RegistryOffice registryOffice = RegistryOffice.builder()
                    .id(resultSet.getLong("Id"))
                    .name(resultSet.getString("Name"))
                    .street(resultSet.getString("Street"))
                    .possessionNumber(resultSet.getString("PossessionNumber"))
                    .postalCode(resultSet.getString("PostalCode"))
                    .city(resultSet.getString("City"))
                    .build();
            registryOffices.add(registryOffice);
        }
        return registryOffices;
    }
}
