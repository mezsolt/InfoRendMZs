package dao;

import model.*;
import org.codehaus.jackson.map.ObjectMapper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by mezsolt on 2018.12.03..
 */

@ManagedBean(name = "vehicle")
public class VehicleManagementDaoImpl implements VehicleManagementDao {
    private File database = new File("C:\\Server\\vehicles.json");

    private Map<String,String> vehicleTypes;
    private Map<String,String> vehicleStatusTypes;

    private List<Vehicle> vehicles;


    @PostConstruct
    void initialiseSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public VehicleManagementDaoImpl()
    {
        vehicles = readDatabase();
        vehicleTypes  = new HashMap<String, String>();
        vehicleTypes.put("Car", "Car");
        vehicleTypes.put("Ship", "Ship");

        vehicleStatusTypes  = new HashMap<String, String>();
        vehicleStatusTypes.put("FREE", "FREE");
        vehicleStatusTypes.put("RESERVED", "RESERVED");
        vehicleStatusTypes.put("NOT_AVAILABLE", "NOT_AVAILABLE");
    }

    public Map<String, String> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(Map<String, String> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public Map<String, String> getVehicleStatusTypes() {
        return vehicleStatusTypes;
    }

    public void setVehicleStatusTypes(Map<String, String> vehicleStatusTypes) {
        this.vehicleStatusTypes = vehicleStatusTypes;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void readVehiclesList() {
        this.vehicles = readDatabase();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public void deleteVehicle(Long id){
        List<Vehicle> vehicles = readDatabase();

        Vehicle vehicleToRemove = new Vehicle();

        for(Vehicle v : vehicles) {
            if(v.getId().equals(id)) {
                vehicleToRemove = v;
            }
        }

        vehicles.remove(vehicleToRemove);
        writeDatabase(vehicles);
    }

    @Override
    public void clear() {
        writeDatabase(new ArrayList<Vehicle>());
    }

    @Override
    public void getVehiclesByPlatenumber(String plateNumber) {
        List<Vehicle> vehiclesList = readDatabase();
        this.vehicles.clear();
        for (Vehicle v : vehiclesList)
        {
            if (v.getPlateNumber().equals(plateNumber))
            {
                this.vehicles.add(v);
            }
        }

    }

    @Override
    public void getVehiclesByStatus(String status) {
        List<Vehicle> vehiclesList = readDatabase();
        this.vehicles.clear();
        for (Vehicle v : vehiclesList)
        {
            if (v.getVehicleStatus().toString().equals(status))
            {
                this.vehicles.add(v);
            }
        }
    }

    @Override
    public void getVehiclesByType(String type) {
        List<Vehicle> vehiclesList = readDatabase();
        List<Vehicle> newVehicleList = new ArrayList<>();

        for (Vehicle v : vehiclesList)
        {
            if (v.getType().equals(type))
            {
                newVehicleList.add(v);
            }
        }

        this.vehicles = newVehicleList;
    }

    private List<Vehicle> readDatabase(){
        List<Vehicle> result = new ArrayList<Vehicle>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = new LinkedList<>(Arrays.asList(mapper.readValue(database, Vehicle[].class)));
        } catch (IOException e) {
            System.out.println(database.getAbsolutePath());
            e.printStackTrace();
        }
        List<Vehicle> result2 = new ArrayList<Vehicle>();
        for(Vehicle v : result) {
            result2.add(v);
        }
        return result2;
    }

    private void writeDatabase(List<Vehicle> vehicles)
    {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(database, vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createVehicle(String vehicleType,String manufacturer,String type,String yearOfManufacture,Date purchaseDate,String vehicleDayFee,String vehicleKmFee,String vehicleStatus,String plateNumber,String vehicleIdentificationNumber) {

        Long id = 1L;

        List<Vehicle> vehicles = readDatabase();

        if(vehicles.size() > 0) {
            id = vehicles.get(vehicles.size()-1).getId() + 1;
            /*for(int i=0;i<rents.size();i++) {
                System.out.println(rents.get(i).getId());
                if(rents.get(i).getId()>=id) {
                    id = rents.get(i).getId() + 1;
                }
           }*/
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setManufacturer(manufacturer);
        vehicle.setType(type);
        vehicle.setYearOfManufacture(Integer.parseInt(yearOfManufacture));
        vehicle.setPurchaseDate(purchaseDate);
        vehicle.setVehicleKmFee(Double.parseDouble(vehicleKmFee));
        vehicle.setVehicleDayFee(Double.parseDouble(vehicleDayFee));
        vehicle.setPlateNumber(plateNumber);
        vehicle.setVehicleIdentificationNumber(vehicleIdentificationNumber);

        if(vehicleStatus.equals("FREE")) {
            vehicle.setVehicleStatus(VehicleStatusType.FREE);
        } else if(vehicleStatus.equals("RESERVED")){
            vehicle.setVehicleStatus(VehicleStatusType.RESERVED);
        } else {
            vehicle.setVehicleStatus(VehicleStatusType.NOT_AVAILABLE);
        }

        if(vehicleType.equals("Car")) {
            vehicle.setVehicleType(VehicleType.CAR);
        } else {
            vehicle.setVehicleType(VehicleType.SHIP);
        }

        clear();
        vehicles.add(vehicle);
        writeDatabase(vehicles);
    }

    @Override
    public void vehicleStatusChanger(Long vehicleID,String vehicleStatus) {
        List<Vehicle> vehicles = readDatabase();

        for(Vehicle v: vehicles) {
            if(v.getId().equals(vehicleID)) {
                if(vehicleStatus.equals("FREE")) {
                    v.setVehicleStatus(VehicleStatusType.FREE);
                } else if(vehicleStatus.equals("RESERVED")){
                    v.setVehicleStatus(VehicleStatusType.RESERVED);
                } else if(vehicleStatus.equals("NOT_AVAILABLE")){
                    v.setVehicleStatus(VehicleStatusType.NOT_AVAILABLE);
                }
            }
        }
        writeDatabase(vehicles);
    }


}