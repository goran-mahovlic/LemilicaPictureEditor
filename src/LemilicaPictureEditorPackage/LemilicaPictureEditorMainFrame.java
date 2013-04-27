package LemilicaPictureEditorPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lemilica.com
 */
public class LemilicaPictureEditorMainFrame extends JFrame {

    private JPanel ButtonPanel, MainJpanel, PicturePanel, SidePanel;
    private JButton OpenButton, FixButton, CloseButton;
    private JLabel PictureLabel;
    private JSlider OpacitySlider, QualitySlider, DesaturateSlider;
    private JLabel OpacityLabel, QualityLabel, DesaturateLabel, LogoLabel, WidthLogo, HightLogo;
    private JTextField LogoTextFiled, WidthTextFiled, HightTextFiled;
    private ImageIcon Background;
    //ovo moramo popraviti
    private String SelectedFilenamePart1 = "C:/Java/LemilicaPictureEditor/LemilicaPictureEditor/default";
    private String SelectedFilenamePart2 = ".JPG";
    private String SelectedFilename, SelectedFilenameTemp;
    private String LogoText = "http://www.lemilica.com";
    private javaxt.io.Image Image,Image2;
    private javaxt.io.File ImageFile;
    private String ImageHight, ImageWidth;
    private int ImageInt = 0;
    private JFileChooser FileChooser;
    private boolean IsFileOpend = false;

    public LemilicaPictureEditorMainFrame() {
        //Ovako dodajemo naslov našem glavnom prozoru
        super("Lemilica picture editor");
        //kreiramo novi Panel
        MainJpanel = new JPanel();
        //određejemo najjednostavniji layout, a to je da ga uopće nema
        MainJpanel.setLayout(null);
        //otvaramo novi file
        Image = new javaxt.io.Image(SelectedFilenamePart1 + SelectedFilenamePart2);
        //kreiramo panel sa sliderima koji će nam stajati sa strane
        //gdje ćemo podešavati novu sliku
        SidePanel = new JPanel();
        //kreiramo novi slider sa kojim ćemo mijenjati Opacity, što god to bilo
        OpacitySlider = new JSlider();
        //namještamo minimalnu vrijednost Opacity slidera
        OpacitySlider.setMinimum(0);
        //namještamo maksimalnu vrijednost Opacity slidera
        OpacitySlider.setMaximum(100);
        //namještamo trenutnu vrijednost Opacity slidera
        OpacitySlider.setValue(100);
        //kreiramo novi Label gdje ćemo samo upisati što se podešava 
        //sa slideom tekst koji je unutar biti će prikazan 
        //zagrade je ono što će unutar labela pisati
        OpacityLabel = new JLabel("Opacity Percentage");
        //stavljamo OpacityLabel unutar SidePanel-a
        //unutar panela slideri, labeli i texbox-ovi će biti 
        //poredani redosljedom kojim ih dodajemo
        //stavljamo OpacityLabel unutar SidePanel-a 
        SidePanel.add(OpacityLabel);
        //stavljamo OpacitySlider unutar SidePanel-a
        SidePanel.add(OpacitySlider);
        //kreiramo novi slider sa kojim ćemo mijenjati kvalitetu slike
        QualitySlider = new JSlider();
        //namještamo minimalnu vrijednost Quality slidera
        QualitySlider.setMinimum(0);
        //namještamo maksimalnu vrijednost Quality slidera
        QualitySlider.setMaximum(100);
        //namještamo trenutnu vrijednost Quality slidera
        QualitySlider.setValue(80);
        //kreiramo novi Label sa tekstom
        QualityLabel = new JLabel("Quality Percentage");
        //stavljamo QualityLabel unutar SidePanel-a
        SidePanel.add(QualityLabel);
        //stavljamo QualitySlider unutar SidePanel-a
        SidePanel.add(QualitySlider);
        //kreiramo novi slider
        DesaturateSlider = new JSlider();
        //postavljamo njegov minimum
        DesaturateSlider.setMinimum(0);
        //postavljamo njegov maksimum
        DesaturateSlider.setMaximum(100);
        //postavljamo njegovu trenutnu vrijednost
        DesaturateSlider.setValue(0);
        //kreiramo novi label
        DesaturateLabel = new JLabel("Desaturate Percentage");
        //stavljamo DesaturateLabel unutar SidePanel-a
        SidePanel.add(DesaturateLabel);
        //stavljamo DesaturateSlider unutar SidePanel-a
        SidePanel.add(DesaturateSlider);
        //kreiramo novi label
        LogoLabel = new JLabel("Enter logo in the text box");
        //stavljamo LogoLabel unutar SidePanel-a
        SidePanel.add(LogoLabel);
        //kreiramo novi label
        LogoTextFiled = new JTextField(LogoText);
        //stavljamo LogoTextFiled unutar SidePanel-a
        SidePanel.add(LogoTextFiled);
        //kreiramo novi label
        WidthLogo = new JLabel("Current image width:");
        //stavljamo WidthLogo unutar SidePanel-a
        SidePanel.add(WidthLogo);
        //za ImageWidth smo već gore odredili sa nam je string
        //Image.getWidth() će nam vratiti koja je širina slike
        //vratiti će to u int vrijednosti 
        //Integer.toString će int vrijednost koju smo dobili u zagradi
        //pretvoriti u string
        ImageWidth = Integer.toString(Image.getWidth());
        //kreiramo novo polje sa tekstom i u njega stavljamo predhodno
        //dobivenu vrijednost širine
        WidthTextFiled = new JTextField((ImageWidth));
        //dodajemo WidthTextFiled unutar SidePanel-a
        SidePanel.add(WidthTextFiled);
        //kreiramo novi label
        HightLogo = new JLabel("Current image hight:");
        //stavljamo HightLogo unutar SidePanel-a
        SidePanel.add(HightLogo);
        //za ImageHight smo već gore odredili sa nam je string
        //Image.getHight() će nam vratiti koja je visina slike
        //vratiti će to u int vrijednosti 
        //Integer.toString će int vrijednost koju smo dobili u zagradi
        //pretvoriti u string
        ImageHight = Integer.toString(Image.getHeight());
        //kreiramo novo polje sa tekstom i u njega stavljamo predhodno
        //dobivenu vrijednost visine
        HightTextFiled = new JTextField(ImageHight);
        //stavljamo HightTextFiled unutar SidePanel-a
        SidePanel.add(HightTextFiled);
        //određujemo gdje će SidePanel stajati unutar glavnog panela
        SidePanel.setLocation(670, 10);
        //određujemo veličinu SidePanela
        SidePanel.setSize(200, 600);
        //da bi vidjeli gdje je trenutno SidePanel i da ga lakše smjestimo
        //možemo koristiti sljedeću liniju
        //to će panelu dati boju pa ćemo ga lakše pozicionirati
        //SidePanel.setBackground(Color.GRAY);
///////////////////////////////////////////////////////////////////////////        
        //dodajemo SidePanel unutar MainJpanel
        MainJpanel.add(SidePanel);
        //kreiramo IconImage koji će držati našu sliku
        //u zagradi mu stavimo prvu defaultnu sliku koja će biti kod 
        //otvaranja programa
        Background = new ImageIcon(SelectedFilenamePart1 + SelectedFilenamePart2);
        //kreiramo novi label
        PictureLabel = new JLabel();
        //određujemo veličinu
        PictureLabel.setBounds(0, 0, 640, 480);
        //dodjeljujemo label-u našu ikonu koju smo kreirali predhodno
        PictureLabel.setIcon(Background);
        //kreiramo PicturePanel u koji ćemo smjestiti sliku
        PicturePanel = new JPanel();
        //određujemo lokaiju PicturePanel-a
        PicturePanel.setLocation(10, 10);
        //određujemo veličinu PicturePanel-a
        PicturePanel.setSize(640, 480);
        //postavljamo Layout
        PicturePanel.setLayout(null);
        //postavljemo PictureLabel unutar PicturePanel-a
        PicturePanel.add(PictureLabel);
        //dodjeljujemo boju PicturePanel-u
        PicturePanel.setBackground(Color.GRAY);
        //postavljemo PicturePanel unutar MainJpanel-a
        MainJpanel.add(PicturePanel);
        //kreiramo panel ButtonPanel koji će sadržavati gumbe
        ButtonPanel = new JPanel();
        //postavljamo layout
        ButtonPanel.setLayout(null);
        //određujemo lokaciju ButtonPanel-u
        ButtonPanel.setLocation(10, 520);
        //određujemo veličinu ButtonPanel-a
        ButtonPanel.setSize(400, 40);
        //obojimo radi testiranja
        //buttonPanel.setBackground(Color.red);
        //dodamo ButtonPanel unutar MainJpanel
        MainJpanel.add(ButtonPanel);
        // We create a buttons
        thehandler handler = new thehandler();
        //kreiramo novi gumb na kojem će pisati tekst OPEN
        OpenButton = new JButton("Open");
        //naziv možemo mijenjati i ovako
        //OpenButton.setText("Open");
        //određujemo lokaciju gumba
        OpenButton.setLocation(0, 0);
        //određujemo veličinu gumba
        OpenButton.setSize(100, 30);
        //gumbu dodjeljujemo ActionListener koji će 
        //paziti što se dešava sa gumbom (da li je stisnut pušten...)
        OpenButton.addActionListener(handler);
        //gumb dodamo na ButtonPanel
        ButtonPanel.add(OpenButton);
        //sve jednako kao i kod open gumba
        FixButton = new JButton("Fix");
        FixButton.setLocation(120, 0);
        FixButton.setSize(100, 30);
        FixButton.addActionListener(handler);
        ButtonPanel.add(FixButton);
        //sve jednako kao i kod open gumba
        CloseButton = new JButton("Close");
        CloseButton.setLocation(240, 0);
        CloseButton.setSize(100, 30);
        CloseButton.addActionListener(handler);
        ButtonPanel.add(CloseButton);
        //pošto klasa u kojoj se nalazimo(LemilicaPictureEditorMainFrame)
        //proširuje (extends) JFrame njemu trebamo dodjeliti naš MainJpanel
        //znači ovdje smo unutar JFrame-a postaviti naš panel u koji smo postavili 
        //sve ovo gore što smo radili
        add(MainJpanel);
    }
//funkcija sa kojom ćemo odabrati sliku iz foldera

    private void showOpenFileDialog() {
        //otvaramo directory browser
        FileChooser = new JFileChooser();
        //dodajemo novi filter da nam prikaže samo slike
        FileNameExtensionFilter PictureFilter = new FileNameExtensionFilter(
                "JPG, GIF, PNG Images", "jpg", "gif", "png");
        //postavljamo defaultni direktorij kod otvaranja browsera 
        FileChooser.setCurrentDirectory(new File("C:/"));
        //odaberemo defaultni filter
        FileChooser.addChoosableFileFilter(PictureFilter);
        //moramo maknuti da korisnik može odabrati bilo koji file
        FileChooser.setAcceptAllFileFilterUsed(false);
        //postavljamo PictureFilter kao defaultni
        FileChooser.setFileFilter(PictureFilter);
        //da li odabrano odgovara našem filteru
        int result = FileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = FileChooser.getSelectedFile();
            //uzimamo apsolutni path of odabranog fila i spremamo ga u string
            SelectedFilenameTemp = selectedFile.getAbsolutePath();
            //obavezno zamjenimo sve backslash-e sa slash-evima
            SelectedFilename = SelectedFilenameTemp.replaceAll("\\\\", "/");
            //u int pos stavljamo na kojoj je točno poziciji točka
            int pos = SelectedFilename.lastIndexOf('.');
            //u SelectedFilenamePart2 spremi točku i dalje od nje (.JPG ili .GIF)
            SelectedFilenamePart2 = SelectedFilename.substring(pos);
            //za kontrolu možete ispisati u outputu
            //System.out.println(SelectedFilenamePart2);
            //upišemo ovako u string inače će on imati vrijednost NULL, 
            //probajte maknuti pa ćete vidjeti na ispisu 
            SelectedFilenamePart1 = "";
            //for petlja u kojoj ćemo uzeti svaki karakter path-a od 0 do točke i
            //spremiti to u string SelectedFilenamePart1
            for (int i = 0; i < pos; i++) {
                SelectedFilenamePart1 = SelectedFilenamePart1 + SelectedFilename.charAt(i);
            }
            //ponovno si možemo pomoći sa ispisom 
            //System.out.println(SelectedFilenamePart1);

        }


    }

    private class thehandler implements ActionListener {
        //ako se je dogodio neki event

        public void actionPerformed(ActionEvent e) {
            //e.getActionCommand() će nam vratiti text što se točno desilo
            //možda je na početku dobro to prvo ispisati 
            //System.out.println(e.getActionCommand());
            //i onda kada vidmo što se dešava možemo napisati switch case
            switch (e.getActionCommand()) {
                //u slućaju da je e.getActionCommand() vratio "Open"
                //pritisnut je gumb Open :)
                case "Open":
                    //prikaži browser da možemo odabrati file
                    showOpenFileDialog();
                    //ovako možemo provjeriti da li sve radi
                    //System.out.println(SelectedFilename);
                    //provjerimo da odabrani file nije naš defaultni
                    //i ako je bacimo poruku da pokuša ponovo
                    // System.out.println(SelectedFilenamePart1+SelectedFilenamePart2);
                    // System.out.println(Filename + Filename2);
                    if (SelectedFilename.equals(SelectedFilenamePart1 + SelectedFilenamePart1)) {
                        JOptionPane.showMessageDialog(null, "You opened default file, please try another");
                    } else {
                        //ako file koji smo otvorili nije jednak početnom onda možemo krenuti na posao
                        IsFileOpend = true;
                        //setiramo novu sliku
                        PictureLabel.setIcon(new ImageIcon(SelectedFilenamePart1 + SelectedFilenamePart2));
                        //osvježimo PictureLabel
                        PictureLabel.repaint();
                        PictureLabel.revalidate();

                    }
                    break;
                case "Fix":
                    //ako je file predhodno otvoren
                    if (IsFileOpend) {
                        //otvorimo novo odabranu sliku
                        Image2 = new javaxt.io.Image(SelectedFilenamePart1 + SelectedFilenamePart2);
                        //napokon smo došli do javaxt librarija 
                        //sada ćemo njime urediti našu slikicu
                        //promjeni veličinu slike na 640 480
                        Image2.resize(640, 480, true);
                        //uzmi vrijsdnost Quality slidera i primjeni je na sliku
                        Image2.setOutputQuality(QualitySlider.getValue());
                        //uzmi vrijsdnost Opacity slidera i primjeni je na sliku
                        Image2.setOpacity(OpacitySlider.getValue());
                        //uzmi vrijsdnost Desaturate slidera i primjeni je na sliku
                        //vrijednost Desaturate mora biti između 0 i 1
                        //da bi to postigli uzeti ćemo vrijednost od slidera
                        //pretvoriti je u double i podijeliti sa 100
                        Image2.desaturate(((double) DesaturateSlider.getValue()) / 100);
                        //nemam pojima ima u librariju pa reko neka izoštri :)
                        Image2.sharpen();
                        //uzimamo tekst iz text box-a, određujemo koordinate, odabiremo font i veličinu fonta  
                        Image2.addText(LogoTextFiled.getText(), 390, 470, "Helvetica", 20, 12, 6, 199);
                        //otvaramo novi file da možemo sa njime upravljati
                        //svaki puta kada popravimo sliku ImageInt će se 
                        //povećati za 1 pa onda otvorimo si pristup tome filu 
                        ImageFile = new javaxt.io.File(SelectedFilenamePart1 + "_" + ImageInt + SelectedFilenamePart2);
                        if (ImageFile.exists()) {
                            //i obišemo ga jer je to file koji je ostao od zadnji puta kada smo popravljali
                            //sliku
                            ImageFile.delete();
                        }
                        //povećamo ImageInt za 1;
                        ImageInt++;
                        //Spremamo sliku u formatu imeslike_brojprepravka.jpg
                        Image2.saveAs(SelectedFilenamePart1 + "_" + ImageInt + SelectedFilenamePart2);
                        //dodjeljujemo našu novo editiranu sliku unutar prozora gdje nam stoji slika
                        PictureLabel.setIcon(new ImageIcon(SelectedFilenamePart1 + "_" + ImageInt + SelectedFilenamePart2));
                        //System.out.println(SelectedFilenamePart1 + "_" + ImageInt + SelectedFilenamePart2);
                        //mijenjamo text da nam pokaže trenutnu visinu slike(mi je kao znamo pa sam samo ovako stavio)
                        //to možete promjeniti i uzeti baš pravu vrijednost
                        WidthTextFiled.setText("640");
                        HightTextFiled.setText("480");
                        //osvježimo PictureLabel
                        PictureLabel.repaint();
                        PictureLabel.revalidate();
                        //izbacimo popup poruku da je sve odrađeno kako smo i htjeli...
                        JOptionPane.showMessageDialog(null, "Fixed");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please open file first");
                    }
                    break;
                case "Close":
                    //ugasi JFrame
                    dispose();
                    break;
            }
        }
    }
}
