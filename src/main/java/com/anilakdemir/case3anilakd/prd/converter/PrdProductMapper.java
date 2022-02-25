package com.anilakdemir.case3anilakd.prd.converter;

import com.anilakdemir.case3anilakd.prd.dto.PrdProductDto;
import com.anilakdemir.case3anilakd.prd.dto.PrdProductSaveRequestDto;
import com.anilakdemir.case3anilakd.prd.entity.PrdProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdProductMapper {

    PrdProductMapper INSTANCE = Mappers.getMapper(PrdProductMapper.class);

    PrdProduct convertToPrdProduct(PrdProductSaveRequestDto prdProductSaveRequestDto);

    PrdProductDto convertToPrdProductDto(PrdProduct product);

    List<PrdProductDto> convertToPrdProductDtoList(List<PrdProduct> prdProductList);

}
