package com.example.administrator.newpos;

/**
 * 交易记录实体类
 * <p>
 * Created by kun on 2017/6/12.
 * e-mail : 542191220@qq.com
 * version : $
 * transMsg	提示信息	String
 merchantNo	商户编号	String
 terminalNo	终端编号	String
 merchantName	商户名	String
 operNo	操作员号	String
 traceNo	凭证号/交易流水号	String
 refNo	参考号	String
 authNo	授权码	String
 expDate	卡片有效期	String
 cardNo	卡号	String
 cardIssuerCode 	发卡行	String
 cardAcquirerCode	收单行	String
 cardInputType 	刷卡方式	String
 payWay	支付方式	String
 payNo	扫码支付订单号	String
 date 	日期	String
 time	时间	String
 ARQC		String
 TVR		String
 AID		String
 TSI		String
 APPLAB 		String
 APPName		String
 UNPR_NUM 		String
 AIP 		String
 IAD 		String
 TermCap 		String

 */

public class TradeRecord {

    private String transMsg;//提示信息
    private String merchantNo;//商户编号
    private String terminalNo; //终端编号
    private String merchantName; //商户名
    private String operNo; //操作员号
    private String traceNo; //凭证号/交易流水号
    private String refNo;//参考号
    private String authNo;//授权码
    private String expDate;//卡片有效期
    private String cardNo;//卡号
    private String cardIssuerCode;//发卡行
    private String cardAcquirerCode;//收单行
    private String cardInputType;//刷卡方式
    private String payWay;//支付方式
    private String payNo;//扫码支付订单号
    private String date;//日期
    private String time;//时间
    private String ARQC;//接收机构代码
    private String TVR;//终端交易时间
    private String AID;//终端流水号
    private String TSI;//请求报文mac
    private String APPLAB;//请求报文mac
    private String APPName;//请求报文mac
    private String UNPR_NUM;//请求报文mac
    private String AIP;//请求报文mac
    private String IAD;//请求报文mac
    private String TermCap;//请求报文mac

    public String getTransMsg() {
        return transMsg;
    }

    public void setTransMsg(String transMsg) {
        this.transMsg = transMsg;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getAuthNo() {
        return authNo;
    }

    public void setAuthNo(String authNo) {
        this.authNo = authNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardIssuerCode() {
        return cardIssuerCode;
    }

    public void setCardIssuerCode(String cardIssuerCode) {
        this.cardIssuerCode = cardIssuerCode;
    }

    public String getCardAcquirerCode() {
        return cardAcquirerCode;
    }

    public void setCardAcquirerCode(String cardAcquirerCode) {
        this.cardAcquirerCode = cardAcquirerCode;
    }

    public String getCardInputType() {
        return cardInputType;
    }

    public void setCardInputType(String cardInputType) {
        this.cardInputType = cardInputType;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getARQC() {
        return ARQC;
    }

    public void setARQC(String ARQC) {
        this.ARQC = ARQC;
    }

    public String getTVR() {
        return TVR;
    }

    public void setTVR(String TVR) {
        this.TVR = TVR;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public String getTSI() {
        return TSI;
    }

    public void setTSI(String TSI) {
        this.TSI = TSI;
    }

    public String getAPPLAB() {
        return APPLAB;
    }

    public void setAPPLAB(String APPLAB) {
        this.APPLAB = APPLAB;
    }

    public String getAPPName() {
        return APPName;
    }

    public void setAPPName(String APPName) {
        this.APPName = APPName;
    }

    public String getUNPR_NUM() {
        return UNPR_NUM;
    }

    public void setUNPR_NUM(String UNPR_NUM) {
        this.UNPR_NUM = UNPR_NUM;
    }

    public String getAIP() {
        return AIP;
    }

    public void setAIP(String AIP) {
        this.AIP = AIP;
    }

    public String getIAD() {
        return IAD;
    }

    public void setIAD(String IAD) {
        this.IAD = IAD;
    }

    public String getTermCap() {
        return TermCap;
    }

    public void setTermCap(String termCap) {
        TermCap = termCap;
    }

    @Override public String toString() {
        return "TradeRecord{"
            + "transMsg='"
            + transMsg
            + '\''
            + ", merchantNo='"
            + merchantNo
            + '\''
            + ", terminalNo='"
            + terminalNo
            + '\''
            + ", merchantName='"
            + merchantName
            + '\''
            + ", operNo='"
            + operNo
            + '\''
            + ", traceNo='"
            + traceNo
            + '\''
            + ", refNo='"
            + refNo
            + '\''
            + ", authNo='"
            + authNo
            + '\''
            + ", expDate='"
            + expDate
            + '\''
            + ", cardNo='"
            + cardNo
            + '\''
            + ", cardIssuerCode='"
            + cardIssuerCode
            + '\''
            + ", cardAcquirerCode='"
            + cardAcquirerCode
            + '\''
            + ", cardInputType='"
            + cardInputType
            + '\''
            + ", payWay='"
            + payWay
            + '\''
            + ", payNo='"
            + payNo
            + '\''
            + ", date='"
            + date
            + '\''
            + ", time='"
            + time
            + '\''
            + ", ARQC='"
            + ARQC
            + '\''
            + ", TVR='"
            + TVR
            + '\''
            + ", AID='"
            + AID
            + '\''
            + ", TSI='"
            + TSI
            + '\''
            + ", APPLAB='"
            + APPLAB
            + '\''
            + ", APPName='"
            + APPName
            + '\''
            + ", UNPR_NUM='"
            + UNPR_NUM
            + '\''
            + ", AIP='"
            + AIP
            + '\''
            + ", IAD='"
            + IAD
            + '\''
            + ", TermCap='"
            + TermCap
            + '\''
            + '}';
    }
}
