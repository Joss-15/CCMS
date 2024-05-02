package com.example.CCMS.repositories;


import com.example.CCMS.models.AgentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends CrudRepository<AgentModel, Long> {

    Optional<AgentModel> findByCode(String code);

    void deleteByCode(String code);
}
