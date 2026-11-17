package org.example.coffeemachine2.mapper;

import org.example.coffeemachine2.dto.CoffeeCreateDto;
import org.example.coffeemachine2.dto.CoffeeDto;
import org.example.coffeemachine2.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeCreateDto dto);
}
