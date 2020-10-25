package com.lalit.Spring5RecipeApp.converters;

import com.lalit.Spring5RecipeApp.commands.UnitOfMeasureCommand;
import com.lalit.Spring5RecipeApp.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if(unitOfMeasure != null){
            final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
            unitOfMeasureCommand.setId(unitOfMeasure.getId());
            unitOfMeasureCommand.setDescription((unitOfMeasure.getDescription()));
            return unitOfMeasureCommand;
        }
        return null;
    }
}
