package hungnd.booking_system.dao.jdbc;

import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.factory.MySQLConnectionFactory;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.utils.CommonUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApartmentDaoImpl extends AbstractDao implements ApartmentDao{
    @Override
    public List<Apartment> findApartmentByUser(ApartmentResquest apartmentResquest, Double priceMax) {
        List<Apartment> apartments = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM "+ t_apartment + " as a" +
                " WHERE a.apartment_id NOT IN (" +
                    " SELECT b.apartment_id FROM " +t_booking + " as b" + " WHERE status IN (1,2,3)"+
                ")";
        if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentName())){
            sql += " AND name = '" + apartmentResquest.getApartmentName()+"'";
        }if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentArea())){
            sql += " AND area >= " + apartmentResquest.getApartmentArea();
        }if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentCapacity())){
            sql += " AND capacity > " + apartmentResquest.getApartmentCapacity();
        }if(!CommonUtils.checkEmpty(apartmentResquest.getApartmentPrice())){
            sql += " AND price >= " + apartmentResquest.getApartmentPrice();
        }if(!CommonUtils.checkEmpty(priceMax)){
            sql += " AND price <= " + priceMax;
        }

        System.out.println(sql);

        try{
            conn = MySQLConnectionFactory.getInstance().getMySQLConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Apartment apartment = new Apartment();
                apartment.setApartmentId(rs.getLong("apartment_id"));
                apartment.setAddress(rs.getString("address"));
                apartment.setArea(rs.getDouble("area"));
                apartment.setCapacity(rs.getInt("capacity"));
                apartment.setName(rs.getString("name"));
                apartment.setPrice(rs.getDouble("price"));
                apartment.setOwnerId(rs.getLong("owner_id"));
                apartment.setDayMin(rs.getInt("day_min"));
                apartment.setDayMax(rs.getInt("day_max"));
                apartments.add(apartment);

            }

        }catch (Exception e){
            eLogger.error(e.getMessage());
        }finally {
            releaseConnect(conn,stmt,rs);
        }
        return apartments;
    }
}
