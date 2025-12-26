package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitor Controller")
public class VisitorController {

    private final VisitorService visitorService;

    // Constructor injection (REQUIRED by tests)
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    // ===== CREATE VISITOR =====
    @PostMapping
    public ResponseEntity<Visitor> create(@RequestBody Visitor visitor) {
        Visitor created = visitorService.createVisitor(visitor);
        return ResponseEntity.ok(created);
    }

    // ===== GET VISITOR BY ID =====
    @GetMapping("/{id}")
    public ResponseEntity<Visitor> get(@PathVariable Long id) {
        Visitor visitor = visitorService.getVisitor(id);
        return ResponseEntity.ok(visitor);
    }

    // ===== GET ALL VISITORS =====
    @GetMapping
    public ResponseEntity<List<Visitor>> all() {
        List<Visitor> visitors = visitorService.getAllVisitors();
        return ResponseEntity.ok(visitors);
    }
}
