package com.xi.notification.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2755947149946454969L;
    private Long id;

    private String name;
}

