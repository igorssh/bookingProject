package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Extra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExtraDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private ExtraDAO extraDAO = new ExtraDAOImpl();

    private static final double DELTA = 1e-3;

    @Before
    public void setUp() throws Exception {
        databaseCleaner.cleanDatabase();
    }

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

        assertEquals(extraDAO.getAll().size(), 1);

        extraDAO.delete(extra.getId());

        assertEquals(extraDAO.getAll().size(), 0);
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

        assertEquals(extraDAO.getAll().size(), 2);
    }
}