package dao;

import model.Vehicle;

import java.util.Collection;
import java.util.Date;

/**
 * Created by mezsolt on 2018.12.03..
 */

public interface VehicleManagementDao {
    void createVehicle(String vehicleType, String manufacturer, String type, String yearOfManufacture, Date purchaseDate, String vehicleDayFee, String vehicleKmFee, String vehicleStatus, String plateNumber, String vehicleIdentificationNumber);
    Collection<Vehicle> getVehicles();
    void deleteVehicle(Long id);
    void clear();
    void getVehiclesByPlatenumber(String plateNumber);
    void getVehiclesByStatus(String status);
    void getVehiclesByType(String type);
    void vehicleStatusChanger(Long vehicleID,String vehicleStatus);

    }