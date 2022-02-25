package com.anilakdemir.case3anilakd.gen.service;

import com.anilakdemir.case3anilakd.gen.entity.BaseAdditionalFields;
import com.anilakdemir.case3anilakd.gen.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity,D extends JpaRepository<E, Long>> {

    private final D dao;

    public E save(E entity){
        setAdditionalFields(entity);
        entity = dao.save(entity);
        return entity;
    }


    /**
     * When object is created, baseAdditional field will be created and createDate will be set
     * When object is updated, updateDate will be set
     */
    private void setAdditionalFields (E entity) {
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();

        if(baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }

        if(entity.getId() == null){
            baseAdditionalFields.setCreateDate(new Date());
        }

        baseAdditionalFields.setUpdateDate(new Date());
    }

    public D getDao () {
        return dao;
    }
}
