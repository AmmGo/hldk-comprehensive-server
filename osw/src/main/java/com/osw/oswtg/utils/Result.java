package com.osw.oswtg.utils;

import lombok.Data;

@Data
public class Result {
    private static final long serialVersionUID = 1L;

    private String key;

    private Object value;

    public Result() {
    }

    public Result(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
