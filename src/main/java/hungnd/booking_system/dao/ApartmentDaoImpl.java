package hungnd.booking_system.dao;

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
    @Override
    public Apartment getApartmentById(String apartmentId) {
        Apartment apartment = new Apartment();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * " +
                "FROM " + t_apartment +
                " WHERE " +
                " apartment_id = " + apartmentId;
        try{
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                apartment.setApartmentName(rs.getString("apartment_name"));
                apartment.setApartmentId(rs.getInt("apartment_id"));
                apartment.setApartmentArea(rs.getDouble("apartment_area"));
                apartment.setApartmentAddress(rs.getString("apartment_address"));
                apartment.setApartmentCapacity(rs.getInt("apartment_capacity"));
                apartment.setApartmentPrice(rs.getDouble("apartment_price"));
                apartment.setUserId(rs.getInt("user_id"));
                apartment.setDayMin(rs.getInt("day_min"));
                apartment.setDayMax(rs.getInt("day_max"));
            }
        } catch (Exception e) {
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return apartment;
    }

    @Override
    public Apartment postApartment(ApartmentResquest apartmentResquest) {
        Apartment result = new Apartment();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO apartment(" +
                "user_id,apartment_name,apartment_area,apartment_address,apartment_capacity,apartment_price,day_min,day_max" +
                ")" +
                " VALUES(?,?,?,?,?,?,?,?)";
        try{
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,""+apartmentResquest.getUserId());
            stmt.setString(2,""+apartmentResquest.getApartmentName());
            stmt.setString(3,""+apartmentResquest.getApartmentArea());
            stmt.setString(4,""+apartmentResquest.getApartmentAddress());
            stmt.setString(5,""+apartmentResquest.getApartmentCapacity());
            stmt.setString(6,""+apartmentResquest.getApartmentPrice());
            stmt.setString(7,""+apartmentResquest.getDayMin());
            stmt.setString(8,""+apartmentResquest.getDayMax());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            while(rs.next()){
                result = getApartmentById(""+rs.getInt(1));
            }
        } catch (Exception e) {
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return result;
    }

    @Override
    public Apartment updateApartment(ApartmentResquest apartmentResquest) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "UPDATE "+ t_apartment +
                " SET ";
        if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentName())) {
            sql += " apartment_name = '" + apartmentResquest.getApartmentName() + "'";
        }if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentAddress())) {
            sql += " AND apartment_address = '" + apartmentResquest.getApartmentAddress() + "'";
        }if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentPrice())) {
            sql += " AND apartment_price = " + apartmentResquest.getApartmentPrice();
        }if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentArea())) {
            sql += " AND apartment_area = " + apartmentResquest.getApartmentArea();
        }if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentCapacity())) {
            sql += " AND apartment_capacity = " + apartmentResquest.getApartmentCapacity();
        }if(!CommonUtils.checkEmpty(apartmentResquest.getUserId())) {
            sql += " AND user_id = " + apartmentResquest.getUserId() ;
        }if(!CommonUtils.checkEmpty(apartmentResquest.getDayMin())) {
            sql += " AND day_min = " + apartmentResquest.getDayMin() ;
        }if(!CommonUtils.checkEmpty(apartmentResquest.getDayMax())) {
            sql += " AND day_max = " + apartmentResquest.getDayMax();
        }

        sql+=  " WHERE apartment_id = "+apartmentResquest.getApartmentId();
        try{
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return getApartmentById(""+apartmentResquest.getApartmentId());
    }
}
