package com.edugrade.heartbeat.Model;

import javax.persistence.*;

@Entity
@Table(name = "customer", schema = "sakila")
public class CustomerAddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private short customerId;
    @ManyToOne()
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
