package org.weddingplanner.form.companies;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultToCompanyConverter {

    public Company convert(ResultSet resultSet){
        List<Company> companies = new ArrayList<>();
        try {
            if (resultSet.next()) {
                while (resultSet.next()) {
                    Company company = new Company().builder()
                            .id(resultSet.getLong("Id"))
                            .category(resultSet.getString("Category"))
                            .name(resultSet.getString("Name"))
                            .price(resultSet.getInt("Price"))
                            .guests(resultSet.getInt("Guests"))
                            .website(resultSet.getString("Website"))
                            .city(resultSet.getString("City"))
                            .address(resultSet.getString("Address"))
                            .image(resultSet.getString("image"))
                            .build();
                    companies.add(company);
                }
            }
            return companies.isEmpty() ? null : companies.get(0);
        } catch (SQLException e){
            return null;
        }
    }
}
