package com.lhb.service.impl;

import com.lhb.mapper.LogMapper;
import com.lhb.pojo.Log;
import com.lhb.service.LogService;
import com.lhb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class LogServiceImpl implements LogService {
    @Override
    public int ins(Log log) {
        SqlSession session = MyBatisUtil.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        return mapper.ins(log);
    }
}
