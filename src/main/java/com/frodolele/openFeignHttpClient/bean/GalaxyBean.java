package com.frodolele.openFeignHttpClient.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GalaxyBean implements Serializable {
    private static final Long serialVersionUID = 1L;


    private int id;
    private String name;
    private String tag;
}
