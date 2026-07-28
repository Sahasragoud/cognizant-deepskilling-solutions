package org.javaclaseses;

public class FactoryMethodTest {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.displayDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.displayDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.displayDocument();
    }
}
