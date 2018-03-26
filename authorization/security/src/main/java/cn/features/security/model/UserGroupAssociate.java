package cn.features.security.model;

import cn.features.common.model.Base;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userGroupAssociate")
@EqualsAndHashCode(callSuper = true)
public class UserGroupAssociate extends Base {

    private String userId;

    private String groupId;

}
