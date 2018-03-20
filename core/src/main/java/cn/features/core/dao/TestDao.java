package cn.features.core.dao;

import cn.features.core.model.test;
import org.mapstruct.Mapper;

@Mapper
public interface TestDao {

    test listTest();
}
