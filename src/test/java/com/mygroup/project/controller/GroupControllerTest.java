//package com.mygroup.project.controller;
//
//import com.mygroup.project.config.AppConfig;
//import junit.framework.TestCase;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class GroupControllerTest extends TestCase {
//
//    private GroupController groupController;
//
//    @BeforeClass
//    void init(){
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        groupController = applicationContext.getBean(GroupController.class);
//    }
//
//    @Test
//    public void testSave() {
//    }
//
//    @Test
//    public void testGet() {
//    }
//
//    @Test
//    public void testList() {
//    }
//
//    @Test
//    public void testUpdate() {
//    }
//
//    @Test
//    public void testDelete() {
//    }
//}