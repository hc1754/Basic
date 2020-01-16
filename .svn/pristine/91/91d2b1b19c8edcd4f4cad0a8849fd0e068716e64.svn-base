<%--
  Created by IntelliJ IDEA.
  User: aaa
  Date: 2019-04-05
  Time: 오후 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    <!--
    window.onload = function() {
        document.getElementById('orderForm').submit();
    };
    //-->
</script>

<FORM ACTION="https://payments.paysecure.ru/pay/order.cfm" METHOD="POST" id="orderForm">

    <INPUT TYPE="hidden" NAME="Merchant_ID" VALUE="${assistOrderObject.merchant_ID}">
    <INPUT TYPE="hidden" NAME="OrderNumber" VALUE="${assistOrderObject.orderNumber}">
    <INPUT TYPE="hidden" NAME="OrderAmount" VALUE="${assistOrderObject.orderAmount}">
    <INPUT TYPE="hidden" NAME="OrderCurrency" VALUE="${assistOrderObject.orderCurrency}">
    <INPUT TYPE="hidden" NAME="Delay" VALUE="${assistOrderObject.delay}">
    <INPUT TYPE="hidden" NAME="Language" VALUE="${assistOrderObject.language}">
    <INPUT TYPE="hidden" NAME="Email" VALUE="${assistOrderObject.email}">
    <INPUT TYPE="hidden" NAME="OrderComment" VALUE="${assistOrderObject.orderComment}">
    <%--<li><label>URL_RETURN_OK</label><INPUT TYPE="text" NAME="URL_RETURN_OK" VALUE="http://bigcorea.maru.net/test.php"></li>--%>
    <%--<li><label>URL_RETURN_NO</label><INPUT TYPE="text" NAME="URL_RETURN_NO" VALUE="http://bigcorea.maru.net/test.php"></li>--%>
    <INPUT TYPE="hidden" NAME="CardPayment" VALUE="${assistOrderObject.cardPayment}">
    <INPUT TYPE="hidden" NAME="WMPayment" VALUE="${assistOrderObject.WMPayment}">
    <INPUT TYPE="hidden" NAME="YMPayment" VALUE="${assistOrderObject.YMPayment}">
    <INPUT TYPE="hidden" NAME="Firstname" VALUE="${assistOrderObject.firstname}">
    <INPUT TYPE="hidden" NAME="Lastname" VALUE="${assistOrderObject.lastname}">
    <INPUT TYPE="hidden" NAME="CustomerNumber" VALUE="${assistOrderObject.customerNumber}">
    <INPUT TYPE="hidden" NAME="Signature" VALUE="${assistOrderObject.signature}">
    <INPUT TYPE="hidden" NAME="MobileDevice" VALUE="2">

</FORM>
