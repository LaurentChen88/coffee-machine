package org.example.coffeemachine2.mapper;

import org.example.coffeemachine2.dto.CoffeeCreateDto;
import org.example.coffeemachine2.dto.CoffeeDto;
import org.example.coffeemachine2.dto.CoffeeUpdateDto;
import org.example.coffeemachine2.entity.Coffee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Coffee entity, CoffeeUpdateDto dto);
}
