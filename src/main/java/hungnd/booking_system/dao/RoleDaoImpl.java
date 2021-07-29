package hungnd.booking_system.dao;

import hungnd.booking_system.entity.Role;
import hungnd.booking_system.factory.MySQLConnectionFactory;
import hungnd.booking_system.model.request.RoleRequest;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@Component
public class RoleDaoImpl extends AbstractDao implements RoleDao{
    @Override
    public Role getRoleById(String roleId) {
        Role role = new Role();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM " +t_role+
                " WHERE role_id = " + roleId;
        try {
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                role.setRoleId(rs.getString("role_id"));
                role.setRoleName(rs.getString("role_name"));
                role.setUserId(rs.getString("user_id"));
            }
        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return role;
    }

    @Override
    public Role postRole(RoleRequest roleRequest) {
        Role role = new Role();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO role(role_name,user_id) VALUES (?,?)";
        try {
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,roleRequest.getRoleName());
            stmt.setString(2,roleRequest.getUserId());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            while(rs.next()){
                role = getRoleById(rs.getString(1));
            }
        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return role;
    }
}
