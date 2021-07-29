package hungnd.booking_system.adapter;

import hungnd.booking_system.entity.Apartment;
import hungnd.booking_system.model.response.ApartmentResponse;
import org.springframework.stereotype.Component;

@Component("apartmentAdapter")
public class ApartmentAdapter extends AbstractAdapter implements EntityAdapter<Apartment, ApartmentResponse> {
    @Override
    public ApartmentResponse transform(Apartment entity) {
        ApartmentResponse apartmentResponse = new ApartmentResponse();
        apartmentResponse.setApartmentArea(entity.getApartmentArea());
        apartmentResponse.setApartmentAddress(entity.getApartmentAddress());
        apartmentResponse.setApartmentName(entity.getApartmentName());
        apartmentResponse.setApartmentPrice(entity.getApartmentPrice());
        apartmentResponse.setApartmentCapacity(entity.getApartmentCapacity());
        apartmentResponse.setDayMax(entity.getDayMax());
        apartmentResponse.setDayMin(entity.getDayMin());
        apartmentResponse.setOwnerId(entity.getUserId());
        return apartmentResponse;
    }
}
