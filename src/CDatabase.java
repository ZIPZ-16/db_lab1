import java.sql.*;
import java.util.ArrayList;

class CDatabase {
    private Connection connection = null;

    CDatabase() {
        String host = "jdbc:mysql://localhost:3306/larablog?useLegacyDatetimeCode=false&serverTimezone=Europe/Kiev";
        String name = "root";
        String password = "";
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