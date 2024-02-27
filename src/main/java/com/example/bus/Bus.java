package com.example.bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bus {
    public int availableSeats;
    int capacity = 0;
    float totalFare =0;
    Map<Integer,String> passengers = new HashMap<>();
    Map<Integer,Float> fareMap = new HashMap<>();
    public Bus(int capacity) {
        this.capacity = capacity;

        availableSeats = capacity;
    }
    public boolean boardPassenger (int id, String name, float fare) throws OutOfCapacityException {
        if(id<=capacity){
            passengers.put(id,name);
            fareMap.put(id,fare);
            availableSeats = capacity-passengers.size();

            return true;
        }else {
            throw new OutOfCapacityException("No Seats Available");
        }
    }

    public List<String> getPassengerList() {
        return new ArrayList<>(passengers.values());

    }

    public double getTotalFare() {
        for (Float fare:fareMap.values()){
            totalFare+= fare;
        }
        return totalFare;
    }
}
