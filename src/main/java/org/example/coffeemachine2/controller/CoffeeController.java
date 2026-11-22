package org.example.coffeemachine2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.coffeemachine2.dto.CoffeeCreateDto;
import org.example.coffeemachine2.dto.CoffeeDto;
import org.example.coffeemachine2.dto.CoffeeUpdateDto;
import org.example.coffeemachine2.entity.Coffee;
import org.example.coffeemachine2.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeeService service;

    @PostMapping
    CoffeeDto create(@RequestBody @Valid CoffeeCreateDto dto){
        return service.create(dto);
    }

    @GetMapping
    List<CoffeeDto> coffees(){

        return service.allCoffees();
    }

    @GetMapping("{id}")
    ResponseEntity<CoffeeDto> coffee(@PathVariable Long id){
        return service.oneCoffee(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    ResponseEntity<CoffeeDto> update(@PathVariable Long id, @RequestBody @Valid CoffeeUpdateDto dto){
        return service.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
