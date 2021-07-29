package hungnd.booking_system.model.request;

public class ApartmentResquest {
    private int apartmentId;
    private int userId;
    private String apartmentName;
    private int apartmentCapacity;
    private Double apartmentPrice;
    private String apartmentAddress;
    private Double apartmentArea;
    private int dayMin;
    private int dayMax;

    public ApartmentResquest() {
    }

    public ApartmentResquest(int userId, String apartmentName, int apartmentCapacity, Double apartmentPrice, String apartmentAddress, Double apartmentArea, int dayMin, int dayMax) {
        this.userId = userId;
        this.apartmentName = apartmentName;
        this.apartmentCapacity = apartmentCapacity;
        this.apartmentPrice = apartmentPrice;
        this.apartmentAddress = apartmentAddress;
        this.apartmentArea = apartmentArea;
        this.dayMin = dayMin;
        this.dayMax = dayMax;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
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
