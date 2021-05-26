module ch.bbw {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.persistence;

    opens ch.bbw to javafx.fxml;
    exports ch.bbw;
}