import java.sql.*;
import java.util.ArrayList;

class CDatabase {
    private Connection connection = null;

    CDatabase() {
        String host = "jdbc:mysql://den1.mysql4.gear.host/veizdemdb1";
        String name = "veizdemdb1";
        String password = "Eo987?nCs5D~";
        try {
            this.connection = DriverManager.getConnection(host, name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] runQuery(String command) {
        ArrayList<String> buffer = new ArrayList<String>();
        String[] result = {""};
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(command);

            while (resultSet.next()) {
                buffer.add(resultSet.getString(1));
            }
            statement.close();
            resultSet.close();

            result = new String[buffer.size()];
            result = buffer.toArray(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}