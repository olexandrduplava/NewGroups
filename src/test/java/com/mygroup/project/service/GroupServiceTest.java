package com.mygroup.project.service;

import com.mygroup.project.dao.GroupDao;
import com.mygroup.project.model.Group;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GroupServiceTest{

    @Mock
    private GroupDao groupDao;
    private GroupService groupService;

    @BeforeMethod
    void init(){
        MockitoAnnotations.initMocks(this);
        groupService = new GroupServiceImp(groupDao);
    }

    @Test
    public void testSaveGroupService() {
        long expectedId = 1;
        Group group = new Group("Group 1");
        when(groupDao.save(group)).thenReturn(expectedId);
        long actualId = groupDao.save(group);
        verify(groupDao).save(group);
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetGroupService() {
        long expectedId = 1;
        Group group = new Group("Group 1");
        when(groupDao.get(expectedId)).thenReturn(group);
        Group expectedGroup = groupService.get(expectedId);
        verify(groupDao).get(expectedId);
        Assert.assertEquals(group, expectedGroup);
    }

    @Test
    public void testListGroupService() {

        Group group1 = new Group("Group 1");
        Group group2 = new Group("Group 2");
        Group group3 = new Group("Group 3");
        Group group4 = new Group("Group 4");
//        Set<Group> actualList = Arrays.asList(group1,group2,group3,group4);
        Set<Group> actualList = Set.of(group1,group2,group3,group4);
        when(groupDao.getAll()).thenReturn(actualList);
        Set<Group> expectedList = groupService.getAll();
        verify(groupDao).getAll();
        assertThat(expectedList)
                .isNotNull()
                .isNotEmpty()
                .hasSizeGreaterThan(1)
                .contains(group1, group2,group3,group4);

    }

    @Test
    public void testUpdateGroupService() {
        long expectedId = 1;
        Group group = new Group("Group 1");
        when(groupDao.save(group)).thenReturn(expectedId);
        doNothing().when(groupDao).update(expectedId, group);
        groupService.update(expectedId, group);
        verify(groupDao).update(expectedId, group);
    }

    @Test
    public void testDeleteGroupService() {
        long expectedId = 1;
        Group group = new Group("Group 1");
        when(groupDao.save(group)).thenReturn(expectedId);
        doNothing().when(groupDao).delete(expectedId);
        groupService.delete(expectedId);
        verify(groupDao).delete(expectedId);
    }
}