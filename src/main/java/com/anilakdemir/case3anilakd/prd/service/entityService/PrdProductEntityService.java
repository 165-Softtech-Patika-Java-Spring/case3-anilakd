package com.anilakdemir.case3anilakd.prd.service.entityService;

import com.anilakdemir.case3anilakd.gen.service.BaseEntityService;
import com.anilakdemir.case3anilakd.prd.dao.PrdProductDao;
import com.anilakdemir.case3anilakd.prd.entity.PrdProduct;
import com.anilakdemir.case3anilakd.prd.exception.PrdProductNotFoundException;
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

    /**
     * it returns product list
     */
    public List<PrdProduct> findAll () {
        return getDao().findAll();
    }

    /**
     * it deletes if there is product with id parameter,
     * otherwise throws an exception
     */
    @Transactional
    public void deleteByIdWithControl (Long id) {
        boolean isExist = getDao().existsById(id);

        if (isExist){
            getDao().deleteById(id);
        }else{
            throw new PrdProductNotFoundException();
        }
    }

    /**
     * it returns Optional<PrdProduct> by id
     */
    public Optional<PrdProduct> findById (Long id) {
        return getDao().findById(id);
    }

    /**
     * it returns PrdProduct, if there is no PrdProduct with id, it throws an exception
     */
    public PrdProduct getByIdWithControl(Long id){
        PrdProduct prdProduct = findById(id).orElseThrow(()->new PrdProductNotFoundException());
        return prdProduct;
    }

    /**
     * it returns true if there is a PrdProduct with id
     */
    public boolean existById (Long id) {
        return getDao().existsById(id);
    }

    /**
     * it sets new price and save
     */
    public PrdProduct updatePrice (Long id, BigDecimal price) {
        PrdProduct prdProduct = getByIdWithControl(id);
        prdProduct.setPrice(price);
        prdProduct = save(prdProduct);
        return prdProduct;
    }
}
