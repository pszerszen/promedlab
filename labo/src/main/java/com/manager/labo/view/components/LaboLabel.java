package com.manager.labo.view.components;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class LaboLabel extends JLabel {

    private static final long serialVersionUID = 1648289704373765710L;

    private static final Font LABEL_FONT = new Font("Calibri", Font.PLAIN, 14);

    public LaboLabel() {
        super();
        setFont(LABEL_FONT);
    }

    public LaboLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        setFont(LABEL_FONT);
    }

    public LaboLabel(Icon image) {
        super(image);
        setFont(LABEL_FONT);
    }

    public LaboLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        setFont(LABEL_FONT);
    }

    public LaboLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setFont(LABEL_FONT);
    }

    public LaboLabel(String text) {
        super(text);
        setFont(LABEL_FONT);
    }

}
