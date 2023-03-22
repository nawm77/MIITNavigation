package com.example.miitnavigation.controller;

import com.example.miitnavigation.service.GroupParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miit/api/v1")
public class GroupController {
    private final GroupParserService groupParserService;

    @Autowired
    public GroupController(GroupParserService groupParserService) {
        this.groupParserService = groupParserService;
    }

    @GetMapping("/groups")
    public String getAllGroups() {
        return groupParserService.parse().toString();
    }
}
