package com.edugrade.heartbeat.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "sakila")
public class AddressEntity {
    private short addressId;
    private String address;
    private String address2;
    private String district;
    private short cityId;
    private String postalCode;
    private String phone;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "address_id")
    public short getAddressId() { return addressId; }

    public void setAddressId(short addressId){ this.addressId = addressId; }

    @Basic
    @Column(name = "address")
    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Basic
    @Column(name = "address2")
    public String getAddress2() { return address2; }

    public void setAddress2(String address2) { this.address2 = address2; }

    @Basic
    @Column(name = "district")
    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

    @Basic
    @Column(name = "city_Id")
    public short getCityId() { return cityId; }

    public void setCityId(short cityId) { this.cityId = cityId; }

    @Basic
    @Column(name = "postal_Code")
    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    @Basic
    @Column(name = "phone")
    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() { return lastUpdate; }

    public void setLastUpdate(Timestamp lastUpdate) { this.lastUpdate = lastUpdate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return addressId == that.addressId &&
                Objects.equals(address, that.address) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(district, that.district) &&
                cityId == that.cityId &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, address, address2, district, cityId, postalCode, phone, lastUpdate);
    }


}
