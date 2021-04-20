package Lab_5_Pack;

import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {

        RecordDAO recordDAO = new RecordDAO();
        AutoDAO autoDAO = new AutoDAO();

        Record record = new Record(new PrivateAuto( 1910120, "Audi", "Bob", 10));
        Record record1 = new Record(new PrivateAuto(5210241, "Tesla", "Ivan", 7));
        Record record2 = new Record(new PrivateAuto(9812333, "BMW", "Tom", 15));

        PrivateAuto privateAuto = new PrivateAuto(9947700, "Suzuki", "Don", 11);
        record.setDateOfEnter();
        record1.setDateOfEnter();
        record2.setDateOfEnter();

        List<Record> records = new ArrayList<>();
        List<PrivateAuto> autos = new ArrayList<>();
        /*records.add(record);
        records.add(record1);
        records.add(record2);*/
        
        records = recordDAO.getAll();
        for (Record i : records) {
            System.out.println(i.toString());
        }
        System.out.println("\n------------------------------\n");

        autos = autoDAO.getAll();
        for (PrivateAuto i : autos) {
            System.out.println(i.toString());
        }
        //records = recordDAO.getAll();

        //recordDAO.create(record);
        //recordDAO.create(record1);
        //recordDAO.create(record2);
        //autoDAO.create(privateAuto);

        //System.out.println(recordDAO.find(1910120));
        //System.out.println(autoDAO.find(9947700));

        


       // recordDAO.delete(record);
        //recordDAO.delete(record);
        //recordDAO.delete(record);
        //autoDAO.delete(privateAuto);







    }
}
