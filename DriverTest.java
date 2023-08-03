import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverTest {

    /**
     * HiveServer2 JDBC driver name
     */
    private static String driverName = "com.cloudera.hive.jdbc.HS2Driver";
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Connection conn = DriverManager.getConnection("jdbc:hive2://xxxx:10000/default;SSL=1;SSLTrustStore=/var/lib/cloudera-scm-agent/agent-cert/cm-auto-global_truststore.jks;SSLTrustStorePwd=Sg9PLFJKSaW2glexFc8ZWMh132vKGBmbHYmQQgDu3qU;LogLevel=6;LogPath=/tmp;KrbRealm=xxxxx;KrbHostFQDN=xxxxxxx;KrbServiceName=hive;AuthMech=1");
        Statement stmt = conn.createStatement();
        // show tables
        String sql = "SHOW databases";
        System.out.println("Running: " + sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();

        // Table information. Uncomment it if you want to get table information
        /*
        String sql2 = "select * from es_cms_daily_subscriber limit 5;";
        System.out.println("Running: " + sql2);
        ResultSet rs2 = stmt.executeQuery(sql2);
        ResultSetMetaData rsmd = rs2.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs2.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1)
                    System.out.print(",  ");
                String columnValue = rs2.getString(i);
                System.out.print(rsmd.getColumnName(i) + " " + columnValue);
            }
            System.out.println("");
        }
        rs2.close();
         */

        conn.close();
    }
}

