package com.edugrade.heartbeat.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

    @Entity
    @Table(name = "film", schema = "sakila")
    public class FilmEntity implements Serializable {



        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "filmId")
        private int id;
        @Basic
        @Column(name = "firstName")
        private String firstName;
        @Basic
        @Column(name = "lastName")
        private String lastName;
        @Basic
        @Column(name = "address")
        private String address;
        @Basic
        @Column(name = "phoneNumber")
        private String phoneNumber;

        public int getId() {
            return id;
        }

        public void setId(int customerId) {
            this.id = customerId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.edugrade.heartbeat.Model.FilmEntity that = (com.edugrade.heartbeat.Model.FilmEntity) o;
            return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstName, lastName, address, phoneNumber);
        }
    }


