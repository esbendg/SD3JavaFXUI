module com.example.sd3javafxui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.sd3javafxui to javafx.fxml;
    exports com.example.sd3javafxui;
}