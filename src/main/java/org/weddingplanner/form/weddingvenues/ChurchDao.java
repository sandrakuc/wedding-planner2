package org.weddingplanner.form.weddingvenues;

import java.sql.SQLException;
import java.util.List;

public interface ChurchDao {

    List<Church> getChurchesList() throws SQLException;
}
