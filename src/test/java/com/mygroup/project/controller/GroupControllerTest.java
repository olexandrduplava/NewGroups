//package com.mygroup.project.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mygroup.project.config.AppConfig;
//import com.mygroup.project.model.Group;
//import com.mygroup.project.service.GroupService;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import static org.mockito.Matchers.any;
//import static org.mockito.Matchers.eq;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {AppConfig.class})
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class GroupControllerTest{
//
//    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);
//
//    String BASE_URL = "/group";
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private GroupService groupService;
//
//    @InjectMocks
//    private GroupController groupController;
//
//    private ObjectMapper objectMapper;
//
//    Group expectedGroup;
//
//    @BeforeClass
//    void init(){
//        objectMapper = new ObjectMapper();
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
//    }
//
//    @BeforeMethod
//    public void setup(){
//        expectedGroup = new Group(1L,"TEST");
//    }
//
//    @AfterMethod
//    public void testEnd(){
//        expectedGroup = null;
//    }
//
//    @Test
//    public void testSave() throws Exception {
//        String url = BASE_URL;
//        Mockito.when(groupService.save(any(Group.class))).thenReturn(expectedGroup.getId());
//        String requestJson = objectMapper.writeValueAsString(expectedGroup);
//        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(APPLICATION_JSON_UTF8)
//                        .content(requestJson))
//                .andExpect(status().isOk())
//                .andExpect(content().string("New Group has been saved with ID:" + expectedGroup.getId()));
//        Mockito.verify(groupService, Mockito.times(1)).save(any(Group.class));
//    }
//
//    @Test
//    public void testGet() throws Exception {
//        String url = BASE_URL + "/" + expectedGroup.getId();
//        Mockito.when(groupService.get(expectedGroup.getId())).thenReturn(expectedGroup);
//        mockMvc.perform(MockMvcRequestBuilders.get(url))
//                .andExpect(content().string(
//                        "{\"id\":1,\"title\":\"TEST\",\"createDate\":null}"))
//                .andExpect(status().isOk());
//        Mockito.verify(groupService, Mockito.times(1)).get(expectedGroup.getId());
//    }
//
//    @Test
//    public void testGetAll() throws Exception {
//
//        String url = BASE_URL;
//        Group group2 = new Group(2L,"TEST2");
//        Mockito.when(groupService.getAll()).thenReturn(Arrays.asList(expectedGroup, group2));
//        mockMvc.perform(MockMvcRequestBuilders.get(url))
//                .andExpect(content().string(
//                        "[{\"id\":1,\"title\":\"TEST\",\"createDate\":null}," +
//                                "{\"id\":2,\"title\":\"TEST2\",\"createDate\":null}]"))
//                .andExpect(status().isOk());
//        Mockito.verify(groupService, Mockito.times(1)).getAll();
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        String url = BASE_URL + "/1";
//        Mockito.when(groupService.update(eq(1L), any(Group.class))).thenReturn(expectedGroup);
//        String requestJson = objectMapper.writeValueAsString(expectedGroup);
//        mockMvc.perform(MockMvcRequestBuilders.put(url).contentType(APPLICATION_JSON_UTF8)
//                        .content(requestJson))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Group with id: " + expectedGroup.getId() + " has been updated successfully."));
//        Mockito.verify(groupService, Mockito.times(1)).update(eq(1L), any(Group.class));
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        String url = BASE_URL + "/" + expectedGroup.getId();
//        Mockito.when(groupService.delete(expectedGroup.getId())).thenReturn(expectedGroup);
//        mockMvc.perform(MockMvcRequestBuilders.delete(url))
//                .andExpect(content().string("Group with id: "  + expectedGroup.getId() + " has been deleted successfully."))
//                .andExpect(status().isOk());
//        Mockito.verify(groupService, Mockito.times(1)).delete(expectedGroup.getId());
//    }
//}