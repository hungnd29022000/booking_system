package hungnd.booking_system.dao.jdbc;

import hungnd.booking_system.global.ConfigInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDao {
    protected static final Logger eLogger = LogManager.getLogger("ErrorLog");
    protected static final Logger cLogger = LogManager.getLogger("CacheLog");
    protected static final Logger pLogger = LogManager.getLogger("WorkerLog");

    protected  static final String t_booking = ConfigInfo.TABLE_BOOKING;
    protected  static final String t_apartment = ConfigInfo.TABLE_APARTMENT;
    protected  static final String t_role = ConfigInfo.TABLE_ROLE;
    protected  static final String t_user = ConfigInfo.TABLE_USER;
    protected void releaseConnect(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
