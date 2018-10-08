package com.hanhan.test1.dao.mapperJava1;

import com.hanhan.test1.dto.ModuleRole;
import com.hanhan.test1.dto.ModuleRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleRoleMapper {
    int countByExample(ModuleRoleExample example);

    int deleteByExample(ModuleRoleExample example);

    int insert(ModuleRole record);

    int insertSelective(ModuleRole record);

    List<ModuleRole> selectByExample(ModuleRoleExample example);

    int updateByExampleSelective(@Param("record") ModuleRole record, @Param("example") ModuleRoleExample example);

    int updateByExample(@Param("record") ModuleRole record, @Param("example") ModuleRoleExample example);
}