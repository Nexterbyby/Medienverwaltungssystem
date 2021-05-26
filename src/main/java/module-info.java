module ch.bbw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;

    opens ch.bbw to javafx.fxml;
    exports ch.bbw;
}