package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.domain.frontend.Extra;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

@Transactional
public class ExtraDAOImplTest {
    
    @Autowired
    private ExtraDAO extraDAO;

    private static final double DELTA = 1e-3;

    @Test
    public void testCreate() throws Exception {
        Extra extra = new Extra("Limousine", "Rent a limousine", 150.00, "/image");
        extraDAO.create(extra);

        Extra extraFromDb = extraDAO.getById(extra.getId());

        assertEquals(extra.getLabel(), extraFromDb.getLabel());
        assertEquals(extra.getDesc(), extra.getDesc());
        assertEquals(extra.getCost(), extra.getCost(), DELTA);
        assertEquals(extra.getPic(), extraFromDb.getPic());
    }

    @Test
    public void testDelete() throws Exception {
        Extra extra = new Extra("Limousine", "Rent a limousine", 150.00, "/image");
        extraDAO.create(extra);

        assertEquals(1, extraDAO.getAll().size());

        extraDAO.delete(extra.getId());

        assertEquals(0, extraDAO.getAll().size());
    }

    @Test
    public void testUpdate() throws Exception {
        Extra extra = new Extra("Limousine", "Rent a limousine", 150.00, "/image");
        extraDAO.create(extra);

        extra.setLabel("Girls");
        extra.setDesc("Pretty girls to keep you entertained");
        extra.setCost(100.00);
        extra.setPic("/image2");

        extraDAO.update(extra);
        Extra extraFromDb = extraDAO.getById(extra.getId());

        assertEquals("Girls", extraFromDb.getLabel());
        assertEquals("Pretty girls to keep you entertained", extraFromDb.getDesc());
        assertEquals(100.00, extraFromDb.getCost(), DELTA);
        assertEquals("/image2", extraFromDb.getPic());
    }

    @Test
    public void testMultipleUserCreation() throws Exception {
        Extra extra = new Extra("Limousine", "Rent a limousine", 150.00, "/image");
        Extra extra2 = new Extra("Girls", "Pretty girls to keep you entertained", 100.00, "/image2");

        extraDAO.create(extra);
        extraDAO.create(extra2);

        assertEquals(2, extraDAO.getAll().size());
    }
}