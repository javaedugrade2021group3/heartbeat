package com.edugrade.heartbeat.Model;

import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Year;
import java.util.Objects;

    @Entity
    @Table(name = "film", schema = "sakila")
    public class FilmEntity implements Serializable {



        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "filmId")
        private byte filmId;
        @Basic
        @Column(name = "title")
        private String title;
        @Basic
        @Column(name = "description")
        private String description;
        @Basic
        @Column(name = "release_year")
        private Year releaseYear;
        @Basic
        @Column(name = "rental_duration")
        private byte rentalDuration;
        @Basic
        @Column(name = "rental_rate")
        private double rentalRate;
        @Basic
        @Column(name = "length")
        private int length;
        @Basic
        @Column(name = "replacement_cost")
        private double replacementCost;

        // Rating, vilken datatyp?
        @Basic
        @Column(name = "rating")
        private Set rating;


        @Basic
        @Column(name = "special_features")
        private Set specialFeatures;
        @Basic
        @Column(name = "last_update")
        private Timestamp lastUpdate;



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.edugrade.heartbeat.Model.FilmEntity that = (com.edugrade.heartbeat.Model.FilmEntity) o;
            return filmId == that.filmId && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(releaseYear, that.releaseYear) && Objects.equals(rentalDuration, that.rentalDuration)
            && Objects.equals(rentalRate, that.rentalRate)&& Objects.equals(length, that.length) && Objects.equals(replacementCost, that.replacementCost)
            && Objects.equals(rating, that.rating) && Objects.equals(specialFeatures,that.specialFeatures) && Objects.equals(lastUpdate, that.lastUpdate);

        }

        @Override
        public int hashCode() {
            return Objects.hash(filmId, title, description, releaseYear, rentalDuration, rentalRate,
            length, replacementCost, rating, specialFeatures, lastUpdate);
        }


        public int getFilmId() {
            return filmId;
        }

        public void setFilmId(byte filmId) {
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

        public Year getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(Year releaseYear) {
            this.releaseYear = releaseYear;
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

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public double getReplacementCost() {
            return replacementCost;
        }

        public void setReplacementCost( double replacementCost) {
            this.replacementCost = replacementCost;
        }

        public Set getRating() {
            return rating;
        }

        public void setRating(Set rating) {
            this.rating = rating;
        }

        public Set getSpecialFeatures() {
            return specialFeatures;
        }

        public void setSpecialFeatures(Set specialFeatures) {
            this.specialFeatures = specialFeatures;
        }

        public Timestamp getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(Timestamp lastUpdate) {
            this.lastUpdate = lastUpdate;
        }
    }



