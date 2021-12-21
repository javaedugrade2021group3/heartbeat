package com.edugrade.heartbeat.Model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "store", schema = "sakila")
public class StoreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte storeId;
    private byte managerStaffId;
    private short addressId;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "store_id")
    public byte getStoreId() { return storeId; }

    public void setStoreId(byte storeId){ this.storeId = storeId; }

    @Basic
    @Column(name = "manager_staff_id")
    public byte getManagerStaffId() { return managerStaffId; }

    public void setManagerStaffId(byte managerStaffId) { this.managerStaffId = managerStaffId; }

    @Basic
    @Column(name = "address_id")
    public short getAddressId() { return addressId; }

    public void setAddressId(short addressId) { this.addressId = addressId; }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() { return lastUpdate; }

    public void setLastUpdate(Timestamp lastUpdate) { this.lastUpdate = lastUpdate; }

}
