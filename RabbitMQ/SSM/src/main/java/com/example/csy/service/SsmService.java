package com.example.csy.service;

public interface SsmService {

    /**
     *   同步处理流程
     */
    public void synchronizeService();

    /**
     * 核心业务同步+非核心业务异步处理流程
     */
    public void asynchronizeService();
}
