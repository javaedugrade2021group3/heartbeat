package com.edugrade.heartbeat.Model;

import javax.persistence.*;

@Entity
@Table(name = "store", schema = "sakila")
public class StoreAddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private short storeId;
    @ManyToOne()
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    public short getStoreId() {
        return storeId;
    }

    public void setStoreId(short storeId) {
        this.storeId = storeId;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
