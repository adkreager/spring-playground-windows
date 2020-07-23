package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PagesController {

    @GetMapping("/flights/flight")
    public Flight getFlight() {
        Flight flight = new Flight();
        flight.setDeparts(new Date());
        Flight.Ticket[] tickets = new Flight.Ticket[1];
        Flight.Ticket.Person person = new Flight.Ticket.Person();
        person.setFirstName("Some name");
        person.setLastName("Some other name");
        tickets[0] = new Flight.Ticket();
        tickets[0].setPassenger(person);
        tickets[0].setPrice(200);
        flight.setTickets(tickets);
        return flight;
    }
    @GetMapping("/flights")
    public Flight[] getFlights() {
        Flight[] flights = new Flight[2];
        flights[0] = new Flight();
        flights[0].setDeparts(new Date());
        Flight.Ticket[] tickets1 = new Flight.Ticket[1];
        Flight.Ticket.Person person1 = new Flight.Ticket.Person();
        person1.setFirstName("Some name");
        person1.setLastName("Some other name");
        tickets1[0] = new Flight.Ticket();
        tickets1[0].setPassenger(person1);
        tickets1[0].setPrice(200);
        flights[0].setTickets(tickets1);
        flights[1] = new Flight();
        flights[1].setDeparts(new Date());
        Flight.Ticket[] tickets2 = new Flight.Ticket[1];
        Flight.Ticket.Person person2 = new Flight.Ticket.Person();
        person2.setLastName("Some other name");
        tickets2[0] = new Flight.Ticket();
        tickets2[0].setPassenger(person2);
        tickets2[0].setPrice(400);
        flights[1].setTickets(tickets2);
        return flights;
    }
    @PostMapping("flights/tickets/total")
    public Map<String, Integer> sumTicketsTotal(@RequestBody() Flight flight) {
        int total = 0;
        for (Flight.Ticket ticket : flight.getTickets()) {
            total += ticket.getPrice();
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("result", total);
        return result;
    }
}