package Lab_5_Pack;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;
import java.util.Optional;

public class RecordDAO implements DAO<Record>{

    List<Record> records = new ArrayList<>();
    Connection connection;
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
        String sqlQuery = "Select * from records";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                 int number = resultSet.getInt("number");
                 String model = resultSet.getString("model");
                 String ownerName = resultSet.getString("name");

                 Record record = new Record(new PrivateAuto(number,model,ownerName,0));
                 records.add(record);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return records;
    }

    @Override
    public String find(int num) {
        String result=null;
        String sqlQuery = "Select * from records where number = "+ num;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            resultSet = statement.executeQuery();

            int number = resultSet.getInt("number");
            String model = resultSet.getString("model");
            String ownerName = resultSet.getString("name");
            String enterDate = resultSet.getString("enter_day");

            result = "Number: "+number+" Model: "+model+" Name: "+ownerName+
                     " Date of enter: "+enterDate;
        }
        catch (SQLException e) {
        e.getMessage();
        }

        return result;
    }

    @Override
    public Record create(Record entity) throws SQLException {
        String sqlQuery = "INSERT INTO 'records' VALUES (?,?,?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,entity.privateAuto.getNumber());
            statement.setString(2,entity.privateAuto.getModelOfCar());
            statement.setString(3,entity.privateAuto.getOwner());
            statement.setString(4,entity.getDateOfEnter());
            statement.setInt(5,entity.privateAuto.getParkingDays());
            statement.execute();
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
            statement.setInt(3,entity.privateAuto.getNumber());
            isUpdated = statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return isUpdated;

    }

    @Override
    public boolean delete(Record record) {
        boolean isDeleted= false;

        String sqlQuery = "delete from records where number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,record.privateAuto.getNumber());
            isDeleted = statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return isDeleted;

    }
}
