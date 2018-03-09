package com.app.mvc.acl.po;

import lombok.*;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/9.
 */

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User  implements  java.io.Serializable{

    private Integer userId;
    private String userName;
    private String encryptedFoundationPassword;
    private String encryptedUserPassword;
    private String description;
    private Date creationDate;
    private Date lastLoginDate;


}
