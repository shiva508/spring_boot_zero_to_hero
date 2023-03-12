/**
 * 
 */
package com.pool.rest.repository.dressaddress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.rest.model.DressType;

/**
 * @author dasar
 *
 */
@Repository
public interface DressTypeRepository extends JpaRepository<DressType, Integer> {

}
