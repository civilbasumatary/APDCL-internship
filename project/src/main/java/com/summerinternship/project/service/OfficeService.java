package com.summerinternship.project.service;

import com.summerinternship.project.model.Office;
import com.summerinternship.project.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        Iterable<Office> iterable = officeRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                            .collect(Collectors.toList());
    }

    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElse(null);
    }

    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(Long id) {
        officeRepository.deleteById(id);
    }
}
