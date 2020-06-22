package by.repository;


import by.repository.dbConstants.*;
import java.util.Map;

public class SQLHelper {
    public static final String ID = "id";
    private static final String INSERT_QUERY = "INSERT INTO ";
    private static final String VALUES = "VALUES";
    private static final String WHERE = "WHERE ";
    private static final String SELECT = "SELECT";
    private static final String USER_TABLE = "users";
    private static final String PERSON_TABLE = "person";
    public final static String SQL_GET_PERSONS = "select * from " + USER_TABLE;
    public final static String SQL_INSERT_PERSON = "INSERT INTO " + PERSON_TABLE + "(" +
            PersonTableConstant.NAMEL +
            "," + PersonTableConstant.SURNAMEL + "," + PersonTableConstant.EMAIL + ") VALUES (? , ?, ?)";


    public final static String SQL_GET_USER = "SELECT " + UserTableConstant.ID.getfielName() + ", " +
            UserTableConstant.LOGIN.getfielName() + ", " +
            UserTableConstant.PASSWORD.getfielName() + " from " + USER_TABLE + " WHERE " +
            UserTableConstant.LOGIN.getfielName() + " =? and " +
            UserTableConstant.PASSWORD.getfielName() + " =?";


    public final static String SQL_CHECK_LOGIN = "SELECT " + UserTableConstant.LOGIN.getfielName() +
            " FROM " +
            USER_TABLE + " WHERE " + UserTableConstant.LOGIN.getfielName() + " = ?";

    public final static String SQL_INSERT_USER = "INSERT INTO " + USER_TABLE + "(" +
            UserTableConstant.LOGIN.getfielName() + " ," +
            UserTableConstant.PASSWORD.getfielName() + ") VALUES (? , ?)";

    public static String makeInsertQuery(Map<String, Object> fields, String table) {
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String column = entry.getKey();
            if (column.equals(ID)) {
                continue;
            }
            columns.append(column).append(", ");
            values.append("?, ");
        }
        values.deleteCharAt(values.lastIndexOf(","));
        columns.deleteCharAt(columns.lastIndexOf(","));
        values.append(")");
        columns.append(")");
        return INSERT_QUERY + table + columns + VALUES + values + ";";
    }
}
