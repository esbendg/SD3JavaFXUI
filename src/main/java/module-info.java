module com.example.sd3javaxd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sd3javaxd to javafx.fxml;
    exports com.example.sd3javaxd;
}