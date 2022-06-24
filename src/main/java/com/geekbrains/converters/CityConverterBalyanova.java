package com.geekbrains.converters;

import com.geekbrains.dto.CitiesDtoBalyanova;
import com.geekbrains.entities.CitiesBalyanova;
import org.springframework.stereotype.Component;

@Component
public class CityConverterBalyanova {
    public CitiesBalyanova dtoToEntity(CitiesDtoBalyanova cityDto) {
        return new CitiesBalyanova(cityDto.getId(), cityDto.getCity());
    }

    public CitiesDtoBalyanova entityToDto(CitiesBalyanova city) {
        return new CitiesDtoBalyanova(city.getId(), city.getCity());
    }
}
