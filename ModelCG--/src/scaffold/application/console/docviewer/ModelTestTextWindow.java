package scaffold.application.console.docviewer;

import scaffold.platform.docviewer.TextDocumentViewer;

import javax.swing.*;
import java.awt.*;

public class ModelTestTextWindow extends JFrame {
    public ModelTestTextWindow() {
        super("Model Test Data");
        viewer = new TextDocumentViewer(null);
        add(viewer.getComponent());

        setPreferredSize(new Dimension(400, 300));
        pack();
    }

    public TextDocumentViewer getDocumentViewer() {
        return this.viewer;
    }

    private TextDocumentViewer viewer;
}
