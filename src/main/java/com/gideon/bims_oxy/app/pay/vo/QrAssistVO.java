package com.gideon.bims_oxy.app.pay.vo;

import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

public class QrAssistVO {


    String assistLogin;
    String assistPassword;
    String Merchant_ID ="123";
    String OrderNumber; //주문번호
    String OrderAmount; //주문금액
    String OrderCurrency; //화폐
    String Delay; //1 병렬처리 2 직접처리
    String Language; // RUR,EN
    String Email;
    String OrderComment;
    String URL_RETURN_OK;
    String URL_RETURN_NO;
    String CardPayment;
    String WMPayment;
    String YMPayment;
    String Firstname;
    String Lastname;
    String billnumber;
    String payerdenial;

    String chargedate;
    String chargefee;
    String fcmtoken;
    String targetfcmtoken;
    String targetuserid;
    String CustomerNumber;
    String Signature;

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getChargedate() {
        return chargedate;
    }

    public String getChargefee() {
        return chargefee;
    }

    public String getFcmtoken() {
        return fcmtoken;
    }

    public String getTargetfcmtoken() {
        return targetfcmtoken;
    }

    public String getTargetuserid() {
        return targetuserid;
    }

    public void setChargedate(String chargedate) {
        this.chargedate = chargedate;
    }

    public void setChargefee(String chargefee) {
        this.chargefee = chargefee;
    }

    public void setFcmtoken(String fcmtoken) {
        this.fcmtoken = fcmtoken;
    }

    public void setTargetfcmtoken(String targetfcmtoken) {
        this.targetfcmtoken = targetfcmtoken;
    }

    public void setTargetuserid(String targetuserid) {
        this.targetuserid = targetuserid;
    }

    public String getAssistLogin() {
        return assistLogin;
    }

    public String getAssistPassword() {
        return assistPassword;
    }

    public void setAssistLogin(String assistLogin) {
        this.assistLogin = assistLogin;
    }

    public void setAssistPassword(String assistPassword) {
        this.assistPassword = assistPassword;
    }

    public String getPayerdenial() {
        return payerdenial;
    }

    public void setPayerdenial(String payerdenial) {
        this.payerdenial = payerdenial;
    }

    public String getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(String billnumber) {
        this.billnumber = billnumber;
    }

    public String getDelay() {
        return Delay;
    }

    public String getEmail() {
        return Email;
    }

    public String getMerchant_ID() {
        return Merchant_ID;
    }
    public void setMerchant_ID(String merchant_ID) {
        Merchant_ID = merchant_ID;
    }
    public String getCardPayment() {
        return CardPayment;
    }

    public String getLanguage() {
        return Language;
    }

    public String getOrderAmount() {
        return OrderAmount;
    }

    public String getOrderComment() {
        return OrderComment;
    }

    public String getOrderCurrency() {
        return OrderCurrency;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getURL_RETURN_NO() {
        return URL_RETURN_NO;
    }

    public String getURL_RETURN_OK() {
        return URL_RETURN_OK;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getWMPayment() {
        return WMPayment;
    }

    public String getYMPayment() {
        return YMPayment;
    }

    public void setCardPayment(String cardPayment) {
        CardPayment = cardPayment;
    }

    public void setDelay(String delay) {
        Delay = delay;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setLanguage(String language) {
        Language = language;
    }



    public void setOrderAmount(String orderAmount) {
        OrderAmount = orderAmount;
    }

    public void setOrderCurrency(String orderCurrency) {
        OrderCurrency = orderCurrency;
    }

    public void setOrderComment(String orderComment) {
        OrderComment = orderComment;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public void setURL_RETURN_OK(String URL_RETURN_OK) {
        this.URL_RETURN_OK = URL_RETURN_OK;
    }

    public void setURL_RETURN_NO(String URL_RETURN_NO) {
        this.URL_RETURN_NO = URL_RETURN_NO;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setWMPayment(String WMPayment) {
        this.WMPayment = WMPayment;
    }

    public void setYMPayment(String YMPayment) {
        this.YMPayment = YMPayment;
    }
}
