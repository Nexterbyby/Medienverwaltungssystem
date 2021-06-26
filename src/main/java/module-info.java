module ch.bbw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;
    requires poi;
    requires poi.ooxml;
    requires poi.ooxml.schemas;

    opens ch.bbw to javafx.fxml;
    opens ch.bbw.Model to org.hibernate.orm.core;
    exports ch.bbw;
}