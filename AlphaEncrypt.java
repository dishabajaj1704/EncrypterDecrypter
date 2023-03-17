import java.io.*;

public class AlphaEncrypt {
    ED_Ui ref;
    File f;

    AlphaEncrypt(ED_Ui ref) {
        this.ref = ref;
        new OpenDemo(ref, 1, true);
        if (!ref.keye1.getText().equals("")) {
            String keyStr = ref.keye1.getText();
            ref.encrypt_key = Integer.parseInt(keyStr);
            ref.encrypt_key = ref.encrypt_key % 122;
            for (int i = 0; i < ref.initialContent.length(); i++) {
                if (ref.initialContent.charAt(i) >= 97 && ref.initialContent.charAt(i) <= 122) {
                    int a = ref.initialContent.charAt(i) + ref.encrypt_key;
                    System.out.println(a);
                    if (a > 122) {
                        a = a % 122;
                        int fans = 97 + a - 1;
                        char ans = (char) fans;
                        ref.alteredContent += ans;
                    } else {
                        ref.alteredContent += (char) a;
                    }
                } else {
                    continue;
                }
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
