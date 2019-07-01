package ClientDemo;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MyJTextPanel extends JTextPane implements DropTargetListener
{
    public MyJTextPanel(){
        new DropTarget(this,DnDConstants.ACTION_COPY_OR_MOVE,this);
    }
    @Override
    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();
            if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                List list = (List) (dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor));
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    File f = (File) iterator.next();
                    this.setText(f.getAbsolutePath());
                }
                dtde.dropComplete(true);
            }else {
                dtde.rejectDrop();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (UnsupportedFlavorException ufe) {
            ufe.printStackTrace();
        }
    }


    @Override
    public void dragEnter(DropTargetDragEvent dtde) { }
    @Override
    public void dragOver(DropTargetDragEvent dtde) { }
    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) { }
    @Override
    public void dragExit(DropTargetEvent dte) { }


}
