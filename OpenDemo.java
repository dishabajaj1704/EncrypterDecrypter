import java.awt.*;
import java.io.*;;

class OpenDemo extends Frame {
    ED_Ui ref;
    TextField t;

    public OpenDemo(ED_Ui ref, int what, boolean alpha) {
        this.ref = ref;
        // if (!ref.readpath.equals("")) {
        String text;
        String path = "";
        this.ref = ref;
        if (what == 1) {
            path = ref.encryptedReadpath;
        } else if (what == 2) {
            path = ref.decryptedReadpath;
        }

        File f = new File(path);
        try {
            FileInputStream fi = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fi));
            ref.initialContent = "";
            while ((text = br.readLine()) != null) {
                ref.initialContent += text;
            }
            System.out.println(ref.initialContent);
            if (alpha == true) {
                ref.initialContent = ref.initialContent.replace(" ", "");
                ref.initialContent = ref.initialContent.toLowerCase();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Some Error occured!");
        }

    }

}
