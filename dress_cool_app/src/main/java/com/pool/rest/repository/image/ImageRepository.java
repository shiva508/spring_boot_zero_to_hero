package com.pool.rest.repository.image;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.rest.model.images.ImagesModel;
@Repository
public interface ImageRepository extends JpaRepository<ImagesModel, Integer> {
	public List<ImagesModel> findByUserId(Integer userId);

}
