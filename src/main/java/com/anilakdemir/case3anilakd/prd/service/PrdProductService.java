package com.anilakdemir.case3anilakd.prd.service;

import com.anilakdemir.case3anilakd.prd.converter.PrdProductMapper;
import com.anilakdemir.case3anilakd.prd.dto.PrdProductDto;
import com.anilakdemir.case3anilakd.prd.dto.PrdProductSaveRequestDto;
import com.anilakdemir.case3anilakd.prd.entity.PrdProduct;
import com.anilakdemir.case3anilakd.prd.service.entityService.PrdProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class PrdProductService {

    private final PrdProductEntityService prdProductEntityService;

    public PrdProductDto save(PrdProductSaveRequestDto prdProductSaveRequestDto){
        PrdProduct prdProduct = PrdProductMapper.INSTANCE.convertToPrdProduct(prdProductSaveRequestDto);
        prdProduct = prdProductEntityService.save(prdProduct);
        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);
        return  prdProductDto;
    }

    public List<PrdProductDto> findAll(){
        List<PrdProduct> prdProductList = prdProductEntityService.findAll();
        List<PrdProductDto> prdProductDtoList = PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList);
        return prdProductDtoList;
    }

    public PrdProductDto findByIdWithControl(Long id){
        PrdProduct prdProduct = prdProductEntityService.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);
        return prdProductDto;
    }

    public void deleteByIdWithControl(Long id){
        prdProductEntityService.deleteByIdWithControl(id);
    }

    public PrdProductDto updatePrice(Long id, BigDecimal price){
        PrdProduct prdProduct = prdProductEntityService.updatePrice(id, price);
        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);
        return prdProductDto;
    }

}
