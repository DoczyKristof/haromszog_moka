package felulet;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
public class Felulet extends JFrame{
    //adattagok
    private JButton btn_FileChoose;
    private JPanel pnl_hibak, pnl_haromszogek, pnl_adat;
    private Container ablak;
    //kons
    public Felulet(){
        super();
        initComp();
    }
    //misc
    private void initComp(){
        this.setTitle("Derék legény háromszögek");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.ablak = this.getContentPane();
        this.setLayout(null);
        //hibakpanel
        this.pnl_hibak = new JPanel();
        this.pnl_hibak.setLocation(20, 20);
        this.pnl_hibak.setSize(500, 150);
        this.pnl_hibak.setBorder(new TitledBorder("Hibák a kiválasztott állományban"));
        this.pnl_hibak.setLayout(null);
        this.ablak.add(this.pnl_hibak);
        //end of hibakpanel
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}