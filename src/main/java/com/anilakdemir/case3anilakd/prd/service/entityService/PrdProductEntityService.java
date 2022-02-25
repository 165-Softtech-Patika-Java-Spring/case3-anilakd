package com.anilakdemir.case3anilakd.prd.service.entityService;

import com.anilakdemir.case3anilakd.gen.service.BaseEntityService;
import com.anilakdemir.case3anilakd.prd.dao.PrdProductDao;
import com.anilakdemir.case3anilakd.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author anilakdemir
 */
@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {

    public PrdProductEntityService (PrdProductDao dao) {
        super(dao);
    }

    public List<PrdProduct> findAll(){
        return getDao().findAll();
    }

    @Transactional
    public void deleteByIdWithControl(Long id){
        boolean isExist = getDao().existsById(id);

        if (isExist){
            getDao().deleteById(id);
        }else{
            throw new RuntimeException("Product not found");
        }
    }

    public Optional<PrdProduct> findById(Long id){
        return getDao().findById(id);
    }

    public boolean existById(Long id){
        return getDao().existsById(id);
    }

    public PrdProduct updatePrice(Long id, BigDecimal price){
        boolean isExist = existById(id);

        if (isExist){
            PrdProduct prdProduct = findById(id).get();
            prdProduct.setPrice(price);
            prdProduct = save(prdProduct);
            return prdProduct;
        }else{
            throw new RuntimeException("Product not found");
        }

    }
}
