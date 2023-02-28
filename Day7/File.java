package Day7;

public class File {
    private String name;
    private String path;
    private int size;

    public File(String name, String path, int size) {
        this.name = name;
        this.path = path;
        this.size = size;
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
    
}
