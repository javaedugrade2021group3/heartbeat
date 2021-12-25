package com.edugrade.heartbeat.Model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "store", schema = "sakila")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private byte storeId;
    @Basic
    @Column(name = "manager_staff_id")
    private byte managerStaffId;
    @Basic
    @Column(name = "address_id")
    private short addressId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public byte getStoreId() {
        return storeId;
    }

    public void setStoreId(byte storeId) {
        this.storeId = storeId;
    }

    public byte getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(byte managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
