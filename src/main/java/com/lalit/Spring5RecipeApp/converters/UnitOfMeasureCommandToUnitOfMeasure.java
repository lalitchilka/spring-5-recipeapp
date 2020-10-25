package com.lalit.Spring5RecipeApp.converters;

import com.lalit.Spring5RecipeApp.commands.UnitOfMeasureCommand;
import com.lalit.Spring5RecipeApp.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {

        if(unitOfMeasureCommand != null){
            final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setId(unitOfMeasureCommand.getId());
            unitOfMeasure.setDescription(unitOfMeasureCommand.getDescription());
            return unitOfMeasure;
        }
        return null;
    }
}
