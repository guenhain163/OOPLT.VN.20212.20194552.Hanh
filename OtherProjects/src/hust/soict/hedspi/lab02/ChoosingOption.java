import javax.swing.JOptionPane;

public class ChoosingOption {
    
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want...?");
        JOptionPane.showMessageDialog(null, "Ban da chon " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));

    }

}
