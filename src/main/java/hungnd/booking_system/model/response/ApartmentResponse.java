package hungnd.booking_system.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApartmentResponse {
    @Expose
    @SerializedName("apartment_name")
    private String apartmentName;
    @Expose
    @SerializedName("owner_id")
    private int ownerId;
    @Expose
    @SerializedName("apartment_capacity")
    private int apartmentCapacity;
    @Expose
    @SerializedName("apartment_price")
    private Double apartmentPrice;
    @Expose
    @SerializedName("apartment_address")
    private String apartmentAddress;
    @Expose
    @SerializedName("apartment_area")
    private Double apartmentArea;
    @Expose
    @SerializedName("day_min")
    private int dayMin;
    @Expose
    @SerializedName("day_max")
    private int dayMax;

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getApartmentCapacity() {
        return apartmentCapacity;
    }

    public void setApartmentCapacity(int apartmentCapacity) {
        this.apartmentCapacity = apartmentCapacity;
    }

    public Double getApartmentPrice() {
        return apartmentPrice;
    }

    public void setApartmentPrice(Double apartmentPrice) {
        this.apartmentPrice = apartmentPrice;
    }

    public String getApartmentAddress() {
        return apartmentAddress;
    }

    public void setApartmentAddress(String apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }

    public Double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(Double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public int getDayMin() {
        return dayMin;
    }

    public void setDayMin(int dayMin) {
        this.dayMin = dayMin;
    }

    public int getDayMax() {
        return dayMax;
    }

    public void setDayMax(int dayMax) {
        this.dayMax = dayMax;
    }
}
