package com.example.projectm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface itemrepo extends CrudRepository<items, String> {

    List<items> findAll();


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update items e set e.sup=:#{#newVal} where e.item_id=:#{#cid}")
    void updateCollection(@Param("newVal")supplier newVal, @Param("cid") int cid);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update items e set e.reorder_quantity=:#{#newVal} where e.item_id=:#{#cid}")
    void updateReorder(@Param("newVal") int newVal, @Param("cid") int cid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update items e set e.lead_time=:#{#newVal} where e.item_id=:#{#cid}")
    void updateLead(@Param("newVal") int newVal, @Param("cid") int cid);


    @Query("SELECT o FROM items o WHERE o.item_id=:#{#oid}")
    items getitem(@Param("oid") int oid);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update items e set e.item_quantity=:#{#quant} where e.item_name=:#{#iname}")
    void updateQuantity(@Param("quant")int quant, @Param("iname") String iname);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update items e set e.item_quantity=:#{#quant} where e.item_id=:#{#iid}")
    void updateQuantitywithID(@Param("quant")int quant, @Param("iid") int iid);

}

