package com.university.specificData.Sorters;
import java.util.List;

public interface Sortable <T>{
    void sort(List<T> items);

    List<T> getOrderedItems();
}
