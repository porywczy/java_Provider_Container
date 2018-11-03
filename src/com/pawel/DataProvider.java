package com.pawel;

import java.util.List;

public interface DataProvider {

    final int PAGE_LINES_NO = 2;

    int count();

    List<String> get(int page, int count);

    List<String> getAll();

}
