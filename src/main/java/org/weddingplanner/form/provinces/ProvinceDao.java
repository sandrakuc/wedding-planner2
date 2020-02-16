package org.weddingplanner.form.provinces;

import java.sql.SQLException;
import java.util.List;

public interface ProvinceDao {

    List<Province> getProvinceList() throws SQLException;

}
