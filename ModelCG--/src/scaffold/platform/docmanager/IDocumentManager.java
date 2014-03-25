package scaffold.platform.docmanager;

import scaffold.platform.docviewer.IDocumentViewer;
import scaffold.platform.fileexplorer.FileExplorer;

import javax.swing.JComponent;


public interface IDocumentManager {
    String VIEW_NAME_START = "Start";
    String VIEW_NAME_GRAPHICAL_MODEL = "Graphical Model";
    String VIEW_NAME_TEMPLATES = "Templates";
    String VIEW_NAME_GENERATED_CODE = "Generated Code";
    String VIEW_NAME_LOGS = "Logs";

    void initialize(); // call this AFTER adding explorers and viewers

    JComponent getExplorerComponent();
    JComponent getTabbedDocumentComponent();

    void setCurrentViewerByName(String name);
    IDocumentViewer getCurrentViewer();

    FileExplorer addExplorerByName(String name, FileExplorer explorer);
    FileExplorer getExplorerByName(String name);
    IDocumentViewer addViewerByName(String name, IDocumentViewer docViewer);
    IDocumentViewer getViewerByName(String name);

    //void openMostRecentFiles();

    void refreshDirectories();
    void saveAllChanges(boolean confirm);
    void newFile(String fileName);
    void openFile(String fileName);
    void saveFile();
    void saveFileAs(String newFileName);
}
