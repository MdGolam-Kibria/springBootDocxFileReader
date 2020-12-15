package com.devglan;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OfficeFileReader {


    public static void main(String[] args) {
        FileInputStream fis;
        {
            try {
                fis = new FileInputStream("C:\\Users\\GK\\Downloads\\project.docx");
                XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                List<XWPFParagraph> paragraphList = xdoc.getParagraphs();

                List<XWPFPictureData> havePicture = xdoc.getAllPictures();

                if (havePicture.isEmpty()) {
                    System.out.println("sorry you don't have any picture in your file");
                } else {
                    System.out.println("you have" + havePicture.size() + " picture");
                }


                for (XWPFParagraph paragraph : paragraphList) {


                    String paragraphText = paragraph.getParagraphText();
                    System.out.println("ParagraphTextIs = " + paragraphText + "\n\t");

                    String containsText = "Customer Name:";

                    if (paragraphText.contains(containsText)) {
                        int fullLength = paragraphText.length();
                        String objectVal = paragraphText.substring(containsText.length(), fullLength);
                        String mainObject = objectVal.replaceAll("\\s+", "");
                        System.out.println(mainObject);
                        System.out.println("Your previous customer Object Is = " + objectVal);
                        System.out.println("Your Customer Object Is = " + mainObject);




                    }

                    System.out.println(paragraph.getText());
                    System.out.println(paragraph.getAlignment());// LEFT
                    System.out.print(paragraph.getRuns().size());
                    System.out.println(paragraph.getStyle());

                    // Returns numbering format for this paragraph, eg bullet or
                    // lowerLetter.
                    System.out.println(paragraph.getNumFmt());
                    System.out.println(paragraph.getAlignment());// LEFT

                    System.out.println(paragraph.isWordWrapped());

                    System.out.println("********************************************************************");

                }


                System.out.println(paragraphList);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

