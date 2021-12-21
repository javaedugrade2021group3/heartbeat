package com.edugrade.heartbeat.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rental", schema = "sakila")
public class RentalEntity   {

    private Short rentalId;
    private Timestamp rentalDate;
    private Short inventoryId;
    private Short customerId;
    private Timestamp returnDate;
    private Short staffId;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "rental_id")
    public Short getRentalId() {return rentalId;}
    public void setRentalId(Short rentalId) {this.rentalId = rentalId;}

    @Basic
    @Column(name = "rental_date")
    public Timestamp getRentalDate() {return rentalDate;}
    public void setRentalDate(Timestamp rentalDate) {this.rentalDate = rentalDate;}

    @Basic
    @Column(name = "inventory_id")
    public Short getInventoryId (){return inventoryId;}
    public void setInventoryId(Short inventoryId) {this.inventoryId = inventoryId;}

    @Basic
    @Column(name = "customer_id")
    public Short getCustomerId (){return customerId;}
    public void setCustomerId(Short customerId) {this.customerId = customerId;}

    @Basic
    @Column(name = "return_Date")
    public Timestamp  getReturnDate() {return returnDate;}
    public void setReturnDate(Timestamp returnDate) {this.returnDate = returnDate;}

    @Basic
    @Column(name = "staff_id")
    public Short getStaffId() {return staffId;}
    public void setStaffId(Short staffId) {this.staffId = staffId;}

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {return lastUpdate;}
    public void setLastUpdate(Timestamp lastUpdate) {this.lastUpdate = lastUpdate;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalEntity that = (RentalEntity) o;
        return rentalId == that.rentalId && Objects.equals(rentalDate, that.rentalDate)
                && Objects.equals(inventoryId, that.inventoryId)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(returnDate, that.returnDate)
                && Objects.equals(staffId, that.staffId)
                && Objects.equals(lastUpdate, that.lastUpdate);}

    @Override
    public int hashCode() {
        return Objects.hash(rentalId,rentalDate,inventoryId,customerId,returnDate,staffId,lastUpdate);
    }

}