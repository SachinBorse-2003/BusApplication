package com.example.bus;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BusTest {
    Bus bus = new Bus(30);
    @Test
    void shouldSetDefaultValues(){

        assertEquals(30,bus.capacity);
        assertEquals(30,bus.availableSeats);
    }
    @Test
    void shouldBoardPassengers() throws Exception{
        assertTrue(bus.boardPassenger(1,"Rahul",20));
        assertEquals(29,bus.availableSeats);
    }
    @Test
    void shouldThrowExceptionWhenBeyondCapacity(){
        assertThrows(OutOfCapacityException.class,()->{
            bus.boardPassenger(32,"Jhon",50);
        });
    }
    @Test
    void shouldDisplayPassengerListAndTotalFare() throws Exception{
        bus.boardPassenger(1,"Rahul",20);
        bus.boardPassenger(2,"Sachin",20);
        List<String> expected = List.of("Rahul", "Sachin");

        assertEquals(expected,bus.getPassengerList());
        assertEquals(40.0,bus.getTotalFare());
    }
}
