package example.develop.davidoh.java_android_mvp_example.data;

public class ImageData {
    private String fileName;
    private String name;

    public ImageData(String fileName, String name) {
        this.fileName = fileName;
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
