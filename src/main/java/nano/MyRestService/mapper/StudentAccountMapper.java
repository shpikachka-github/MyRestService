package nano.MyRestService.mapper;

import nano.MyRestService.model.StudentAccountInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentAccountMapper implements RowMapper {

    public static final String BASE_SQL //
            = "Select sa.Id, sa.Full_Name, sa.Date_Of_Birth From Student_Account sa ";

    public StudentAccountInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("Id");
        String fullName = resultSet.getString("Full_Name");
        String dateOfBirth = resultSet.getString("Date_Of_Birth");

        return new StudentAccountInfo(id, fullName, LocalDate.parse(dateOfBirth));
    }
}
