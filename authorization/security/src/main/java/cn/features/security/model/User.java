package cn.features.security.model;

import cn.features.common.model.Base;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * 用户
 *
 * @author limouren
 */
@Data
@Alias("user")
@EqualsAndHashCode(callSuper = true)
public class User extends Base {

    private String userName;

    private String password;

}
