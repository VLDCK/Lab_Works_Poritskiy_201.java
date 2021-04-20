package Lab_5_Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO <T>{

    List<T> getAll();

    String find(int number);

    T create(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(T entity) throws SQLException;

    default Connection connection() throws  SQLException {
        return DriverManager.getConnection("jdbc:sqlite:5_lab.db");

    }


}
