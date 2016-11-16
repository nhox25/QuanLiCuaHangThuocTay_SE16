package renderer;

import bean.LoaiThucPham;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.ModelLoaiThucPham;

/**
 *
 * @author Yen Vo
 */
public class ComboBoxModelLoaiThucPham extends DefaultComboBoxModel<LoaiThucPham> {

    private LoaiThucPham loaiSelected;
    private ArrayList<LoaiThucPham> alItem;
    private ModelLoaiThucPham modelLoaithucpham;


    public ComboBoxModelLoaiThucPham(LoaiThucPham loaiSelected, boolean isSearch) {
        modelLoaithucpham = new ModelLoaiThucPham();
        alItem = modelLoaithucpham.getList();
        if (isSearch) {
            LoaiThucPham c = new LoaiThucPham(0, "---Chọn---");
            alItem.add(0, c);

        }
        if (loaiSelected == null) {
            this.loaiSelected = alItem.get(0);
        } else {
            this.loaiSelected = loaiSelected;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.loaiSelected = (LoaiThucPham) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return loaiSelected;
    }

    @Override
    public int getSize() {
        return alItem.size();
    }

    @Override
    public LoaiThucPham getElementAt(int index) {
        return alItem.get(index);
    }

}
