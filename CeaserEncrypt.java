import java.io.*;

public class CeaserEncrypt {
    ED_Ui ref;
    File f;

    CeaserEncrypt(ED_Ui ref) {
        this.ref = ref;
        new OpenDemo(ref, 1, false);
        if (!ref.keye1.getText().equals("")) {
            String keyStr = ref.keye1.getText();
            ref.encrypt_key = Integer.parseInt(keyStr);
            for (int i = 0; i < ref.initialContent.length(); i++) {
                ref.encrypt_key = ref.encrypt_key % 127;
                int a = ref.initialContent.charAt(i) + ref.encrypt_key;
                System.out.println(a);
                a = a % 127;
                char ans = (char) a;
                ref.alteredContent += ans;
            }

            String text = ref.alteredContent;

            byte b[] = text.getBytes();
            f = new File(ref.encryptedWritePath);

            try {
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(b);
                fo.close();
                ref.initialContent = "";
                ref.alteredContent = "";
            } catch (FileNotFoundException fe) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("Some Error occured!");
            }

        } else {
            System.out.println("Enter a key");
        }

    }
}
