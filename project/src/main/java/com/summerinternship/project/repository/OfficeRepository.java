package com.summerinternship.project.repository;

import com.summerinternship.project.model.Offices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends CrudRepository<Offices, Long> {
}
