package com.example.projectm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface supprepo extends CrudRepository<supplier, String> {

    List<supplier> findAll();

    
    @Query("SELECT o FROM supplier o WHERE o.supplier_id=:#{#oid}")
    supplier getSupplier(@Param("oid") int oid);

    @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.brand_name=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateName(@Param("newVal") String newVal, @Param("cid") int cid);


     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.email_address=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateEMail(@Param("newVal") String newVal, @Param("cid") int cid);

     
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.delivery_location=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateDelivery(@Param("newVal") String newVal, @Param("cid") int cid);

     
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.collection_location=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateCollection(@Param("newVal") String newVal, @Param("cid") int cid);


     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.main_location=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateMain(@Param("newVal") String newVal, @Param("cid") int cid);

     
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.contact_number=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateContact(@Param("newVal") String newVal, @Param("cid") int cid);

     
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.supplier_status=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateStatus(@Param("newVal") String newVal, @Param("cid") int cid);

     
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("delete supplier e where e.supplier_id=:#{#cid}")
     void deleteSupplier(@Param("cid") int cid);

     
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.delivery_performance=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateDeliveryPerformance(@Param("newVal") String newVal, @Param("cid") int cid);

     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update supplier e set e.quality_performance=:#{#newVal} where e.supplier_id=:#{#cid}")
     void updateQualityPerformance(@Param("newVal") String newVal, @Param("cid") int cid);


}

