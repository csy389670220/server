package com.cfets.cms.mapper;

import com.cfets.cms.model.SuccessSkill;

public interface SuccessSkillMapper {

    int insert(SuccessSkill record);

    int insertSelective(SuccessSkill record);

    int updateByPrimaryKeySelective(SuccessSkill record);

    int updateByPrimaryKey(SuccessSkill record);

    /**
     * 查询指定用户是否有指定秒杀记录
     * @param record  用户ID+秒杀活动ID
     * @return
     */
    int selectNumByUserId(SuccessSkill record);
}