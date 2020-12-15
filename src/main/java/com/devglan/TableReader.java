package com.devglan;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class TableReader {

    public static void main(String[] args) {

        int a = 0;

        List<TestObject> testObjectList = new ArrayList<>();
        String date = null;
        String invoiceNo = null;
        String totalAmount = null;
        String paid = null;
        TestObject testObject = null;



        String dates = null;
        String invoiceNoo = null;
        String totalAmountt = null;
        String paidd = null;

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\GK\\Downloads\\project.docx");
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            Iterator<IBodyElement> bodyElementIterator = xdoc.getBodyElementsIterator();
            while (bodyElementIterator.hasNext()) {
                IBodyElement element = bodyElementIterator.next();

                if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
                    List<XWPFTable> tableList = element.getBody().getTables();
                    for (XWPFTable table : tableList) {
                        System.out.println("Total Number of Rows of Table:" + table.getNumberOfRows());
                        for (int i = 0; i < table.getRows().size(); i++) {


                            System.out.println(table.getRows().size());

                            for (int j = 0; j < table.getRow(i).getTableCells().size(); j++) {
                                System.out.println(table.getRow(i).getCell(j).getText());

                                if (i > 0) {
                                    a+=1;



                                    if (j == 0) {
                                        dates = table.getRow(i).getCell(j).getText();
                                    }
                                    if (j == 1) {
                                        invoiceNoo = table.getRow(i).getCell(j).getText();
                                    }
                                    if (j == 2) {
                                        totalAmountt = table.getRow(i).getCell(j).getText();
                                    }
                                    if (j == 3) {
                                        paidd = table.getRow(i).getCell(j).getText();
                                    }

                                    if (a==4){
                                        a=0;
                                        TestObject testObject1 = new TestObject(dates, invoiceNoo, totalAmountt, paidd);
                                        testObjectList.add(testObject1);
                                    }


                                }


                                //header
                                if (i == 0 && table.getRows().size() == 5) {
                                    if (j == 0) {
                                        date = table.getRow(i).getCell(j).getText();
                                    }
                                    if (j == 1) {
                                        invoiceNo = table.getRow(i).getCell(j).getText();
                                    }
                                    if (j == 2) {
                                        totalAmount = table.getRow(i).getCell(j).getText();
                                    }
                                    if (j == 3) {
                                        paid = table.getRow(i).getCell(j).getText();
                                    }
                                    //TestObject testObject = new TestObject(table.getRow(i).getCell(j).getText().toString())
                                }
                                if (date!=null&& invoiceNo!=null&&totalAmount!=null&&paid!=null){
                                    testObject  = new TestObject(date,invoiceNo,totalAmount,paid);
                                }

                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("header = "+testObject.getDate());
            System.out.println("header = "+testObject.getInvoiceNo());
            System.out.println("header = "+testObject.getTotalAmount());
            System.out.println("header = "+testObject.getPaid());

            System.out.println(String.valueOf(testObjectList.size()));
            System.out.println(String.valueOf(testObjectList.get(1).getPaid()));

            Gson gson =new Gson();
            System.out.println(
                    gson.toJson(testObjectList)
            );
        }
    }
}
