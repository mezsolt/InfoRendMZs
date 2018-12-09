package dao;

import model.Rent;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by mezsolt on 2018.12.03..
 */

public interface RentManagementDao {
    void createRent(Long userId, String userName, Long vehicleId, Date startDate, Date endDate, String kmUsed, String dayFee, String kmFee, String otherFee, String totalFee, boolean paid);
    void getRentsByUserId(Long id);
    void getRentsByVehicleId(Long id);
    void deleteRent(Long id);
    void clear();
    void rentPaid(Long rentID,boolean paid);
    void rentFeeCalculate(Long rentID,String kmUsed,String kmFee,String dayFee,String otherFee,String totalFee);
}