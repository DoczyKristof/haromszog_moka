package felulet;
import java.awt.Container;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import logika.DHaromszog;
public class Felulet extends JFrame{
    //adattagok
    private JButton btn_FileChoose;
    private JPanel pnl_hibak, pnl_haromszogek, pnl_adat;
    private Container ablak;
    private JFileChooser filechsr;
    private List<DHaromszog> haromszogLista;
    //kons
    public Felulet(){
        super();
        initComp();
    }
    //misc
    private void loadStuff(ActionEvent ae){
        this.filechsr = new JFileChooser();
        if (this.filechsr.showDialog(this, "Fájl megnyitása") != -1) {
            System.out.println(filechsr.getSelectedFile().toString());
        }
    }
    private void initComp(){
        this.setTitle("Derék legény háromszögek");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.ablak = this.getContentPane();
        this.setLayout(null);
        //dataLoad gomb
        this.btn_FileChoose = new JButton();
        this.btn_FileChoose.setText("Adatok betöltése");
        this.btn_FileChoose.setSize(200, 25);
        this.btn_FileChoose.setLocation(20, 20);
        this.btn_FileChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStuff(e);
            }
        }
        );
        this.ablak.add(this.btn_FileChoose);
        //end of dataLoad gomb
        //hibakpanel
        this.pnl_hibak = new JPanel();
        this.pnl_hibak.setLocation(20, 70);
        this.pnl_hibak.setSize(750, 150);
        this.pnl_hibak.setBorder(new TitledBorder("Hibák a kiválasztott állományban"));
        this.pnl_hibak.setLayout(null);
        this.ablak.add(this.pnl_hibak);
        //end of hibakpanel
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void readFile(String fileName){
        this.haromszogLista = new ArrayList<>();
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null) {   
                try{
                    DHaromszog dh = new DHaromszog(sor,0);
                    sor = br.readLine();
                }catch(Exception e){
                    System.err.println("");
                }
            }
            br.close();
            fr.close();
        }catch(FileNotFoundException fnfe){
            System.err.println(fnfe.getMessage());
        }catch(IOException ioe){
            System.err.println(ioe.getMessage());
        }
    }
}