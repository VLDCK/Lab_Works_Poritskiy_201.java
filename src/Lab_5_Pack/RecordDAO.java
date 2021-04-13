package Lab_5_Pack;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Lab_3_Pack.Record;
import java.util.Optional;

public class RecordDAO implements DAO<Record>{

    List<Record> records = new ArrayList<>();
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    public RecordDAO()
    {
        try {
            if(connection == null)
                connection = connection();
        }

        catch (SQLException SQLException) {
            System.out.println(SQLException.getMessage());
        }
    }

    @Override
    public List<Record> getAll() {
        return records;
    }

    @Override
    public Optional<Record> find(Record entity) {
        return Optional.ofNullable(records.get(entity.privateAuto.getNumber()));
    }

    @Override
    public Record createRecord(Record entity) throws SQLException {
        String sqlQuery = "INSERT INTO 'records' VALUES (?,?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,entity.privateAuto.getNumber());
            statement.setString(2,entity.privateAuto.getModelOfCar());
            statement.setString(3,entity.privateAuto.getOwner());
            statement.setInt(4,entity.privateAuto.getParkingDays());

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        }
        return entity;
    }

    @Override
    public boolean update(Record entity) throws SQLException {
        boolean isUpdated = false;

        String sqlQuery = "Update records set model = ?, name=? where number = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1,entity.privateAuto.getModelOfCar());
            statement.setString(2,entity.privateAuto.getOwner());
            isUpdated = statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        }

        return isUpdated;

    }

    @Override
    public boolean delete(Record entity) {
        boolean isDeleted= false;

        String sqlQuery = "delete from records where number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,entity.privateAuto.getNumber());
            isDeleted = statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        }

        return isDeleted;

    }
}
