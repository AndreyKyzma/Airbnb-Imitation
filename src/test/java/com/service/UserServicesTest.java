package com.service;

import com.Utill.UserUtill;
import com.config.TestDataConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Kyza on 23.01.2016.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfig.class)
@WebAppConfiguration
public class UserServicesTest {
    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserServices userService;

    @Before
    public void setUp() throws Exception{
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveUser() throws Exception{
        userService.addUser(UserUtill.createUser());
    }
}
