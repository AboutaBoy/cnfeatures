package cn.features.common.po;

import cn.features.common.model.UserGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userGroupPo")
@EqualsAndHashCode(callSuper = true)
public class UserGroupPo extends UserGroup {

    private String userId;

}
