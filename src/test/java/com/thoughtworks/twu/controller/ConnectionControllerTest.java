package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.ConnectionService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
//
//public class ConnectionControllerTest {
//    ConnectionService mockConnectionService = mock(ConnectionService.class);
//
//    private ConnectionController friends = new ConnectionController(mockConnectionService);
//
//    @Test
//    public void shouldNavigateToFriendsListPage() throws Exception {
//
//        View expectedModelAndView = new ModelAndView("/my-friends-list").getView();
//        View actualModelAndView = friends.listPagase().getView();
//
//        assertThat(actualView, is(expectedView));
//    }
//
//
////    @Test
////    public void shouldWriteToDatabase;
//
//}
