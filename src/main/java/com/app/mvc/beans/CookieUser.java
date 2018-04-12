package com.app.mvc.beans;

import lombok.*;

/**
 * Created by Administrator on 2018/4/12.
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CookieUser {

    private Integer userId;
    private String userName;
    private long lastLogin;
    private String ip;
    private String mac;

}
