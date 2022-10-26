package com.yaprak.customviewwithjson;

import java.util.ArrayList;

public class CustomViewList {
    public String CustomViewType;
    public String Header;
    public ArrayList<String> Data;

    public String getCustomViewType() {
        return CustomViewType;
    }

    public void setCustomViewType(String customViewType) {
        CustomViewType = customViewType;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public ArrayList<String> getData() {
        return Data;
    }

    public void setData(ArrayList<String> data) {
        Data = data;
    }
}

