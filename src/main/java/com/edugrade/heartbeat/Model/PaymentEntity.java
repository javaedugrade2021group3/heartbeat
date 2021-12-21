package com.edugrade.heartbeat.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "sakila")
public class PaymentEntity   {

    private Short paymentId;
    private Short customerId;
    private Short staffId;
    private Short rentalId;
    private double amount;
    private Timestamp paymentDate;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "payment_id")
    public Short getPaymentId() {return paymentId;}
    public void setPaymentId(Short paymentId) {this.paymentId = paymentId;}

    @Basic
    @Column(name = "customer_id")
    public Short getCustomerId() {return customerId;}
    public void setCustomerId(Short customerId) {this.customerId = customerId;}

    @Basic
    @Column(name = "staff_id")
    public Short getStaffId() {return staffId;}
    public void setStaffId(Short staffId) {this.staffId = staffId;}

    @Basic
    @Column(name = "rental_id")
    public Short getRentalId() {return rentalId;}
    public void setRentalId(Short rentalId) {this.rentalId = rentalId;}

    @Basic
    @Column(name = "amount")
    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    @Basic
    @Column(name = "payment_date")
    public Timestamp getPaymentDate() {return paymentDate;}
    public void setPaymentDate(Timestamp paymentDate) {this.paymentDate = paymentDate;}

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {return lastUpdate;}
    public void setLastUpdate(Timestamp lastUpdate) {this.lastUpdate = lastUpdate;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return paymentId == that.paymentId && Objects.equals(customerId, that.customerId)
                && Objects.equals(staffId, that.staffId)&& Objects.equals(rentalId, that.rentalId)
                && Objects.equals(amount, that.amount)&& Objects.equals(paymentDate, that.paymentDate)
                && Objects.equals(lastUpdate, that.lastUpdate);}

    @Override
    public int hashCode() {
        return Objects.hash(paymentId,customerId,staffId,rentalId,amount,paymentDate,lastUpdate);
    }

}
