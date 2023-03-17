import java.io.*;

public class AlphaDecrypt {
    ED_Ui ref;
    File f;

    AlphaDecrypt(ED_Ui ref) {
        this.ref = ref;
        new OpenDemo(ref, 2, false);
        if (!ref.keyd1.getText().equals("")) {
            ref.alteredContent = "";
            String keyStr = ref.keyd1.getText();
            ref.decrypt_key = Integer.parseInt(keyStr);
            ref.decrypt_key = ref.decrypt_key % 122;
            System.out.println("Decrypt key:- " + ref.decrypt_key);
            for (int i = 0; i < ref.initialContent.length(); i++) {

                int a = ref.initialContent.charAt(i) - ref.decrypt_key;
                System.out.println("INitial" + a);
                if (a < 97) {
                    int fans = ref.initialContent.charAt(i) - 97;
                    fans = ref.decrypt_key - fans;
                    a = 122 - fans + 1;
                }

                System.out.println("Lastly:-" + a);
                char ans = (char) a;
                ref.alteredContent += ans;
            }

            String text = ref.alteredContent;

            byte b[] = text.getBytes();
            f = new File(ref.decryptedWritePath);

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
