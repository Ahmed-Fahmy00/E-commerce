module run.project_ms2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;
    requires fontawesomefx;
    requires java.smartcardio;
    opens run.project_ms2 to javafx.fxml;
    opens Frontend.controllers.admin to javafx.fxml;
    opens Frontend.controllers.product to javafx.fxml;
    opens Frontend.controllers.order to javafx.fxml;
    opens Frontend.controllers.cart to javafx.fxml;
    opens Frontend.controllers.authentication to javafx.fxml;
    opens Frontend.controllers.chat to javafx.fxml;
    opens Backend.entity to javafx.base;
    exports Frontend.controllers.cart;
    exports Frontend.controllers.admin;
    exports Frontend.controllers.product;
    exports Frontend.controllers.authentication;
    exports Frontend.controllers.order;
    exports run.project_ms2;
    exports Frontend.controllers.chat;
    exports Backend.entity;
}
