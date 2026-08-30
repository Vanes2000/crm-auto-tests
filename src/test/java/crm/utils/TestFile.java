package crm.utils;

public enum TestFile {

    JPG("TestFile/file.jpg"),
    TXT("TestFile/file.txt"),
    PDF("TestFile/file.pdf"),
    XLSX("TestFile/file.xlsx"),
    XLS("TestFile/file.xls"),
    DOCX("TestFile/file.docx"),
    DOC("TestFile/file.doc"),
    CSV("TestFile/file.csv");

    private final String pathFile;

    TestFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getPathFile() {
        return pathFile;
    }
}
