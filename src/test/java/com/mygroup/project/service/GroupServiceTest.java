package com.mygroup.project.service;

import com.mygroup.project.config.AppConfig;
import com.mygroup.project.dao.GroupDao;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupServiceTest extends TestCase {

    private GroupService groupService;

    @BeforeClass
    void init(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        groupService = applicationContext.getBean(GroupService.class);
    }

    @Test
    public void testSave() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testList() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDelete() {
    }
}