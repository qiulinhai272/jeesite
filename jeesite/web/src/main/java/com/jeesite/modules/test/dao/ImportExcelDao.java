package com.jeesite.modules.test.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.ImportExcelData;


@MyBatisDao(entity = ImportExcelData.class)
public interface ImportExcelDao extends CrudDao<ImportExcelData> {


}

