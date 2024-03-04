package org.jetbrains.assignment.endpoint;

import org.jetbrains.assignment.shared.Direction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class MovementCalculationService {

    List<PointDTO> findLocationsForMovements(List<MovementDTO> inputs) {
        List<PointDTO> points = new ArrayList<>();
        Integer currentX = 0;
        Integer currentY = 0;
        points.add(new PointDTO(currentX, currentY));
        for (MovementDTO i : inputs) {
            switch (i.direction()) {
                case EAST -> {
                    currentX = currentX + i.steps();
                    points.add(new PointDTO(currentX, currentY));
                }
                case WEST -> {
                    currentX = currentX - i.steps();
                    points.add(new PointDTO(currentX, currentY));
                }
                case NORTH -> {
                    currentY = currentY + i.steps();
                    points.add(new PointDTO(currentX, currentY));
                }
                case SOUTH -> {
                    currentY = currentY - i.steps();
                    points.add(new PointDTO(currentX, currentY));
                }
            }

        }
        return points;
    }

    List<MovementDTO> findMovementsForLocation(List<PointDTO> points) {
        List<MovementDTO> movements = new ArrayList<>();
        Integer currentX = 0;
        Integer currentY = 0;
        for (PointDTO p : points) {

            if (p.x() == currentX || p.y() == currentY) {

            }
            if (p.x() < currentX) {
                currentX = Math.abs(currentX - p.x());
                movements.add(new MovementDTO(Direction.WEST, Math.abs(currentX)));
            }
            if (p.x() > currentX) {
                currentX = Math.abs(currentX - p.x());
                movements.add(new MovementDTO(Direction.EAST, Math.abs(currentX)));
            }
            if (p.y() > currentY) {
                currentY = Math.abs(currentY - p.y());
                movements.add(new MovementDTO(Direction.NORTH, Math.abs(currentY)));
            }
            if (p.y() < currentY) {
                currentY = Math.abs(currentY - p.y());
                movements.add(new MovementDTO(Direction.SOUTH, Math.abs(currentY)));
            }

        }
        return movements;
    }

}

