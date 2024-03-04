package org.jetbrains.assignment.endpoint;

import org.jetbrains.assignment.shared.Direction;

record MovementDTO(Direction direction, Integer steps) {
}
