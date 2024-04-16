module com.example.radio {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires sqlite.jdbc;

    opens com.example.radio to javafx.fxml;
    exports com.example.radio;
}