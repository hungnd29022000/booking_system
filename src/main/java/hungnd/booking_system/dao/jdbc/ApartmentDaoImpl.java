package hungnd.booking_system.dao.jdbc;

import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.factory.MySQLConnectionFactory;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.utils.CommonUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class ApartmentDaoImpl extends AbstractDao implements ApartmentDao{

}
