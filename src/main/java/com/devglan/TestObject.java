package com.devglan;

public class TestObject {
    private String date;
    private String InvoiceNo;
    private String totalAmount;
    private String paid;

    public TestObject(String date, String invoiceNo, String totalAmount, String paid) {
        this.date = date;
        InvoiceNo = invoiceNo;
        this.totalAmount = totalAmount;
        this.paid = paid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        InvoiceNo = invoiceNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
