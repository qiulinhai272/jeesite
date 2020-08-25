package com.jeesite.modules.test.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.ParseExcel;

@MyBatisDao(entity = ParseExcel.class)
public interface ParseExcelDao extends CrudDao<ParseExcel> {
}
