package com.edugrade.heartbeat.Model;

import javax.persistence.*;

@Entity
@Table(name = "staff", schema = "sakila")
public class StaffAddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id")
    private short staffId;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    public short getStaffId() {
        return staffId;
    }

    public void setStaffId(short staffId) {
        this.staffId = staffId;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
