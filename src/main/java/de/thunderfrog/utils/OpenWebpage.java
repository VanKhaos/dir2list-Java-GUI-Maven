package de.thunderfrog.utils;

import java.awt.*;
import java.net.URI;

public class OpenWebpage {

    public static void gotoPage(String url) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(URI.create(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
