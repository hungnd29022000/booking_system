package hungnd.booking_system.dao;

import hungnd.booking_system.entity.User;
import hungnd.booking_system.factory.MySQLConnectionFactory;
import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.model.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@Component
public class UserDaoImpl extends AbstractDao implements UserDao{
    @Autowired
    private RoleDao roleDao;

    @Override
    public User getUserById(String userId) {
        User user = new User();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM " + t_user +
                " WHERE user_id = "+userId;
        try {
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                user.setUserId(rs.getString("user_id"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPhone(rs.getString("user_phone"));
                user.setUserPassword(rs.getString("user_password"));
            }
        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return user;
    }

    @Override
    public User postUser(UserRequest userRequest) {
        User user = new User();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO user(user_name,user_password,user_phone,user_email) " +
                 " VALUES(?,?,?,?) ";
        try {
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,userRequest.getUserName());
            stmt.setString(2,userRequest.getUserPassword());
            stmt.setString(3,userRequest.getUserPhone());
            stmt.setString(4,userRequest.getUserEmail());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            while(rs.next()){
                user = getUserById(rs.getString(1));
            }
        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        //set role user
        roleDao.postRole(new RoleRequest("low", user.getUserId()));
        return user;
    }
}
