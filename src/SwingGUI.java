import javax.swing.*;

public class SwingGUI extends JFrame{
    private JPanel panel1;
    private JButton submitButton;
    private JButton startButton;
    private JButton cancelButton;
    private JTextArea textArea1;
    private JButton wscrapeButton;
    private JButton HTMLButton;
    private JButton emailsButton;
    private JButton wowButton;
    private JButton copyButton1;
    private JButton noIdeaButton;


    //https://www.youtube.com/watch?v=gqTDu3VqSGM
    public SwingGUI() {
        setContentPane(panel1);
        setTitle("Webscraper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SwingGUI();
    }


//    public void Finder(String input) {
//
//        try {
//            System.out.println();
//            System.out.print("hello \n");
//            URI uri = new URI(input);
//            URL url = uri.toURL();
//
//
//
//            URLConnection urlc = url.openConnection();
//            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");
//
//            try (BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(urlc.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    if (line.contains("href=")) {
//
//                        // varibles for quote indexes
//                        //hDQ is double quote, and single quote is hsq
//                        int hDQ = line.indexOf("href=\"");
//                        int hSQ = line.indexOf("href='");
//
//                        int start;
//                        char cQ;
//
//                        // 2 patterns work, I cover logic for having a double quote at the end or a single by seeig if the closing and opening quotes are single or double
//                        if (hDQ != -1) {
//
//                            start = hDQ + 6;
//                            cQ = '"';
//                        } else if (hSQ != -1) {
//
//                            start = hSQ + 6;
//                            cQ = '\'';
//                        } else {
//                            //kinda just breaks without this. could do else if else
//                            continue;
//                        }
//
//                        if (start < line.length()) {
//                            String urlC = line.substring(start);
//                            //starts the substring
//                            int end = urlC.indexOf(cQ);
//                            //this didnt work in my last iteration of the file. works now but idk why it didnt. this does the oppisite but it should still have worked.
//                            if (end != -1 || !urlC.substring(0, 2).equals("//")) {
//                                //statusLabel.setText(urlC.substring(0, end));
//                            }
//                            else if (end != -1 || urlC.substring(0, 2).equals("//")) {
//                                //statusLabel.setText(urlC.substring(2, end));
//                            }
//                        }
//                    }
//
//                }
//
//            }
//        }
//        // mabe do multicatch or something specific to iostream and url exceptions
//        catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//
//
//    }




}