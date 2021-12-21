package com.edugrade.heartbeat.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table (name ="city", schema = "sakila")
public class CityEntity {
 @GeneratedValue(strategy = GenerationType.IDENTITY)

    private short cityId;
    private String city;
    private Short countryId;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "city_Id")
    public short getCityId() {return cityId;}
    public void setCityId(short cityId) {this.cityId = cityId;}

    @Basic
    @Column(name = "city")
    public String getCity;
    public void setCity(String city) {this.city = city;}

    @Basic
    @Column(name = "country_Id")
    public Short getCountryId() {return countryId;}
    public void setCountryId(Short countryId) {this.countryId= countryId;}

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return cityId == that.cityId && Objects.equals(city, that.city)
                && Objects.equals(countryId, that.countryId)
                && Objects.equals(lastUpdate, that.lastUpdate);
    }
        @Override
        public int hashCode() {return Objects.hash(cityId,city,countryId,lastUpdate);
        }
}
