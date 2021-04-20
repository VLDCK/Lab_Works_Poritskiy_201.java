package Lab_5_Pack;

import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.*;
import Lab_3_Pack.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutoDAO implements DAO<PrivateAuto>{

    List<PrivateAuto> autos= new ArrayList<>();
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    public AutoDAO()
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
    public List<PrivateAuto> getAll() {
        String sqlQuery = "Select * from auto";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                int number = resultSet.getInt("number");
                String model = resultSet.getString("model");
                String owner_name = resultSet.getString("name");
                PrivateAuto privateAuto = new PrivateAuto(number,model,owner_name,0);
                autos.add(privateAuto);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return autos;
    }

    @Override
    public String find(int num) {

        String result = "";
        String sqlQuery = "Select * from auto where number = "+ num;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            resultSet = statement.executeQuery();
            int number = resultSet.getInt("number");
            String model = resultSet.getString("model");
            String name = resultSet.getString("name");

            result = "Number: "+number+" Model: "+model+" Name: "+name;

        }
        catch (SQLException e) {
            e.getMessage();
        }
        return result;
    }

    @Override
    public PrivateAuto create(PrivateAuto entity) throws SQLException {
        String sqlQuery = "INSERT INTO 'auto' VALUES (?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,entity.getNumber());
            statement.setString(2,entity.getModelOfCar());
            statement.setString(3,entity.getOwner());
            statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        }
        return entity;
    }

    @Override
    public boolean update(PrivateAuto entity) throws SQLException {
        boolean isUpdated = false;

        String sqlQuery = "Update auto set name_owner=? where number = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1,entity.getModelOfCar());
            isUpdated = statement.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        }
        return isUpdated;

    }

    @Override
    public boolean delete(PrivateAuto entity) {
        boolean isDeleted= false;
        String sqlQuery = "delete from auto where number = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1,entity.getNumber());
            isDeleted = statement.execute();
        }
        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return isDeleted;

    }
}
