package com.example.CCMS.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CCMS.models.AgentModel;
import com.example.CCMS.repositories.AgentRepository;

import jakarta.transaction.Transactional;

@Service
public class AgentService {

    @Autowired
    AgentRepository AgentRepository;

    public ArrayList<AgentModel> getAllAgents() { return (ArrayList<AgentModel>) AgentRepository.findAll(); }

    public AgentModel saveAgent(AgentModel student){
        String searchCode = student.getCode();
        if(AgentRepository.findByCode(searchCode).isEmpty()){
            return AgentRepository.save(student);
        } else{
            return null;

        }
    }

    public Optional<AgentModel> findById(Long id){
        return AgentRepository.findById(id);
    }

    public Optional<AgentModel> findByCode(String code){
        return AgentRepository.findByCode(code);
    }

    public AgentModel editAgent(Long id, AgentModel agent){

        AgentModel existingAgent = AgentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Agent not found with id: " + id));

        existingAgent.setCode(agent.getCode());
        existingAgent.setName(agent.getName());
        existingAgent.setSupervisor(agent.getSupervisor());
        existingAgent.setAcm(agent.getAcm());
        existingAgent.setLob(agent.getLob());
        existingAgent.setTenure(agent.getTenure());


        return AgentRepository.save(existingAgent);
    }

    public String deleteAgentById(Long id){

        if(findById(id).isPresent()){
            AgentRepository.deleteById(id);
            return "Agent deleted successfully";
        } else{
            return "Agent with id "+ id +" not found";
        }

    }

    @Transactional
    public String deleteAgentByCode(String code){

        if(findByCode(code).isPresent()){
            AgentRepository.deleteByCode(code);
            return "Agent deleted successfully";
        } else{
            return "Agent with code "+ code +" not found";
        }

    }

}
