package com.aop.springaopdemo.repository;

import com.aop.springaopdemo.aspect.MeasureTime;
import org.springframework.stereotype.Repository;

@Repository
public class Book {

    // check the execution time of this method
    @MeasureTime
    public String getMovieDetails() {
        return "Book Details";
    }
}
