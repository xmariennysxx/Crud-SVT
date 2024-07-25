package com.eval.crud.services;

import com.eval.crud.data.PositionDTO;
import com.eval.crud.data.UnitDTO;
import com.eval.crud.entities.Position;
import com.eval.crud.entities.Unit;
import com.eval.crud.repositories.PositionRepository;
import com.eval.crud.repositories.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    private final UnitRepository unitRepository;
    private final PositionRepository positionRepository;

    public InfoService(UnitRepository unitRepository, PositionRepository positionRepository) {
        this.unitRepository = unitRepository;
        this.positionRepository = positionRepository;
    }

    public List<Unit> getUnits() {
        return unitRepository.findAll();
    }

    public List<Position> getPositions() {
        return positionRepository.findAll();
    }

    public Unit createUnit(UnitDTO dto) {
        return unitRepository.save(new Unit(dto.getName()));
    }

    public Position createPosition(PositionDTO dto) {
        return positionRepository.save(new Position(dto.getTitle()));
    }
}
