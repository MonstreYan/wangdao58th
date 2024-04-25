package com.cskaoyan.th58.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    private Integer id;
    private Integer userId;
    private String address;
    private String pic;

}
