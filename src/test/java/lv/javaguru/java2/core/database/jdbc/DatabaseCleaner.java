package lv.javaguru.java2.core.database.jdbc;

import lv.javaguru.java2.core.database.DBException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseCleaner extends DAOImpl {

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<String>();
        tableNames.add("hotels");
        tableNames.add("roomclasses");
        tableNames.add("comments");
        tableNames.add("extras");
        tableNames.add("clients");
        tableNames.add("payments");
        tableNames.add("reservations");
        tableNames.add("rooms");
        tableNames.add("thumbs");
        tableNames.add("users");
        tableNames.add("roles");
        tableNames.add("permissions");
        return tableNames;
    }

    public void cleanDatabase() throws DBException {
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
