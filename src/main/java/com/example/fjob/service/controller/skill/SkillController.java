package com.example.fjob.service.controller.skill;

import com.example.fjob.service.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fjob/v1/skill")
public class SkillController {

    private SkillService service;

    @Autowired
    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<String> selSkillCategory(){
        return service.getSkillCategory();
    }
}
