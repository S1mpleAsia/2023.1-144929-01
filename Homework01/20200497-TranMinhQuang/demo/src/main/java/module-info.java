module com.example.demo {
    requires java.desktop;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}