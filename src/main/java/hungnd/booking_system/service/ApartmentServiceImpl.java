package hungnd.booking_system.service;

import hungnd.booking_system.adapter.ApartmentAdapter;
import hungnd.booking_system.dao.ApartmentDao;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.model.response.ApartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ApartmentServiceImpl extends AbstractService implements ApartmentService{
    @Autowired
    private ApartmentDao apartmentDao;

    @Autowired
    @Qualifier("apartmentAdapter")
    private ApartmentAdapter apartmentAdapter;

    @Override
    public Object getApartmentById(String apartmentId) throws Exception {
        ApartmentResponse apartmentResponse = apartmentAdapter.transform(apartmentDao.getApartmentById(apartmentId));
        return apartmentResponse;
    }

    @Override
    public Object postApartment(ApartmentResquest apartmentResquest) throws Exception {
        ApartmentResponse apartmentResponse = apartmentAdapter.transform(apartmentDao.postApartment(apartmentResquest));
        return apartmentResponse;
    }

    @Override
    public Object updateApartment(ApartmentResquest apartmentResquest) throws Exception {
        ApartmentResponse apartmentResponse = apartmentAdapter.transform(apartmentDao.updateApartment(apartmentResquest));
        return apartmentResponse;
    }
}
