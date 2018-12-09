package dao;

import model.Rent;
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

@ManagedBean(name = "rent")
public class RentManagementDaoImpl implements RentManagementDao {
    private File database = new File("C:\\Server\\rents.json");

    private String title = "Vehicle Rental Webpage";

    private List<Rent> rents;

    public RentManagementDaoImpl()
    {
        rents = readDatabase();

    }

    @PostConstruct
    void initialiseSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void getRentsByUserId(Long id) {
        List<Rent> rentsList = readDatabase();
        this.rents.clear();
        for (Rent r : rentsList) {
            if (r.getUserId().equals(id)) {
                this.rents.add(r);
            }
        }
    }

    @Override
    public void getRentsByVehicleId(Long id) {
        List<Rent> rentsList = readDatabase();
        this.rents.clear();
        for (Rent r : rentsList) {
            if (r.getVehicleId().equals(id)) {
                this.rents.add(r);
            }
        }
    }

    @Override
    public void deleteRent(Long id) {
        List<Rent> rents = readDatabase();

        Rent rentToRemove = new Rent();

        for (Rent rent : rents)
        {
            if (rent.getId().equals(id))
            {
                rentToRemove = rent;
            }
        }

        rents.remove(rentToRemove);

        writeDatabase(rents);
    }

    @Override
    public void clear() {
        writeDatabase(new ArrayList<Rent>());
    }

    private List<Rent> readDatabase(){
        List<Rent> result = new ArrayList<Rent>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = new LinkedList<>(Arrays.asList(mapper.readValue(database, Rent[].class)));
        } catch (IOException e) {
            System.out.println(database.getAbsolutePath());
            e.printStackTrace();
        }
        return result;
    }

    private void writeDatabase(List<Rent> rents)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(database, rents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createRent(Long userId,String userName,Long vehicleId,Date startDate,Date endDate,String kmUsed,String dayFee,String kmFee,String otherFee,String totalFee,boolean paid) {
        Rent r = new Rent();
        Long id = 1L;
        r.setUserId(userId);
        r.setUserName(userName);
        r.setVehicleId(vehicleId);
        r.setStartDate(startDate);
        r.setEndDate(endDate);
        r.setKmUsed(Integer.parseInt(kmUsed));
        r.setDayFee(Double.parseDouble(dayFee));
        r.setKmFee(Double.parseDouble(kmFee));
        r.setOtherFee(Double.parseDouble(otherFee));
        r.setTotalFee(Double.parseDouble(totalFee));
        r.setPaid(paid);
        System.out.println("\n\n\n\n\nelso print: " + r.toString() + "\n\n\n\n\n");
        List<Rent> rents = readDatabase();
        System.out.println(rents.toString());
        System.out.println("\n\n\n\n\nmasodik print: " + rents + "\n\n\n\n\n");


        if(rents.size() > 0) {
            id = rents.get(rents.size()-1).getId() + 1;
            /*for(int i=0;i<rents.size();i++) {
                System.out.println(rents.get(i).getId());
                if(rents.get(i).getId()>=id) {
                    id = rents.get(i).getId() + 1;
                }
            }*/
        }
        r.setId(id);
        rents.add(r);
        clear();
        writeDatabase(rents);

    }

    @Override
    public void rentPaid(Long rentID,boolean paid) {
        List<Rent> rents = readDatabase();

        for(Rent r: rents) {
            if(r.getId().equals(rentID)) {
                r.setPaid(paid);
            }
        }

        writeDatabase(rents);
    }

    @Override
    public void rentFeeCalculate(Long rentID,String kmUsed,String kmFee,String dayFee,String otherFee,String totalFee) {
        List<Rent> rents = readDatabase();

        for(Rent r: rents) {
            if(r.getId().equals(rentID)) {
                r.setKmUsed(Integer.parseInt(kmUsed));
                r.setKmFee(Double.parseDouble(kmFee));
                r.setDayFee(Double.parseDouble(dayFee));
                r.setOtherFee(Double.parseDouble(otherFee));
                r.setTotalFee(Double.parseDouble(totalFee));
            }
        }

        writeDatabase(rents);
    }
}
