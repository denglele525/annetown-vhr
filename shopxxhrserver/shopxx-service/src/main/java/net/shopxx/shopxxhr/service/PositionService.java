package net.shopxx.shopxxhr.service;

import net.shopxx.shopxxhr.model.Position;

import java.util.List;

public interface PositionService {

    List<Position> getAllPositions();

    Position saveOrUpdatePosition(Position position);

    void deletePositionById(Integer id);

    Position findOne(Position position);

    void deletePositionsByIds(Integer[] ids);

}
