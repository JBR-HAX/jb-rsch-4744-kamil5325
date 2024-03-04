package org.jetbrains.assignment.endpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
class Endpoint {
    private final MovementCalculationService service;

    Endpoint(MovementCalculationService service) {
        this.service = service;
    }

    @PostMapping("/locations")
    public List<PointDTO> getLocations(@RequestBody List<MovementDTO> movements) {
        return service.findLocationsForMovements(movements);
    }

    @PostMapping("/moves")
    public List<MovementDTO> getMoves(@RequestBody List<PointDTO> locations) {
        return service.findMovementsForLocation(locations);
    }
}
