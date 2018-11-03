package com.pawel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.toIntExact;

public class DataProviderCSV implements DataProvider {

    public DataProviderCSV() {

    }

    @Override
    public int count() {

        String fileName = "file.csv";
        int counter = 0;

        try ( Stream<String> stream = Files.lines(Paths.get(fileName)) ) {
            counter = toIntExact(stream.count());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return counter;
    }

    @Override
    public List<String> get(int pageNumber, int count) {

        String fileName = "file.csv";
        List<String> list = new ArrayList<>();

        try ( Stream<String> stream = Files.lines(Paths.get(fileName)) ) {

            list = stream
                    .skip(pageNumber*PAGE_LINES_NO)
                    .limit(count)
                    .collect(Collectors.toList());

            list.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public List<String> getAll() {

        String fileName = "file.csv";
        List<String> list = new ArrayList<>();

        try ( Stream<String> stream = Files.lines(Paths.get(fileName)) ) {

            list = stream
                     .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }

}
