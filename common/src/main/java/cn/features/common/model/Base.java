package cn.features.common.model;

import lombok.Data;

import java.util.Date;

@Data
public class Base {

    private String id;

    private Date ctime;

    private Date mtime;
}
