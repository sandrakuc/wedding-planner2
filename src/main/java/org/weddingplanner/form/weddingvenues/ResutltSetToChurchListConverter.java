package org.weddingplanner.form.weddingvenues;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResutltSetToChurchListConverter {

    public List<Church> convert(ResultSet resultSet) throws SQLException {
        List<Church> churches = new ArrayList<>();
        while (resultSet.next()){
            Church church = Church.builder()
                    .id(resultSet.getLong("Id"))
                    .name(resultSet.getString("Name"))
                    .street(resultSet.getString("Street"))
                    .possessionNumber(resultSet.getString("PossessionNumber"))
                    .postalCode(resultSet.getString("PostalCode"))
                    .city(resultSet.getString("City"))
                    .build();
            churches.add(church);
        }
        return churches;
    }
}
