package com.example.CCMS.controllers;


import com.example.CCMS.models.AgentModel;
import com.example.CCMS.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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
    public AgentModel saveStudent(@RequestBody AgentModel student){
        return AgentService.saveStudent(student);
    }

    @PutMapping("/edit/{id}")
    public AgentModel editStudent(@PathVariable Long id, @RequestBody AgentModel student){ return AgentService.editAgent(id, student); }

    @DeleteMapping("/delete/id")
    public String deleteStudentById(@RequestParam("id") Long id){ return AgentService.deleteAgentById(id); }

    @DeleteMapping("/delete/code")
    public String deleteStudentByCode(@RequestParam("code") String code){ return AgentService.deleteAgentByCode(code); }


}
