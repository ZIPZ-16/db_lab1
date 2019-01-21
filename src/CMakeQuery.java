public class CMakeQuery {


    public static String getTextQuery(String table, String column, String query_type, String where)
    {
        String buff;
        switch (query_type)
        {
            case "SELECT" :
                buff = "SELECT" + " * FROM " + table + " WHERE " + column + " = " + where;
                break;
            case "UPDATE":
                buff = "UPDATE " + table + " SET " + column + "=" + where;
                break;
            case "DELETE":
                buff = "DELETE FROM" + " " + table + " WHERE " + column + "=" + where;
                break;
            default:
                buff = "Don't know this type of query";
        }
        return buff;
    }
}
