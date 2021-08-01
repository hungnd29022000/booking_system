package hungnd.booking_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private Long apartmentId;
    @Column(name = "owner_id")
    private Long ownerId;
    @Column(name = "name")
    private String name;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "price")
    private Double price;
    @Column(name = "address")
    private String address;
    @Column(name = "area")
    private Double area;
    @Column(name = "day_min")
    private int dayMin;
    @Column(name = "day_max")
    private int dayMax;

    public Apartment() {
    }

    public Apartment(Long ownerId, String name, int capacity, Double price, String address, Double area, int dayMin, int dayMax) {
        this.ownerId = ownerId;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.address = address;
        this.area = area;
        this.dayMin = dayMin;
        this.dayMax = dayMax;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
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
