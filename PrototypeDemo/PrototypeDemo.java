class Document implements Cloneable {
    private String title;
    private String content;

    // Constructor
    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Clone method (deep copy)
    @Override
    public Document clone() {
        try {
            return (Document) super.clone(); // Shallow copy (fine for immutable fields like String)
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    // Display document details
    public void showDetails() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("-------------------------");
    }
}

public class PrototypeDemo {
    public static void main(String[] args) {
        // Original Document
        Document originalDoc = new Document("Report", "This is the original content.");
        System.out.println("Original Document:");
        originalDoc.showDetails();

        // Clone the Document
        Document clonedDoc = originalDoc.clone();
        clonedDoc.setTitle("Cloned Report");
        clonedDoc.setContent("This is the modified content of the clone.");

        // Show both to verify they are independent
        System.out.println("After Cloning and Modifying:");
        System.out.println("Original Document:");
        originalDoc.showDetails();

        System.out.println("Cloned Document:");
        clonedDoc.showDetails();
    }
}