package com.example.CCMS.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CCMS.models.AgentModel;
import com.example.CCMS.services.AgentService;

@RestController
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    AgentService AgentService;

    @GetMapping()
    public ArrayList<AgentModel> getAllStudents(){ return AgentService.getAllAgents(); }

    @GetMapping("/id/{id}")
    public Optional<AgentModel> getStudentById(@PathVariable Long id){
        return AgentService.findById(id);
    }

    @GetMapping("/code/{code}")
    public Optional<AgentModel> getStudentByCode(@PathVariable String code){ return AgentService.findByCode(code); }

    @PostMapping()
    public AgentModel saveAgent(@RequestBody AgentModel agent){
        return AgentService.saveAgent(agent);
    }

    @PutMapping("/edit/{id}")
    public AgentModel editAgent(@PathVariable Long id, @RequestBody AgentModel agent){ return AgentService.editAgent(id, agent); }

    @DeleteMapping("/delete/id")
    public String deleteAgentById(@RequestParam("id") Long id){ return AgentService.deleteAgentById(id); }

    @DeleteMapping("/delete/code")
    public String deleteAgentByCode(@RequestParam("code") String code){ return AgentService.deleteAgentByCode(code); }


}
