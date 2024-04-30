package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
}
