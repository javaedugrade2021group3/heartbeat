package com.edugrade.heartbeat.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "inventory", schema = "sakila")
public class InventoryEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventory_id")
    private short inventoryId;
    @Basic
    @Column(name = "film_id")
    private short filmId;
    @Basic
    @Column(name = "store_id")
    private byte storeId;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public short getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(short inventoryId) {
        this.inventoryId = inventoryId;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public byte getStoreId() {
        return storeId;
    }

    public void setStoreId(byte storeId) {
        this.storeId = storeId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return filmId == that.filmId && storeId == that.storeId && Objects.equals(inventoryId, that.inventoryId) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, filmId, storeId, lastUpdate);
    }
*/


}


