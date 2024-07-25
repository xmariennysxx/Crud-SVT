package com.eval.crud.controllers;

import com.eval.crud.data.PositionDTO;
import com.eval.crud.data.UnitDTO;
import com.eval.crud.entities.Position;
import com.eval.crud.entities.Unit;
import com.eval.crud.services.InfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("info")
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/getunits")
    public ResponseEntity<List<Unit>> getUnits() {
        List<Unit> units = infoService.getUnits();
        if (units.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(units);
        }
    }

    @GetMapping("/getpositions")
    public ResponseEntity<List<Position>> getPositions() {
        List<Position> positions = infoService.getPositions();
        if (positions.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(positions);
        }
    }

    @PostMapping("/createunit")
    public ResponseEntity<Unit> createUnit(@RequestBody UnitDTO dto) {
        Unit unit = infoService.createUnit(dto);
        return ResponseEntity.ok(unit);
    }

    @PostMapping("/createposition")
    public ResponseEntity<Position> createPosition(@RequestBody PositionDTO dto) {
        Position position = infoService.createPosition(dto);
        return ResponseEntity.ok(position);
    }
}
