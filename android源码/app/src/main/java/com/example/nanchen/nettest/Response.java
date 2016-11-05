package com.example.nanchen.nettest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author nanchen
 * @fileName NetTest
 * @packageName com.example.nanchen.nettest
 * @date 2016/11/05  15:17
 */

public class Response {
    @SerializedName("status")
    public boolean status;
    public String message;
    public List<User> data;
}
