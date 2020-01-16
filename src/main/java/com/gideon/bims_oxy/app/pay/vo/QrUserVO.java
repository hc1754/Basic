package com.gideon.bims_oxy.app.pay.vo;

public class QrUserVO {
    String usrId;
    String usrEmail;
    String email;
    String phone;

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }
}
