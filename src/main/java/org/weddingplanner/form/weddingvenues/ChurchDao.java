package org.weddingplanner.form.weddingvenues;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public interface ChurchDao {

    List<Church> getChurchesList() throws SQLException;
}
