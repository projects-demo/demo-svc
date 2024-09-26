package com.example.demo_svc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicFactorRepository extends JpaRepository<EconomicFactors, EconomicFactorsId> {
    List<EconomicFactors> findByMonthAndYear(int month, int year);
}
