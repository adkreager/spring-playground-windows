package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Flight {

    private Date departs;
    private Ticket[] tickets;
    @JsonProperty("Departs")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm")
    public Date getDeparts() {
        return departs;
    }
    public void setDeparts(Date departs) {
        this.departs = departs;
    }
    @JsonProperty("Tickets")
    public Ticket[] getTickets() {
        return tickets;
    }
    @JsonProperty("tickets")
    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }
    static class Ticket {
        private Person passenger;
        private int price;
        @JsonProperty("Person")
        public Person getPassenger() {
            return passenger;
        }
        @JsonProperty("passenger")
        public void setPassenger(Person passenger) {
            this.passenger = passenger;
        }
        @JsonProperty("Price")
        public int getPrice() {
            return price;
        }
        @JsonProperty("price")
        public void setPrice(int price) {
            this.price = price;
        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        static class Person {
            private String firstName;
            private String lastName;
            @JsonProperty("FirstName")
            public String getFirstName() {
                return firstName;
            }
            @JsonProperty("firstName")
            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }
            @JsonProperty("LastName")
            public String getLastName() {
                return lastName;
            }
            @JsonProperty("lastName")
            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
        }
    }
}