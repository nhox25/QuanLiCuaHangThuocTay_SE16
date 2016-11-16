package renderer;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Yen Vo
 */
public class TableCellRendererTimeStamp extends DefaultTableCellRenderer{
    SimpleDateFormat sdf;
    public TableCellRendererTimeStamp(){
        sdf = new SimpleDateFormat("dd-MM-yyyy");
    }
    @Override
    protected void setValue(Object value) {
        super.setValue(sdf.format(value));
    }
}
