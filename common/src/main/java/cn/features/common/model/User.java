package cn.features.common.model;

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
public class User  extends Base {

    protected String userName;

    protected String password;

    protected boolean delete;

}
