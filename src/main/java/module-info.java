module ch.bbw {
    requires javafx.controls;
    requires javafx.fxml;

    opens ch.bbw to javafx.fxml;
    exports ch.bbw;
}