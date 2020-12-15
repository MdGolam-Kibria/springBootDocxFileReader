package com;

import org.apache.commons.codec.language.bm.Languages;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTableDocx {
    public static void main(String[] args) throws IOException {

        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\GK\\OneDrive\\Desktop\\officeProject.hwp"));
        /**
         * first create a paragraph as a header
         */

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        run.setText("Person Details\n\n");


        run.setColor("ff0000");

//        document.write(out);
//        out.close();
        System.out.println("create paragraph.docx as a header written successfully");


        //create table
        XWPFTable table = document.createTable();

        //create first row
        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Name");
        tableRowOne.addNewTableCell().setText("Email");
        tableRowOne.addNewTableCell().setText("Password");

        //create second row
        XWPFTableRow tableRowTwo = table.createRow();
        tableRowTwo.getCell(0).setText("Golam Kibria");
        tableRowTwo.getCell(1).setText("golamkibria.java@gmail.com");
        tableRowTwo.getCell(2).setText("myPassword");

        //create third row
        XWPFTableRow tableRowThree = table.createRow();
        tableRowThree.getCell(0).setText("Rabbani");
        tableRowThree.getCell(1).setText("Rabbani@gmail.com");
        tableRowThree.getCell(2).setText("passwordRabbani");

        document.write(out);
        out.close();


        System.out.println("create_table.docx written successfully");


    }
}
