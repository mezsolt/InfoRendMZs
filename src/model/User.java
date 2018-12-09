package model;

/**
 * Created by mezsolt on 2018.12.03..
 */

public class User {
    private Long id;
    private String userName;
    private String address;
    private String phoneNumber;
    private UserType userType;
    private String drivingLicenceNumber;
    private String companyName;

    public User() {
    }

    public User(Long id, String userName, String address, String phoneNumber, UserType userType, int yearOfBirth, String drivingLicenceNumber, String companyName, Long representativeId) {
        this.id = id;
        this.userName = userName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.drivingLicenceNumber = drivingLicenceNumber;
        this.companyName = companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (userType != user.userType) return false;
        if (drivingLicenceNumber != null ? !drivingLicenceNumber.equals(user.drivingLicenceNumber) : user.drivingLicenceNumber != null)
            return false;
        return companyName != null ? companyName.equals(user.companyName) : user.companyName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (drivingLicenceNumber != null ? drivingLicenceNumber.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userType=" + userType +
                ", drivingLicenceNumber='" + drivingLicenceNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}