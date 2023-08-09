package com.aop.springaopdemo.service;

import com.aop.springaopdemo.aspect.MeasureTime;
import com.aop.springaopdemo.repository.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilteringTechnique1 {

    @Autowired
    private Book book;

    // check the execution time of this method
    @MeasureTime
    public String contentBasedFiltering() {
        return book.getMovieDetails();
    }
}
