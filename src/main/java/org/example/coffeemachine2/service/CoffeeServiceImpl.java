package org.example.coffeemachine2.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.coffeemachine2.dto.CoffeeCreateDto;
import org.example.coffeemachine2.dto.CoffeeDto;
import org.example.coffeemachine2.dto.CoffeeUpdateDto;
import org.example.coffeemachine2.entity.Coffee;
import org.example.coffeemachine2.mapper.CoffeeMapper;
import org.example.coffeemachine2.repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository repository;
    private final CoffeeMapper mapper;

    @PostConstruct
    void initDb(){
        repository.saveAll(List.of(
                new Coffee("Expresso", 98),
                new Coffee("Latte mapper", 76),
                new Coffee("Robusta", 54)
        ));
    }

    @Override
    public List<CoffeeDto> allCoffees() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<CoffeeDto> oneCoffee(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public CoffeeDto create(CoffeeCreateDto dto) {
        Coffee entity = mapper.toEntity(dto);
        Coffee saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public Optional<CoffeeDto> update(Long id, CoffeeUpdateDto dto) {
        return repository.findById(id).map( existing -> {
            mapper.updateEntity(existing, dto);
            return mapper.toDto(existing);
        });
    }
}
