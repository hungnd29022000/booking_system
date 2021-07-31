package hungnd.booking_system.service;

import hungnd.booking_system.adapter.ApartmentAdapter;
import hungnd.booking_system.dao.repository.ApartmentRepo;
import hungnd.booking_system.entity.jpa.Apartment;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.model.response.ApartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl extends AbstractService implements ApartmentService{
    @Autowired
    private ApartmentRepo apartmentRepo;

    @Autowired
    @Qualifier("apartmentAdapter")
    private ApartmentAdapter apartmentAdapter;


    @Override
    public Object getApartmentById(Long apartmentId) throws Exception {
        Apartment apartment = apartmentRepo.findById(apartmentId).get();
        ApartmentResponse apartmentResponse = apartmentAdapter.transform(apartment);
        return apartmentResponse;
    }

    @Override
    public Object postApartment(ApartmentResquest apartmentResquest) throws Exception {
        Apartment apartment = apartmentRepo.save(apartmentAdapter.transform(apartmentResquest));

        ApartmentResponse apartmentResponse = apartmentAdapter.transform(apartment);
        return apartmentResponse;
    }

    @Override
    public Object findAll() throws Exception {
        return apartmentRepo.findAll().stream()
                .map(
                        apartment -> apartmentAdapter.transform(apartment)
                )
                .collect(Collectors.toList());
    }
}
