package com.pawel;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DataContainerTest {

    private DataContainer dataContainer;

    @Before
    public void setup() {
        dataContainer = new DataContainer(new LinkedList<String>(Arrays.asList("1;France;Paris", "2;Poland;Warsaw", "3;USA;Washington")));

        System.out.println("Running a test...");
    }


    @Test
    public void load() {
        DataProvider dataProviderCSV = new DataProviderCSV();
        dataContainer.load(dataProviderCSV);
        assertEquals(dataProviderCSV.getAll(),dataContainer.get(0, dataProviderCSV.count()));
    }

    @Test
    public void add() {
        dataContainer.add("4;UK;London");
        assertThat(dataContainer.findById(3), is("4;UK;London"));
    }

    @Test
    public void update() {
        dataContainer.update(1, "2;UK;London");
        assertEquals("2;UK;London", dataContainer.findById(1));
    }

    @Test
    public void findById() {
        assertThat(dataContainer.findById(2), is("3;USA;Washington"));
    }

    @Test
    public void remove() {
        dataContainer.remove(1);
        assertNotEquals("2;Poland;Warsaw", dataContainer.findById(1));
        System.out.println(dataContainer.findById(1));
    }

    @Test
    public void printAll() {

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        dataContainer.printAll();

        String expectedString = "";

        for(String s : dataContainer.getDataList())   {
            expectedString += s + System.getProperty("line.separator");
        }

        assertEquals(expectedString, outputStream.toString());

        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    @Test
    public void print() {

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        dataContainer.print(0,1);

        assertEquals(dataContainer.findById(0) + System.getProperty("line.separator"), outputStream.toString());

        PrintStream originalOut = System.out;
        System.setOut(originalOut);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void clear() {
        dataContainer.clear();
        dataContainer.findById(0);
    }

    @Test
    public void get() {
        assertThat(dataContainer.get(1,3), hasItems("2;Poland;Warsaw", "3;USA;Washington"));
    }

    @Test
    public void filter() {
        assertThat(dataContainer.filter("2;Poland;Warsaw"), not(hasItem("2;Poland;Warsaw")));
    }
}