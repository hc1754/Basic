package com.gideon.bims_oxy.app.pay.vo;

import java.math.BigDecimal;


public class QrBusPayVO {
    String paymtDt;                     //
    String userId;					    //VARCHAR2	20	QR 사용자 ID
    String areaCd;						//CHAR		2	지역 코드
    String trdTypeCd;	 				//CHAR		1	거래 유형 코드
    String transProvId;				    //VARCHAR2	9	교통 사업자 ID
    String brnchId;					    //VARCHAR2	2	영업소 ID
    String busId;						//VARCHAR2	9	버스 ID
    String termnId;					    //VARCHAR2	10	단말기 ID
    String rotId;						//VARCHAR2	9	노선 ID
    String drvId;						//VARCHAR2	9	운전자 ID
    String busstId;					    //VARCHAR2	9	버스정류장 ID
    String oprnDt;						//DATE		7	운행 일시
    String getonoffDistc;				//CHAR		1	승하차 구분
    BigDecimal amt;						//NUMBER	22	금액
    BigDecimal bal;						//NUMBER	22	잔액
    String qrCrtDt;					    //DATE		7	QR 생성 일시
    BigDecimal longitude;				//NUMBER	22	경도
    BigDecimal latitude;				//NUMBER	22	위도
    String dedln_yn;					//CHAR		1	마감 여부
    String reg_dt;						//DATE		7	등록 일시

    public String getPaymtDt() {
        return paymtDt;
    }

    public String getAreaCd() {
        return areaCd;
    }

    public String getBrnchId() {
        return brnchId;
    }

    public String getBusId() {
        return busId;
    }

    public String getTermnId() {
        return termnId;
    }

    public String getTransProvId() {
        return transProvId;
    }

    public String getDrvId() {
        return drvId;
    }

    public String getRotId() {
        return rotId;
    }

    public String getBusstId() {
        return busstId;
    }

    public String getTrdTypeCd() {
        return trdTypeCd;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public BigDecimal getBal() {
        return bal;
    }

    public String getOprnDt() {
        return oprnDt;
    }

    public String getGetonoffDistc() {
        return getonoffDistc;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public String getDedln_yn() {
        return dedln_yn;
    }

    public String getQrCrtDt() {
        return qrCrtDt;
    }

    public String getReg_dt() {
        return reg_dt;
    }

    public void setPaymtDt(String paymtDt) {
        this.paymtDt = paymtDt;
    }

    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    public void setBrnchId(String brnchId) {
        this.brnchId = brnchId;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setBal(BigDecimal bal) {
        this.bal = bal;
    }

    public void setBusstId(String busstId) {
        this.busstId = busstId;
    }

    public void setDrvId(String drvId) {
        this.drvId = drvId;
    }

    public void setGetonoffDistc(String getonoffDistc) {
        this.getonoffDistc = getonoffDistc;
    }

    public void setOprnDt(String oprnDt) {
        this.oprnDt = oprnDt;
    }

    public void setRotId(String rotId) {
        this.rotId = rotId;
    }

    public void setTermnId(String termnId) {
        this.termnId = termnId;
    }

    public void setTransProvId(String transProvId) {
        this.transProvId = transProvId;
    }

    public void setQrCrtDt(String qrCrtDt) {
        this.qrCrtDt = qrCrtDt;
    }

    public void setTrdTypeCd(String trdTypeCd) {
        this.trdTypeCd = trdTypeCd;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDedln_yn(String dedln_yn) {
        this.dedln_yn = dedln_yn;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setReg_dt(String reg_dt) {
        this.reg_dt = reg_dt;
    }

}
