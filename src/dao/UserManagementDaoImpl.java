package dao;

import model.User;
import model.UserType;
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

@ManagedBean(name = "user")
public class UserManagementDaoImpl implements UserManagementDao{
    private File database = new File("C:\\Server\\users.json");

    private Map<String,String> userTypes;

    private List<User> users;

    public UserManagementDaoImpl()
    {
        users = readDatabase();
        userTypes  = new HashMap<String, String>();
        userTypes.put("Customer", "Customer");
        userTypes.put("Company", "Company");

    }

    @PostConstruct
    void initialiseSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public Map<String, String> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(Map<String, String> userTypes) {
        this.userTypes = userTypes;
    }

    @Override
    public void getUserById(Long id) throws Exception {
        System.out.println("asdasdasdasd" + id);
        List<User> usersList = readDatabase();
        this.users.clear();
        for (User u : usersList) {
            if (u.getId().equals(id)) {
                this.users.add(u);
            }
        }
        System.out.println(users);
    }



    @Override
    public void deleteUser(Long id) {
        List<User> users = readDatabase();

        User userToRemove = new User();

        for (User user : users)
        {
            if (user.getId().equals(id))
            {
                userToRemove = user;
            }
        }

        users.remove(userToRemove);

        writeDatabase(users);
    }

    @Override
    public void clear() {
        writeDatabase(new ArrayList<User>());
    }

    private List<User> readDatabase()  {
        List<User> result = new ArrayList<User>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = new LinkedList<>(Arrays.asList(mapper.readValue(database, User[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void writeDatabase(List<User> users)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(database, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUser(String userName,String address,String phoneNumber,String userType,String drivingLicenseNumber,String billingAddress) {

        Long id = 1L;

        List<User> users = readDatabase();

        if(users.size() > 0) {
            id = users.get(users.size()-1).getId() + 1;
            /*for(int i=0;i<rents.size();i++) {
                System.out.println(rents.get(i).getId());
                if(rents.get(i).getId()>=id) {
                    id = rents.get(i).getId() + 1;
                }
            }*/
        }

            User user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setAddress(address);
            user.setPhoneNumber(phoneNumber);

            user.setDrivingLicenceNumber(drivingLicenseNumber);
            user.setCompanyName(billingAddress);

            if(userType.equals("Customer")) {
                user.setUserType(UserType.CUSTOMER);
            } else {
                user.setUserType(UserType.COMPANY);
            }

            clear();
            users.add(user);
            writeDatabase(users);

    }

}