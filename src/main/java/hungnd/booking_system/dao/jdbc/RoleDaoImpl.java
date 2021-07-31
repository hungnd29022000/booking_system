package hungnd.booking_system.dao.jdbc;

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

}
