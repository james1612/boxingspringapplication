package com.qa.repository;

import com.qa.models.Boxer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxersRepository extends JpaRepository <Boxer, Long>{


}
