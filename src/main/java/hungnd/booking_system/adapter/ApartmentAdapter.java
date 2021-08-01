package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.model.request.ApartmentResquest;
import hungnd.booking_system.model.response.ApartmentResponse;
import org.springframework.stereotype.Component;

@Component("apartmentAdapter")
public class ApartmentAdapter extends AbstractAdapter implements EntityAdapter<Apartment, ApartmentResponse> {
    @Override
    public ApartmentResponse transform(Apartment entity) {
        ApartmentResponse apartmentResponse = new ApartmentResponse();
        apartmentResponse.setApartmentArea(entity.getArea());
        apartmentResponse.setApartmentAddress(entity.getAddress());
        apartmentResponse.setApartmentName(entity.getName());
        apartmentResponse.setApartmentPrice(entity.getPrice());
        apartmentResponse.setApartmentCapacity(entity.getCapacity());
        apartmentResponse.setDayMax(entity.getDayMax());
        apartmentResponse.setDayMin(entity.getDayMin());
        apartmentResponse.setOwnerId(entity.getOwnerId());
        return apartmentResponse;
    }

    public Apartment transform(ApartmentResquest apartmentResquest){
        Apartment apartment = new Apartment(
                apartmentResquest.getOwnerId(),
                apartmentResquest.getApartmentName(),
                apartmentResquest.getApartmentCapacity(),
                apartmentResquest.getApartmentPrice(),
                apartmentResquest.getApartmentAddress(),
                apartmentResquest.getApartmentArea(),
                apartmentResquest.getDayMin(),
                apartmentResquest.getDayMax()
        );

        if(apartmentResquest.getApartmentId() != null){
            apartment.setApartmentId(apartment.getApartmentId());
        }
        return apartment;

    }
}
