package renderer;

import bean.User;
import bean.login_user;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.ModelLogin_user;
import model.ModelUser;

/**
 *
 * @author Yen Vo
 */
public class ComboBoxModelNhanVienBan extends DefaultComboBoxModel<User> {

    private User Selected;
    private final ArrayList<User> alItem;
    private final ModelUser modelUser;
    private final ModelLogin_user modelLogin_user;

    public ComboBoxModelNhanVienBan(User Selected, boolean all) {
        modelUser = new ModelUser();
        modelLogin_user = new ModelLogin_user();
        ArrayList<login_user> user = modelLogin_user.getUserLogin();
        String username = user.get(0).getUser_login();
        String chucvu = user.get(0).getChucvu();
        if (chucvu.equals("Admintors")) {
            alItem = modelUser.getList();
            User c = new User("", "", "---Tất cả---");
            alItem.add(0, c);
        } else {
            alItem = modelUser.getList(username);
        }
        if (Selected == null) {
            this.Selected = alItem.get(0);
        } else {
            this.Selected = Selected;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.Selected = (User) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return Selected;
    }

    @Override
    public int getSize() {
        return alItem.size();
    }

    @Override
    public User getElementAt(int index) {
        return alItem.get(index);
    }

}
