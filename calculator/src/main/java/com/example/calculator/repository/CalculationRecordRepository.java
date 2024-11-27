package com.example.calculator.repository;

import com.example.calculator.model.CalculationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRecordRepository extends MongoRepository<CalculationRecord, String> {
}
