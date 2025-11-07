import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.*;

public class SwingUI implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private final int WIDTH = 800;
    private final int HEIGHT = 700;
    public static boolean on = false;


    public SwingUI() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingUI SwingUI = new SwingUI();
        SwingUI.showEventDemo();
        // swingControlDemo.Finder(); // Commented out since no input parameter available here

    }

    public void Finder(String input) {

        try {
            System.out.println();
            System.out.print("hello \n");
            URI uri = new URI(input);
            URL url = uri.toURL();



            URLConnection urlc = url.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("href=")) {

                        // varibles for quote indexes
                        //hDQ is double quote, and single quote is hsq
                        int hDQ = line.indexOf("href=\"");
                        int hSQ = line.indexOf("href='");

                        int start;
                        char cQ;

                        // 2 patterns work, I cover logic for having a double quote at the end or a single by seeig if the closing and opening quotes are single or double
                        if (hDQ != -1) {

                            start = hDQ + 6;
                            cQ = '"';
                        } else if (hSQ != -1) {

                            start = hSQ + 6;
                            cQ = '\'';
                        } else {
                            //kinda just breaks without this. could do else if else
                            continue;
                        }

                        if (start < line.length()) {
                            String urlC = line.substring(start);
                            //starts the substring 
                            int end = urlC.indexOf(cQ);
                            //this didnt work in my last iteration of the file. works now but idk why it didnt. this does the oppisite but it should still have worked.
                            if (end != -1 || !urlC.substring(0, 2).equals("//")) {
                                statusLabel.setText(urlC.substring(0, end));
                            }
                            else if (end != -1 || urlC.substring(0, 2).equals("//")) {
                                statusLabel.setText(urlC.substring(2, end));
                            }
                        }
                    }

                }

            }
        }
        // mabe do multicatch or something specific to iostream and url exceptions
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3, 1));

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

        ta = new JTextArea();
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        mainFrame.add(mb);  //add menu bar
        mainFrame.add(ta);//add typing area
        mainFrame.setJMenuBar(mb); //set menu bar

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout()); //set the layout of the pannel

        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton startButton = new JButton("Start");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        startButton.setActionCommand("Start");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        startButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(startButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Start")) {
                statusLabel.setText("");
                String input = ta.getText();
                Finder(input);
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}