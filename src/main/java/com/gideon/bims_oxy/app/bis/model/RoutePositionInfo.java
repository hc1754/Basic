package com.gideon.bims_oxy.app.bis.model;

import java.math.BigDecimal;

public class RoutePositionInfo {
    
    private BigDecimal crdnSeq;
    private BigDecimal longitude;
    private BigDecimal latitude; 
    private String busSectorId;
    private String busInfoUnitId;
    private BigDecimal busInfoUnitSeq;
    
    private BigDecimal sectorSeq;

    public BigDecimal getCrdnSeq() {
        return crdnSeq;
    }

    public void setCrdnSeq(BigDecimal crdnSeq) {
        this.crdnSeq = crdnSeq;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getBusSectorId() {
        return busSectorId;
    }

    public void setBusSectorId(String busSectorId) {
        this.busSectorId = busSectorId;
    }

    public String getBusInfoUnitId() {
        return busInfoUnitId;
    }

    public void setBusInfoUnitId(String busInfoUnitId) {
        this.busInfoUnitId = busInfoUnitId;
    }

    public BigDecimal getBusInfoUnitSeq() {
        return busInfoUnitSeq;
    }

    public void setBusInfoUnitSeq(BigDecimal busInfoUnitSeq) {
        this.busInfoUnitSeq = busInfoUnitSeq;
    }

    public BigDecimal getSectorSeq() {
        return sectorSeq;
    }

    public void setSectorSeq(BigDecimal sectorSeq) {
        this.sectorSeq = sectorSeq;
    }
    
}
