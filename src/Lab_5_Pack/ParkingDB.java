package Lab_5_Pack;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;
import java.util.Optional;

public class ParkingDB {

    List<Parking> parking_list = new ArrayList<>();
    Connection connection;
    Record record;

    public ParkingDB()
    {
        try {
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:sqlite:5_lab.db");
        }
        catch (SQLException SQLException) {
            System.out.println(SQLException.getMessage());
        }
    }


    public List<Parking> getAll() {
        return parking_list;
    }



    public Optional<Parking> find(Record entity) {
        return Optional.ofNullable(parking_list.get(entity.privateAuto.getNumber()));
    }


    public boolean create(Record entity) throws SQLException {
        boolean isCreated = false;
        String sqlQuery = "INSERT INTO 'parking' VALUES (?,?,?,?) ";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,entity.privateAuto.getNumber());
            statement.setString(2,entity.privateAuto.getOwner());
            statement.setString(3, entity.getDateOfEnter());
            statement.setInt(4,entity.privateAuto.getParkingDays());
            isCreated = statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return isCreated;
    }


    public boolean update(Record entity) throws SQLException {
        boolean isUpdated = false;

        String sqlQuery = "Update parking set owner_name=? where number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(2,entity.privateAuto.getOwner());
            isUpdated = statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return isUpdated;
    }

    public boolean delete(Record entity) {
        boolean isDeleted= false;

        String sqlQuery = "delete from parking where number = ?";
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
