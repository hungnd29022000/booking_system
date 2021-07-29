package hungnd.booking_system.factory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hungnd.booking_system.global.ConfigInfo;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnectionFactory {

    private static MySQLConnectionFactory ourInstance;

    public static MySQLConnectionFactory getInstance() {
        if (ourInstance == null) {
            synchronized (MySQLConnectionFactory.class) {
                if (ourInstance == null) {
                    ourInstance = new MySQLConnectionFactory();
                }
            }
        }
        return ourInstance;
    }

    private static HikariDataSource ds;

    private MySQLConnectionFactory() {
        HikariConfig config = new HikariConfig();
        config.setPoolName("Hikari-MySQL-Pool");
        config.setJdbcUrl(ConfigInfo.MYSQL_JDBC_URL);
        config.setUsername(ConfigInfo.MYSQL_USERNAME);
        config.setPassword(ConfigInfo.MYSQL_PASSWORD);
        config.setMaximumPoolSize(ConfigInfo.MYSQL_MAXIMUM_POOL_SIZE);
        config.setMinimumIdle(ConfigInfo.MYSQL_MINIMUM_IDLE_SIZE);

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setAutoCommit(true);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", true);
        ds = new HikariDataSource(config);
    }

    public Connection getMySQLConnection() throws SQLException {
        return ds.getConnection();
    }
}
