import java.awt.event.*;

import java.awt.*;

//<applet code="ED_Ui" width="900" height="500"></applet>

public class ED_Ui extends Frame implements ActionListener {
    Label encrypt, decrypt, se1, sd1, ke1, kd1;
    TextField et1, et2, dt1, dt2;
    TextField keye1, keyd1;
    String initialContent = "";
    String alteredContent = "";
    String encryptedReadpath = "";
    String encryptedWritePath = "";
    String decryptedReadpath = "";
    String decryptedWritePath = "";
    int no;

    int encrypt_key, decrypt_key;
    int selectedChoice = 0;
    Button eb1, eb2, db2, db1, encryptButton, decryptButton;
    Panel p1, p2, ekey, dkey;
    Choice ec1, dc1;

    ED_Ui() {

        // super(title);

        setLayout(new GridLayout(1, 1));
        p1 = new Panel();
        p2 = new Panel();
        ekey = new Panel();
        dkey = new Panel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        p2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        Panel choose1 = new Panel();
        Panel choose2 = new Panel();
        Panel choose3 = new Panel();
        Panel choose4 = new Panel();

        encrypt = new Label("Encryption");
        et1 = new TextField(40);
        eb1 = new Button("Choose File");

        decrypt = new Label("Decryption");
        dt1 = new TextField(40);
        db1 = new Button("Choose File");

        se1 = new Label("Select Encryption Type:");
        sd1 = new Label("Select Decryption Type:");
        ec1 = new Choice();
        ec1.add("Caeser Cipher");
        ec1.add("Alphabetical Cipher");

        dc1 = new Choice();
        dc1.add("Caeser Cipher");
        dc1.add("Alphabetical Cipher");

        keye1 = new TextField(10);
        keyd1 = new TextField(10);

        ke1 = new Label("Key");
        kd1 = new Label("Key");

        encryptButton = new Button("Encrypt Data");
        decryptButton = new Button("Decrypt Data");

        et2 = new TextField(40);
        eb2 = new Button("Choose File");
        choose3.add(et2);
        choose3.add(eb2);
        dt2 = new TextField(40);
        db2 = new Button("Choose File");
        choose4.add(dt2);
        choose4.add(db2);

        p1.add(encrypt);
        choose1.add(et1);
        choose1.add(eb1);
        p1.add(choose1);
        p1.add(se1);
        p1.add(ec1);
        ekey.add(ke1);
        ekey.add(keye1);
        p1.add(ekey);
        p1.add(choose3);
        p1.add(encryptButton);

        p2.add(decrypt);
        choose2.add(dt1);
        choose2.add(db1);
        p2.add(choose2);
        p2.add(sd1);
        p2.add(dc1);
        dkey.add(kd1);
        dkey.add(keyd1);
        p2.add(dkey);
        p2.add(choose4);
        p2.add(decryptButton);

        add(p1);
        add(p2);
        setSize(900, 500);
        setVisible(true);
        eb1.addActionListener(this);
        eb2.addActionListener(this);
        db1.addActionListener(this);
        db2.addActionListener(this);
        encryptButton.addActionListener(this);
        decryptButton.addActionListener(this);

        this.addWindowListener(new WindowClosingAdapter());
    }

    public static void main(String args[]) {
        new ED_Ui();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == eb1) {
            setText(et1, 1);
        } else if (ae.getSource() == eb2) {
            setText(et2, 2);
        } else if (ae.getSource() == db1) {
            setText(dt1, 3);
        } else if (ae.getSource() == db2) {
            setText(dt2, 4);
        } else if (ae.getSource() == encryptButton) {
            if (ec1.getSelectedIndex() == 0) {
                new CeaserEncrypt(this);
            } else {
                new AlphaEncrypt(this);
            }
        } else if (ae.getSource() == decryptButton) {
            if (dc1.getSelectedIndex() == 0) {
                new CeaserDecrypt(this);
            } else {
                System.out.println("alpha decrypt");
                new AlphaDecrypt(this);
            }
        }
    }

    public void setText(TextField t, int no) {
        this.no = no;
        FileDialog fd = new FileDialog(this, "Open File", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getDirectory() != null && fd.getFile() != null) {

            t.setText(fd.getDirectory() + fd.getFile());
            if (no == 1) {
                encryptedReadpath = fd.getDirectory() + fd.getFile();
            } else if (no == 2) {
                encryptedWritePath = fd.getDirectory() + fd.getFile();
            } else if (no == 3) {
                decryptedReadpath = fd.getDirectory() + fd.getFile();
            } else if (no == 4) {
                decryptedWritePath = fd.getDirectory() + fd.getFile();
            }

        }
    }

}

class WindowClosingAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}