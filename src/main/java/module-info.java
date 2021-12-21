module com.edugrade.heartbeat {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.naming;

    opens com.edugrade.heartbeat.Controller;
    opens com.edugrade.heartbeat.Model;

    exports com.edugrade.heartbeat.Main;
    opens com.edugrade.heartbeat.Main to javafx.fxml;
}