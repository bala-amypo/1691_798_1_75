package com.example.demo.service;

import com.example.demo.entity.VisitLog;

import java.util.List;

public interface VisitLogService {

    VisitLog createVisitLog(Long visitorId, VisitLog log);

    VisitLog getLog(Long id);

    List<VisitLog> getLogsByVisitor(Long visitorId);
}
