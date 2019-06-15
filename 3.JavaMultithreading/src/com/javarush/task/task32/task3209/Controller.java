package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {
        createNewDocument();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader, document, 0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }

        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void openDocument() {
        view.selectHtmlTab();

        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());

        int returnVal = chooser.showOpenDialog(view);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            FileReader reader = null;
            try {
                reader = new FileReader(currentFile);
                new HTMLEditorKit().read(reader, document, 0);
                view.resetUndo();

            } catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    ExceptionHandler.log(e);
                }
            }
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();

        if (currentFile == null) {
            saveDocumentAs();
        } else {
            FileWriter writer = null;
            try {
                writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());

            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);

            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    ExceptionHandler.log(e);
                }
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();

        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());

        int returnVal = chooser.showSaveDialog(view);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            FileWriter writer = null;
            try {
                writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());

            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);

            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    ExceptionHandler.log(e);
                }
            }
        }

    }

    public void exit() {
        System.exit(0);
    }
}

