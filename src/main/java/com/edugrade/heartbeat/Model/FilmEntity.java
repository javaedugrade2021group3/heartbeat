package com.edugrade.heartbeat.Model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "film", schema = "sakila")

public class FilmEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id")
    private short filmId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "release_year")
    private String releaseYear;
    @Basic
    @Column(name = "language_id")
    private byte languageId;
    @Basic
    @Column(name = "original_language_id")
    private Byte originalLanguageId;
    @Basic
    @Column(name = "rental_duration")
    private byte rentalDuration;
    @Basic
    @Column(name = "rental_rate")
    private double rentalRate;
    @Basic
    @Column(name = "length")
    private Short length;
    @Basic
    @Column(name = "replacement_cost")
    private double replacementCost;

    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;
    @ManyToMany(mappedBy = "films", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<ActorEntity>actors = new ArrayList<ActorEntity>();
    public void setActors(List<ActorEntity> actors) {
        this.actors = actors;
    }

    public List<ActorEntity> getActors() {
        return actors;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public byte getLanguageId() {
        return languageId;
    }

    public void setLanguageId(byte languageId) {
        this.languageId = languageId;
    }

    public Byte getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Byte originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }


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
        FilmEntity that = (FilmEntity) o;
        return filmId == that.filmId && languageId == that.languageId && rentalDuration == that.rentalDuration && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(releaseYear, that.releaseYear) && Objects.equals(originalLanguageId, that.originalLanguageId) && Objects.equals(rentalRate, that.rentalRate) && Objects.equals(length, that.length) && Objects.equals(replacementCost, that.replacementCost) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate, length, replacementCost,lastUpdate);
    }
}
