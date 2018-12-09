package dao;

import model.User;

import java.util.Collection;

/**
 * Created by mezsolt on 2018.12.03..
 */

public interface UserManagementDao {
    void createUser(String userName,String address,String phoneNumber,String userType,String drivingLicenseNumber,String billingAddress);
    void getUserById(Long id) throws Exception;
    void deleteUser(Long id);
    void clear();
}