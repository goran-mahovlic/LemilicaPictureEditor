package LemilicaPictureEditorPackage;

import javax.swing.JFrame;
/*
 * @author lemilica.com
 * Jednostavan program sa kojim ćemo moći mijenjati neke postavke slike 
 * moći ćemo otvoriti sliku, primjeniti prmjene, zatvoriti program :)
 * Isto tako na sliku ćemo moći "zaljepiti" tekst ili možda u nekoj verziji 
 * drugu sliku da koja će nam služiti kao žig...
 */

public class LemilicaPictureEditor {

    public static void main(String[] args) {

        LemilicaPictureEditorMainFrame MainFrame = new LemilicaPictureEditorMainFrame();
        //ovo moramo obavezno upisati da kada pritisnemo x aplikacija automatski prestane sa radom
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //određujemo veličinu glavnog prozora
        MainFrame.setSize(900, 600);
        //prikazujemo glavni prozor
        MainFrame.setVisible(true);
        
    }
}
