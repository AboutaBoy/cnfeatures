package cn.features.core.model;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("test")
public class test {
    private String id;
    private String name;
}
