package com.araltiparmak.springbootjunitmockito.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClinicService {

    @Autowired
    VetRepository vetRepository;

    @Transactional(readOnly = true)
    @Cacheable(value = "vets")
    public Vet findById(Integer id) {
        return vetRepository.findById(id).orElse(null);
    }
}
