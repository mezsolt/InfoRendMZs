package model;

import java.util.Date;

/**
 * Created by mezsolt on 2018.12.03..
 */

public class Rent {

    private Long id;
    private Long userId;
    private String userName;
    private Long vehicleId;

    private Date startDate;
    private Date endDate;

    private int kmUsed;
    private double dayFee;
    private double kmFee;
    private double otherFee;
    private double totalFee;
    private boolean paid;

    public Rent() {

    }

    public Rent(Long id, Long userId, String userName, Long vehicleId, Date startDate, Date endDate, boolean durationExtendable, int extendedHours, int kmUsed, double dayFee, double kmFee, double otherFee, double totalFee, boolean paid) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.kmUsed = kmUsed;
        this.dayFee = dayFee;
        this.kmFee = kmFee;
        this.otherFee = otherFee;
        this.totalFee = totalFee;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getKmUsed() {
        return kmUsed;
    }

    public void setKmUsed(int kmUsed) {
        this.kmUsed = kmUsed;
    }

    public double getDayFee() {
        return dayFee;
    }

    public void setDayFee(double dayFee) {
        this.dayFee = dayFee;
    }

    public double getKmFee() {
        return kmFee;
    }

    public void setKmFee(double kmFee) {
        this.kmFee = kmFee;
    }

    public double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(double otherFee) {
        this.otherFee = otherFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", vehicleId=" + vehicleId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", kmUsed=" + kmUsed +
                ", dayFee=" + dayFee +
                ", kmFee=" + kmFee +
                ", otherFee=" + otherFee +
                ", totalFee=" + totalFee +
                ", paid=" + paid +
                '}';
    }
}