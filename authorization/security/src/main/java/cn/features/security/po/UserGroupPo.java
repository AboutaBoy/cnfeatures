package cn.features.security.po;

import cn.features.security.model.UserGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userGroupPo")
@EqualsAndHashCode(callSuper = true)
public class UserGroupPo extends UserGroup {

    private String userId;

}
