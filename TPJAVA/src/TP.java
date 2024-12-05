import jdk.dynalink.beans.StaticClass;

import javax.swing.JFileChooser;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TP extends JFrame implements ActionListener {

    /**
     * Bouton
     **/
    static JButton a1 = new JButton("Ouvrir les fichiers et afficher leur contenu");
    static JButton a2 = new JButton("Saisir un numéro d’étudiant pour lequel il faut afficher sa note de programmation et son nom");
    static JButton a3 = new JButton("Afficher la moyenne générale de programmation");
    static JButton a4 = new JButton("Ajouter un étudiant");
    static JButton a5 = new JButton("Effacer un étudiant");
    static JButton a6 = new JButton("Afficher à l’écran les notes des étudiants par ordre croissant");
    JButton a7 = new JButton("Quitter l'application");


    /**
     * interface et prog
     **/
    static int i;

    public TP() throws IOException {
        setTitle("TP1");
        setSize(1280, 720);
        setLayout(new GridBagLayout());
        GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(3);
        gl.setHgap(8);
        gl.setVgap(8);
        this.setLayout(gl);
        add(a1);
        add(a2);
        add(a3);
        add(a4);
        add(a5);
        add(a6);
        add(a7);

        /**fermeture de l'application**/
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a7.addActionListener(e -> {
            dispose();
        });

        /**Programme bouton 1**/
        a1.addActionListener(e -> {


                    try {
                       Desktop.getDesktop().open(new java.io.File("C:\\Users\\auber\\Desktop\\TPJAVA\\entree1.txt"));
                       Desktop.getDesktop().open(new java.io.File("C:\\Users\\auber\\Desktop\\TPJAVA\\entree2.txt"));
                    }

                    catch (Exception a ) {
                     a.printStackTrace();
                    }
        });

        /**Programme bouton 2**/
        a2.addActionListener(e -> {

            int NumEtu = 0;
        JOptionPane.showInputDialog(null, JOptionPane.INFORMATION_MESSAGE, "Entree le numero de l'etudiant ", NumEtu);
            FileReader fichierreader = null;
            char[] tab = new char[50];
            try {
                fichierreader = new FileReader("C://Users/auber/Desktop/TPJAVA/entree2.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                fichierreader.read(tab);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            for (i=0;i < 5;i++)
            {
                if (NumEtu == tab[i])
                {
                    JOptionPane.showMessageDialog(null,fichierreader,"bouton2",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"AUCUNE CORRESPONCE DE NUMERO","bouton2",JOptionPane.INFORMATION_MESSAGE);
                }

            }


        });

        /**Programme bouton 3**/
       a3.addActionListener(e -> {
           /**Prog Moyenne**/
           int array[] = {12,11, 15, 15, 11, 11, 12};

           for (int nombre:array)
               System.out.print(nombre+" ");

           int somme = 0;
           for(int i = 0; i < array.length; i++){
               somme += array[i];
           }
           Float moyenne = (float) somme / array.length;
           JOptionPane.showMessageDialog(null,"La Moyenne et de : "+moyenne,"bouton3",JOptionPane.INFORMATION_MESSAGE);

           /**La note la plus eleve**/
           int nbmax =0;
           int occ=0;
           for (i=0;i< array.length;i++)
           {
               if (array[i]>nbmax)
               {
                   nbmax=array[i];
                    occ=i;
               }
           }
            JOptionPane.showMessageDialog(null,"Le Note max et : "+nbmax,"Bouton3",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,"Le nombre d'occurence de la note et : "+occ,"bouton3",JOptionPane.INFORMATION_MESSAGE);

       });
        /**Programme bouton 4**/
       a4.addActionListener(e -> {


       });

        /**Programme bouton 5**/
       a5.addActionListener(e -> {


       });

        /**Programme bouton 6**/
       a6.addActionListener(e -> {
           int array[] = {12,11, 15, 15, 11, 11, 12};
            int Note=0;

           String array2[]={"Un","Trois","Cinq","Neuf","Onze"};
           List tabliste=new ArrayList(List.of(array2));
           for (i=0;i< array.length;i++) {
               Arrays.sort(array);
               System.out.println(array[i]);
           }

           for (i=0;i< array2.length;i++)
           {
               Collections.sort(tabliste);
               System.out.println(array2[i]);
           }

    JOptionPane.showMessageDialog(null,"Notes des étudiants par ordre croissant : "+array[i],"Bouton6",JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null,"Nom par ordre Croissant : ","Bouton6",JOptionPane.INFORMATION_MESSAGE);


       });

}

    public void actionPerformed(ActionEvent e) {

    }


    /**Programme Main**/
    public static void main(String arg[]) throws IOException {
        TP fr = new TP();
        fr.setVisible(true);


    }

}

