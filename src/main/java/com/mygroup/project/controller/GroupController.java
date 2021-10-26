package com.mygroup.project.controller;

import com.mygroup.project.model.Group;
import com.mygroup.project.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    /*---Add new group---*/
    @PostMapping("/group")
    public ResponseEntity<Group> save(@RequestBody Group group) {
        System.err.println("the json value of student is :::::: " + group);
        groupService.save(group);
        return ResponseEntity.ok().body(group);
    }

    /*---Get a group by id---*/
    @GetMapping("/group/{id}")
    public ResponseEntity<Group> get(@PathVariable("id") long id) {
        Group group = groupService.get(id);
        return ResponseEntity.ok().body(group);
    }

    /*---get all group---*/
    @GetMapping("/group")
    public ResponseEntity<List<Group>> getAll() {
        List<Group> groups = groupService.getAll();
        return ResponseEntity.ok().body(groups);
    }

    /*---Update a group by id---*/
    @PutMapping("/group/{id}")
    public ResponseEntity<Group> update(@PathVariable("id") long id, @RequestBody Group group) {
        groupService.update(id, group);
        return ResponseEntity.ok().body(group);
    }

    /*---Delete a group by id---*/
    @DeleteMapping("/group/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
