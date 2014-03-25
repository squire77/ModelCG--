package scaffold.platform.docviewer;

import javax.swing.JComponent;
import java.awt.Dimension;


abstract public class DocumentViewer implements IDocumentViewer {
    public static final String DEFAULT_NEW_FILENAME = "<New File>";
    
    public DocumentViewer(String directoryAbsolutePath) {
        this.hasChanged = false;
        this.fileNameAbsolutePath = DEFAULT_NEW_FILENAME;
        this.directoryAbsolutePath = directoryAbsolutePath;
    }
    
    public void reset() {
        this.hasChanged = false;
        this.fileNameAbsolutePath = DEFAULT_NEW_FILENAME;
    }

    @Override
    abstract public void setPreferredSize(Dimension d);
    @Override
    abstract public JComponent getComponent();

    @Override
    public boolean hasChanged() {
        return this.hasChanged;
    }

    @Override
    public String getDocumentTitle() {
        return (this.hasChanged) ? this.getShortFileName() + " *" : this.getShortFileName();
    }

    @Override
    public String getShortFileName() {
        return (this.fileNameAbsolutePath.contains(".") ?
                    this.fileNameAbsolutePath.substring(this.fileNameAbsolutePath.lastIndexOf('.') + 1)
                    : this.fileNameAbsolutePath);
    }

    @Override
    public String getFileNameAbsolutePath() {
        return this.fileNameAbsolutePath;
    }

    @Override
    public String getDirectoryAbsolutePath() {
        return this.directoryAbsolutePath;
    }

    @Override
    public void newFile(String fileNameAbsolutePath) {
        doNewFile(fileNameAbsolutePath);
        setFileName(fileNameAbsolutePath); //change fileName AFTER successful new
    }
    
    @Override
    public void openFile(String fileNameAbsolutePath) {
        doOpenFile(fileNameAbsolutePath);
        setFileName(fileNameAbsolutePath); //change fileName AFTER successful open
    }
    @Override
    public void saveAsFile(String fileNameAbsolutePath) {
        doSaveAsFile(fileNameAbsolutePath);
        setFileName(fileNameAbsolutePath); //change fileName AFTER successful save
        this.hasChanged = false;
    }
    @Override
    public void saveFile() {
        saveAsFile(fileNameAbsolutePath);
    }

    abstract public void doNewFile(String fileNameAbsolutePath);
    abstract public void doOpenFile(String fileNameAbsolutePath);
    abstract public void doSaveAsFile(String fileNameAbsolutePath);

    protected void setFileName(String fileNameAbsolutePath) {
        this.fileNameAbsolutePath = fileNameAbsolutePath;
    }

    protected boolean       hasChanged;

    private String          fileNameAbsolutePath;
    private String          directoryAbsolutePath;
}
