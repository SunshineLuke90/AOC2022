package Day7;

public class Folder {
    private String name;
    private String path;
    private int size;
    private String[] contents;

    public Folder(String name, String path, int size, String[] contents) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.contents = contents;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getPath() {
        return path;
    }
    public int getSize() {
        return size;
    }
    public String[] getContents() {
        return contents;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setContents(String[] contents) {
        this.contents = contents;
    }
}
