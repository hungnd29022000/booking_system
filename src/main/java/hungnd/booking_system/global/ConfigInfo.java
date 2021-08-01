package hungnd.booking_system.global;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class ConfigInfo {
    private static Config config = ConfigFactory.parseFile(new File("conf.properties"));

    public static final int SERVICE_PORT = config.getInt("service.port");

    //-----------------------------------------------------------------------------------------------
    public static final String MYSQL_JDBC_URL = config.getString("mysql.jdbc.url");
    public static final String MYSQL_USERNAME = config.getString("mysql.username");
    public static final String MYSQL_PASSWORD = config.getString("mysql.password");
    public static final int MYSQL_MAXIMUM_POOL_SIZE = config.getInt("mysql.maximum.pool.size");
    public static final int MYSQL_MINIMUM_IDLE_SIZE = config.getInt("mysql.minimum.idle.size");
    //----------------------------------------------------------------------------------------------
    public static final String TABLE_BOOKING = config.getString("table.mysql.booking");
    public static final String TABLE_APARTMENT = config.getString("table.mysql.apartment");
    public static final String TABLE_ROLE = config.getString("table.mysql.role");
    public static final String TABLE_USER = config.getString("table.mysql.user");

    public static final String KEY = config.getString("secret.key");
}
