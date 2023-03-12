/**
 * 
 */
package com.pool.rest.repository.dressaddress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pool.rest.model.DressDetailsModel;

/**
 * @author dasar
 *
 */
@Repository
public interface DressAddressRepository extends JpaRepository<DressDetailsModel, String>{

}
