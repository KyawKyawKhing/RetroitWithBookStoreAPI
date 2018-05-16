package com.kokutha.kcube.retrifitsample.model;

import java.util.ArrayList;

/**
 * Created by K Cube on 5/15/2018.
 */

public class ResultModel {
    private int status;
    private String message;
    private ArrayList<BookModel> book;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<BookModel> getBook() {
        return book;
    }
}
