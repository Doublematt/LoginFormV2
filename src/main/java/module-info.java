module com.example.loginform {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.loginform to javafx.fxml;
    exports com.example.loginform;
}