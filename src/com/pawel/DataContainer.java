package com.pawel;

import java.util.List;
import java.util.stream.Collectors;

public class DataContainer {

    private List<String> dataList;

    public DataContainer() {

    }

    public DataContainer(List<String> dataList) {

        this.dataList = dataList;
    }

    void load(DataProvider dataProvider) {  //like Setter

        this.dataList = dataProvider.getAll();

    }

    void add(String item)   {

         dataList.add(item);

    }

    void update(int id, String item) {

         dataList.set(id, item);

    }

    String findById(int id)  {

        return dataList.get(id);

    }

    void remove(int id)  {

        dataList.remove(id);

    }

    void printAll() {   //like Getter

        for (String s: dataList ) {
            System.out.println(s);
        }
    }

    void print(int from, int to)    {

        for(int i = from; i < to; i++)  {
            System.out.println(findById(i));
        }

    }

    void clear()    {

         dataList.clear();

    }

    List<String> get(int from, int to)  {

        System.out.println("DataContainer.get(from = " + from + ", to = " + to + ")");
        return dataList.subList(from, to);

    }

    List<String> filter(String filter)   {

        System.out.println("DataContainer.filter( filter = " + filter + ")");

        return dataList.stream()
                .filter(line -> !filter.equals(line))
                .collect(Collectors.toList());

    }

    public List<String> getDataList() {
        return dataList;
    }
}
