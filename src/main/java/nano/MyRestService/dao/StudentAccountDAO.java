package nano.MyRestService.dao;

import nano.MyRestService.mapper.StudentAccountMapper;
import nano.MyRestService.model.StudentAccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class StudentAccountDAO extends JdbcDaoSupport {

    @Autowired
    public StudentAccountDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<StudentAccountInfo> getStudentAccount() {
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
        String sql = StudentAccountMapper.BASE_SQL;

        Object[] params = new Object[] {};
        StudentAccountMapper mapper = new StudentAccountMapper();

        return this.getJdbcTemplate().query(sql, params, mapper);
    }

    public StudentAccountInfo findStudentAccount(Long id) {
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
        // Where ba.Id = ?
        String sql = StudentAccountMapper.BASE_SQL + " where sa.Id = ? ";

        Object[] params = new Object[] { id };
        StudentAccountMapper mapper = new StudentAccountMapper();
        try {
            StudentAccountInfo studentAccount = (StudentAccountInfo) this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return studentAccount;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
