import java.io.*;

public class CeaserDecrypt {
    ED_Ui ref;
    File f;

    CeaserDecrypt(ED_Ui ref) {
        this.ref = ref;
        new OpenDemo(ref, 2, true);
        if (!ref.keyd1.getText().equals("")) {
            ref.alteredContent = "";
            String keyStr = ref.keyd1.getText();
            ref.decrypt_key = Integer.parseInt(keyStr);
            for (int i = 0; i < ref.initialContent.length(); i++) {
                ref.decrypt_key = ref.decrypt_key % 127;
                int a = ref.initialContent.charAt(i) - ref.decrypt_key;

                if (a < 0) {
                    a = a + 127;
                }

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
