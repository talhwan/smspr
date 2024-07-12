package com.thc.smspr.service;

import org.springframework.stereotype.Service;

import java.util.Map;

//2024-07-12 추가(클래스 처음 추가함)
@Service
public interface TbboardService {
    /**/
    public Map<String, Object> create(Map<String, Object> param);
    public Map<String, Object> update(Map<String, Object> param);
    public Map<String, Object> delete(String id);
    public Map<String, Object> detail(String id);
    public Map<String, Object> list();
}
