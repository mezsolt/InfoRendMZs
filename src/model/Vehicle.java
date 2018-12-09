package model;

import java.util.Date;

/**
 * Created by mezsolt on 2018.12.03..
 */

public class Vehicle {
    private Long id;

    private VehicleType vehicleType;
    private String manufacturer;
    private String type;
    private int yearOfManufacture;
    private Date purchaseDate;

    private double vehicleDayFee;
    private double vehicleKmFee;
    private VehicleStatusType vehicleStatus;

    private String plateNumber;
    private String vehicleIdentificationNumber;

    public Vehicle(){

    }

    public Vehicle(Long id, VehicleType vehicleType, String manufacturer, String type, int yearOfManufacture, Date purchaseDate, double vehicleDayFee, double vehicleKmFee, VehicleStatusType vehicleStatus, String plateNumber, String vehicleIdentificationNumber) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.manufacturer = manufacturer;
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
        this.purchaseDate = purchaseDate;
        this.vehicleDayFee = vehicleDayFee;
        this.vehicleKmFee = vehicleKmFee;
        this.vehicleStatus = vehicleStatus;
        this.plateNumber = plateNumber;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getVehicleKmFee() {
        return vehicleKmFee;
    }

    public void setVehicleKmFee(double vehicleKmFee) {
        this.vehicleKmFee = vehicleKmFee;
    }

    public VehicleStatusType getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatusType vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }


    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getVehicleDayFee() {
        return vehicleDayFee;
    }

    public void setVehicleDayFee(double vehicleDayFee) {
        this.vehicleDayFee = vehicleDayFee;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (yearOfManufacture != vehicle.yearOfManufacture) return false;
        if (Double.compare(vehicle.vehicleDayFee, vehicleDayFee) != 0) return false;
        if (Double.compare(vehicle.vehicleKmFee, vehicleKmFee) != 0) return false;
        if (id != null ? !id.equals(vehicle.id) : vehicle.id != null) return false;
        if (vehicleType != vehicle.vehicleType) return false;
        if (manufacturer != null ? !manufacturer.equals(vehicle.manufacturer) : vehicle.manufacturer != null)
            return false;
        if (type != null ? !type.equals(vehicle.type) : vehicle.type != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(vehicle.purchaseDate) : vehicle.purchaseDate != null)
            return false;
        if (vehicleStatus != vehicle.vehicleStatus) return false;
        if (plateNumber != null ? !plateNumber.equals(vehicle.plateNumber) : vehicle.plateNumber != null) return false;
        return vehicleIdentificationNumber != null ? vehicleIdentificationNumber.equals(vehicle.vehicleIdentificationNumber) : vehicle.vehicleIdentificationNumber == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (vehicleType != null ? vehicleType.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + yearOfManufacture;
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        temp = Double.doubleToLongBits(vehicleDayFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vehicleKmFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (vehicleStatus != null ? vehicleStatus.hashCode() : 0);
        result = 31 * result + (plateNumber != null ? plateNumber.hashCode() : 0);
        result = 31 * result + (vehicleIdentificationNumber != null ? vehicleIdentificationNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleType=" + vehicleType +
                ", manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", purchaseDate=" + purchaseDate +
                ", vehicleDayFee=" + vehicleDayFee +
                ", vehicleKmFee=" + vehicleKmFee +
                ", vehicleStatus=" + vehicleStatus +
                ", plateNumber='" + plateNumber + '\'' +
                ", vehicleIdentificationNumber='" + vehicleIdentificationNumber + '\'' +
                '}';
    }
}