package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public class DatabaseCleaner extends DAOImpl {

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<String>();
       // tableNames.add("USERS");
        tableNames.add("apartaments");
        tableNames.add("apclasses");
        tableNames.add("comments");
        tableNames.add("extras");
        tableNames.add("klients");
        tableNames.add("paiments");
        tableNames.add("rezervations");
        tableNames.add("rooms");
        tableNames.add("thumbs");
        return tableNames;
    }

    public void cleanDatabase() throws DBException {
       // System.out.println("cleanDB_vt");
        for(String tableName : getTableNames()) {
            Connection connection = getConnection();
            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("delete from " + tableName);
                preparedStatement.executeUpdate();
            } catch (Throwable e) {
                System.out.println("Exception while execute cleanDatabase() for table " + tableName);
                e.printStackTrace();
                throw new DBException(e);
            } finally {
                closeConnection(connection);
            }
        }
    }

}
