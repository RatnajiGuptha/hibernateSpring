package com.guptha.springdata.filedata.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.filedata.entities.Image;

public interface ImagesRepository extends CrudRepository<Image, Long> {

}
