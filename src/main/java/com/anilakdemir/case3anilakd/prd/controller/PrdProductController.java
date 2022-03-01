package com.anilakdemir.case3anilakd.prd.controller;

import com.anilakdemir.case3anilakd.gen.dto.RestResponse;
import com.anilakdemir.case3anilakd.prd.dto.PrdProductDto;
import com.anilakdemir.case3anilakd.prd.dto.PrdProductSaveRequestDto;
import com.anilakdemir.case3anilakd.prd.service.PrdProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author anilakdemir
 */
@RestController
@RequestMapping("/v1/api/products")
@RequiredArgsConstructor
public class PrdProductController {

    private final PrdProductService prdProductService;

    @Operation(summary = "Save product")
    @PostMapping
    public ResponseEntity save (@RequestBody PrdProductSaveRequestDto prdProductSaveRequestDto) {
        PrdProductDto prdProductDto = prdProductService.save(prdProductSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }

    @Operation(summary = "Find all products")
    @GetMapping
    public ResponseEntity getAll () {
        List<PrdProductDto> prdProductDtoList = prdProductService.findAll();
        return ResponseEntity.ok(RestResponse.of(prdProductDtoList));
    }

    @Operation(summary = "Get product by id")
    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Long id) {
        PrdProductDto prdProductDto = prdProductService.findByIdWithControl(id);
        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }

    @Operation(summary = "Delete product by id")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById (@PathVariable Long id) {
        prdProductService.deleteByIdWithControl(id);
        return ResponseEntity.ok(RestResponse.of(Void.TYPE));
    }

    @Operation(summary = "Update price of product")
    @PatchMapping("/{id}")
    public ResponseEntity updatePrice (@PathVariable Long id, @RequestParam BigDecimal price) {
        PrdProductDto prdProductDto = prdProductService.updatePrice(id, price);
        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }
}
