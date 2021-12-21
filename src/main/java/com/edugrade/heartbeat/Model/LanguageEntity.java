package com.edugrade.heartbeat.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "language", schema = "sakila")
public class LanguageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private short languageId;
    private String name;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "language_id")
    public short getLanguageId() {return languageId;}
    public void setLanguageId(short languageId) {this.languageId = languageId;}

    @Basic
    @Column(name = "name")
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {return lastUpdate;}
    public void setLastUpdate(Timestamp lastUpdate) {this.lastUpdate = lastUpdate;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageEntity that = (LanguageEntity) o;
        return languageId == that.languageId && Objects.equals(name, that.name)
                && Objects.equals(lastUpdate, that.lastUpdate);}

    @Override
    public int hashCode() {
        return Objects.hash(languageId,name,lastUpdate);
    }

}
