package cn.features.security.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 用户
 *
 * @author limouren
 */
@Data
@Alias("user")
public class User {

    private String id;

    private String userName;

    private String password;

}
