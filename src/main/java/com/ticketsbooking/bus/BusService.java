package com.ticketsbooking.bus;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Setter(onMethod_ = @Autowired)
public class BusService {

    private BusRepository busRepository;

    @Transactional
    public void save(String brand, Integer placeAmount) {
        var bus = new Bus();
        bus.setBrand(brand);
        bus.setPlaceAmount(placeAmount);
        busRepository.save(bus);
    }
}
