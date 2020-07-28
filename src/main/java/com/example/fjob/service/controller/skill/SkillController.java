package com.example.fjob.service.controller.skill;

import com.example.fjob.lib.dataset.skill.SkillDataset;
import com.example.fjob.lib.dataset.skill.UserSkill;
import com.example.fjob.service.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<SkillDataset> selSkillCategory() {
        return service.getSkillCategory();
    }

    @GetMapping("/{username}")
    public List<UserSkill> selUserSkill(@PathVariable("username") String username) {
        return service.getSkillOfUser(username);
    }

    @PutMapping("/updateSkill")
    public int updateSkill(@RequestBody UserSkill userSkill, @RequestParam("newSkillId") String newSkillId) {
        return service.updateSkill(userSkill, newSkillId);
    }

    @PostMapping("/insertSkill")
    public int insertSkill(@RequestBody UserSkill userSkill) {
        return service.insertSkill(userSkill);
    }

    @PostMapping("/deleteSkill")
    public int deleteSkill(@RequestBody UserSkill userSkill) {
        return service.deleteSkill(userSkill);
    }
}
