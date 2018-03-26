package cn.features.security.model;

import cn.features.common.model.Base;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * 用户组
 *
 * @author limouren
 */
@Data
@Alias("userGroup")
@EqualsAndHashCode(callSuper = true)
public class UserGroup extends Base {

    private String groupName;

    private String parentId;

}
