import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter; 
import java.io.FileReader; 
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;
import java.util.Date;
import java.util.TimeZone;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class KingdomNewlandsSaveLoader extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    static JLabel labelSlot1;
    static JLabel labelSlot3;
    static JLabel labelSlot2;
    static JButton saveButton1;
    static JButton loadSlot1;
    static JButton saveButton2;
    static JButton loadSlot2;
    static JButton saveButton3;
    static JButton loadSlot3;
    public static String userHome = System.getProperty("user.home");
    public static String userSaveDirectory = userHome + File.separator + "AppData" + File.separator + "LocalLow" + File.separator + "noio" + File.separator + "Kingdom" ;
    public static File activeSave = new File(userSaveDirectory + File.separator + "storage_v34_AUTO.dat");
    public static String backupDirectory = userSaveDirectory + File.separator + "Saves";
    public static File metadataFile = new File(backupDirectory + File.separator + "SaveManagerMetadata.yew");
    public static String save1Directory = userSaveDirectory + File.separator + "Saves" + File.separator + "SlotOne";
    public static String save2Directory = userSaveDirectory + File.separator + "Saves" + File.separator + "SlotTwo";
    public static String save3Directory = userSaveDirectory + File.separator + "Saves" + File.separator + "SlotThree";
    public static File saveFile1 = new File(save1Directory + File.separator + "saveGame.dat");
    public static File saveFile2 = new File(save2Directory + File.separator + "saveGame.dat");
    public static File saveFile3 = new File(save3Directory + File.separator + "saveGame.dat");
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss a");
    static Date date = new Date();
    public static Color customBrown = new Color(80, 59, 49);
    public static Color customRed = new Color(176, 6, 29);
    public static Color customBlue = new Color(29, 6, 176);
    public static Color customGold = new Color(209, 122, 34);
    public static Color customGrey = new Color(220, 214, 246);
    public static Color customGreen = new Color(97, 139, 37);
    public static String[] saveMessageArray = new String[4];
    public KingdomNewlandsSaveLoader() {
        jcomp1 = new JLabel ("Kingdom: New Lands Save Manager");
        jcomp2 = new JLabel ("By: Yew™");
        jcomp3 = new JLabel ("V 1.0 (JVM Might cause incorrect timezones on savefiles!)");
        labelSlot1 = new JLabel (saveMessageArray[0]);
        labelSlot2 = new JLabel (saveMessageArray[1]);
        labelSlot3 = new JLabel (saveMessageArray[2]);
        saveButton1 = new JButton ("Save current to slot 1.");
        loadSlot1 = new JButton ("Load slot 1.");
        saveButton2 = new JButton ("Save current to slot 2.");
        loadSlot2 = new JButton ("Load slot 2.");
        saveButton3 = new JButton ("Save current to slot 3.");
        loadSlot3 = new JButton ("Load slot 3.");
        
        labelSlot1.setHorizontalAlignment(SwingConstants.CENTER);
        labelSlot2.setHorizontalAlignment(SwingConstants.CENTER);
        labelSlot3.setHorizontalAlignment(SwingConstants.CENTER);

        labelSlot1.setOpaque(true);
        labelSlot2.setOpaque(true); 
        labelSlot3.setOpaque(true);
        
        Border raisedBorder = BorderFactory.createRaisedBevelBorder();
        Border loweredBorder = BorderFactory.createLoweredBevelBorder();
        
        labelSlot1.setBorder(loweredBorder);
        labelSlot2.setBorder(loweredBorder);
        labelSlot3.setBorder(loweredBorder);
        
        saveButton1.setBorder(raisedBorder);
        saveButton2.setBorder(raisedBorder);
        saveButton3.setBorder(raisedBorder);
        
        loadSlot1.setBorder(raisedBorder);
        loadSlot2.setBorder(raisedBorder);
        loadSlot3.setBorder(raisedBorder);
        
        labelSlot1.setBackground(customGreen);
        labelSlot2.setBackground(customGreen);
        labelSlot3.setBackground(customGreen);
        
        labelSlot1.setForeground(customGrey);
        labelSlot2.setForeground(customGrey);
        labelSlot3.setForeground(customGrey);

        jcomp1.setForeground(customGold);
        jcomp2.setForeground(customGold);
        jcomp3.setForeground(customGold);
        
        saveButton1.setBackground(customRed);
        saveButton2.setBackground(customRed);
        saveButton3.setBackground(customRed);
        loadSlot1.setBackground(customBlue);
        loadSlot2.setBackground(customBlue);
        loadSlot3.setBackground(customBlue);
        
        saveButton1.setForeground(customGrey);
        saveButton2.setForeground(customGrey);
        saveButton3.setForeground(customGrey);
        loadSlot1.setForeground(customGrey);
        loadSlot2.setForeground(customGrey);
        loadSlot3.setForeground(customGrey);
        
        
        setPreferredSize (new Dimension (440, 235));
        setLayout (null);
        setBackground(customBrown);
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (labelSlot1);
        add (labelSlot2);
        add (labelSlot3);
        add (saveButton1);
        add (loadSlot1);
        add (saveButton2);
        add (loadSlot2);
        add (saveButton3);
        add (loadSlot3);

        jcomp1.setBounds (5, 5, 350, 25);
        jcomp2.setBounds (385, 5, 60, 25);
        jcomp3.setBounds (5, 30, 350, 25);
        labelSlot1.setBounds (5, 60, 270, 50);
        labelSlot3.setBounds (5, 190, 270, 50);
        labelSlot2.setBounds (5, 125, 270, 50);
        saveButton1.setBounds (275, 60, 170, 25);
        loadSlot1.setBounds (275, 85, 170, 25);
        saveButton2.setBounds (275, 125, 170, 25);
        loadSlot2.setBounds (275, 150, 170, 25);
        saveButton3.setBounds (275, 190, 170, 25);
        loadSlot3.setBounds (275, 215, 170, 25);
    }


    public static void main (String[] args) {
        if(metadataFile.exists()) {
                    saveMessageArray[0] = readMetaLineFromFile(metadataFile, 0);
                    saveMessageArray[1] = readMetaLineFromFile(metadataFile, 1);
                    saveMessageArray[2] = readMetaLineFromFile(metadataFile, 2);
        } else {
            for(int i = 0; i < 3; i++) { saveMessageArray[i] = "Save #" + i + " - 00/00/00 - 12:00:00 AM"; }
        }
        saveMessageArray[3] = "This just is suppose to store the correct time, date, and save numerical indicator."; 
        //Lets get and set the computer timezone.
        TimeZone.setDefault(getCurrentTimeZone());
        JFrame frame = new JFrame ("Kingdom: New Lands Save Manager by Yew™ - V1.0");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new KingdomNewlandsSaveLoader());
        frame.pack();
        frame.setResizable(false);
        frame.setVisible (true);
        //SaveButtons
        saveButton1.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                //Make Directory if it doesn't exist.
                File directory = new File(save1Directory);
                directory.mkdirs();
                //Copy the active save file to the save folder.
                if ( activeSave != null ) {
                    try { copyOverwriteFile(activeSave, saveFile1); }
                    catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
                    finally { 
                        saveMessageArray[0] = "Save #1 - " + dateFormat.format(date) + " - " + timeFormat.format(date);
                        labelSlot1.setText(saveMessageArray[0]); 
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You need save to save your save.", "Oopsie Doopsie!", JOptionPane.PLAIN_MESSAGE);
                }
                writeTextArrayToFile(saveMessageArray, metadataFile, false);
            }  
        }); 
       saveButton2.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                //Make Directory if it doesn't exist.
                File directory = new File(save2Directory);
                directory.mkdirs();
                //Copy the active save file to the save folder.
                if ( activeSave != null ) {
                    try { copyOverwriteFile(activeSave, saveFile2); }
                    catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
                    finally { 
                        saveMessageArray[1] = "Save #2 - " + dateFormat.format(date) + " - " + timeFormat.format(date);
                        labelSlot2.setText(saveMessageArray[1]); 
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You need save to save your save.", "Oopsie Doopsie!", JOptionPane.PLAIN_MESSAGE);
                }
                writeTextArrayToFile(saveMessageArray, metadataFile, false);
            }  
        }); 
        saveButton3.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                //Make Directory if it doesn't exist.
                File directory = new File(save3Directory);
                directory.mkdirs();
                //Copy the active save file to the save folder.
                if ( activeSave != null ) {
                    try { copyOverwriteFile(activeSave, saveFile3); }
                    catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
                    finally { 
                        saveMessageArray[2] = "Save #3 - " + dateFormat.format(date) + " - " + timeFormat.format(date);
                        labelSlot3.setText(saveMessageArray[2]); 
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You need save to save your save.", "Oopsie Doopsie!", JOptionPane.PLAIN_MESSAGE);
                }
                writeTextArrayToFile(saveMessageArray, metadataFile, false);
            }  
        }); 
        //LoadButtons
        loadSlot1.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                //Copy the saved save file to overwrite your save.
                if ( saveFile1 != null ) {
                    try { copyOverwriteFile(saveFile1, activeSave); }
                    catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
                    finally { JOptionPane.showMessageDialog(frame, "Save #1 Loaded!", "Rest in peace, current save.", JOptionPane.PLAIN_MESSAGE); }
                } else {
                    JOptionPane.showMessageDialog(frame, "You need a saved save to load a save.", "Oopsie Doopsie!", JOptionPane.PLAIN_MESSAGE);
                }
            }  
        }); 
        loadSlot2.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                //Copy the saved save file to overwrite your save.
                if ( saveFile2 != null ) {
                    try { copyOverwriteFile(saveFile2, activeSave); }
                    catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
                    finally { JOptionPane.showMessageDialog(frame, "Save #2 Loaded!", "Rest in peace, current save.", JOptionPane.PLAIN_MESSAGE); }
                } else {
                    JOptionPane.showMessageDialog(frame, "You need a saved save to load a save.", "Oopsie Doopsie!", JOptionPane.PLAIN_MESSAGE);
                }
            }  
        }); 
        loadSlot3.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                //Copy the saved save file to overwrite your save.
                if ( saveFile3 != null ) {
                    try { copyOverwriteFile(saveFile1, activeSave); }
                    catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
                    finally { JOptionPane.showMessageDialog(frame, "Save #3 Loaded!", "Rest in peace, current save.", JOptionPane.PLAIN_MESSAGE); }
                } else {
                    JOptionPane.showMessageDialog(frame, "You need a saved save to load a save.", "Oopsie Doopsie!", JOptionPane.PLAIN_MESSAGE);
                }
            }  
        }); 
    }
    private static TimeZone getCurrentTimeZone() {
        Calendar currentCalendarData = Calendar.getInstance();
        TimeZone currentTimeZone = currentCalendarData.getTimeZone();
        return currentTimeZone;
    }
    private static void copyOverwriteFile(File src, File dest) throws IOException {  
        Path copiedFile = Files.copy(Paths.get(src.getPath()), Paths.get(dest.getPath()), StandardCopyOption.REPLACE_EXISTING);
    }
    private static String readMetaLineFromFile(File file, int line) {
        String gettedLine = "YOU SHOULD NOT BE ABLE TO SEE THIS MESSAGE!";
        try {
            gettedLine = Files.readAllLines(Paths.get(file.getPath())).get(line);
        } catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
        return gettedLine;
    }
    /*
    private static String readMetaLineFromFile(File file, int line) {
        String targetLine = "Save #1 - " + dateFormat.format(date) + " - " + timeFormat.format(date);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < line; i++) {
                br.readLine();
                targetLine = br.readLine();
                System.out.println(i + "  gay  " + targetLine);
            }
        } catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
        finally {
            return targetLine;
        }
    }
    */
    public static boolean writeTextArrayToFile(String[] textLines, File filePath, boolean append) {
        boolean wroteOK = false;
        try
        {
            BufferedWriter writer = null;
            String lineSep = System.getProperty("line.separator");
            try {
                writer = new BufferedWriter(new FileWriter(filePath, append));
                for (int i = 0; i < textLines.length; i++) {
                    writer.write(textLines[i] + lineSep);
                }
                  wroteOK = true;
                }
            finally {
                if (writer != null) {
                    writer.close();
                }
            }  
        } catch ( IOException eXcEpTiOn ) {System.err.println("Caught IOException: " + eXcEpTiOn.getMessage()); }
        return wroteOK;
    }
}
