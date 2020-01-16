package com.gideon.bims_oxy.app.pay.model;

import com.gideon.bims_oxy.app.pay.vo.ChrgPlcyVO;
import com.gideon.bims_oxy.app.pay.vo.MsgMultilangVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class QrRestConfigDAO {
    @Autowired
    private SqlSession sql;
    public List<MsgMultilangVO> selectMsgMultiLangInfo(Map<String, String> params) throws SQLException {
        List<MsgMultilangVO> selectMsgMultiLangInfo= sql.selectList("app.pay.qrRestConfigMapper.selectMsgMultiLangInfo", params);
        return selectMsgMultiLangInfo;
    }

    public List<ChrgPlcyVO>   selectChrgPlcyInfo() throws SQLException {
        List<ChrgPlcyVO>  selectChrgPlcyInfo= sql.selectList("app.pay.qrRestConfigMapper.selectChrgPlcyInfo");
        return selectChrgPlcyInfo;
    }
    public Integer  selectQrRestConfig() throws SQLException {
        Integer  selectQrRestConfig= sql.selectOne("app.pay.qrRestConfigMapper.selectQrRestConfig");
        return selectQrRestConfig;
    }
    //
    public Integer  qrCrtCountLimit() throws SQLException {
        Integer  qrCrtCountLimit= sql.selectOne("app.pay.qrRestConfigMapper.qrCrtCountLimit");
        return qrCrtCountLimit;
    }
    public Integer  trcnPrmtInfo() throws SQLException {
        Integer  trcnPrmtInfo= sql.selectOne("app.pay.qrRestConfigMapper.trcnPrmtInfo");
        return trcnPrmtInfo;
    }
    //qrCrtCountLimit trcnPrmtInfo
}
