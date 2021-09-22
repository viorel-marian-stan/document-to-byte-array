
import org.apache.commons.io.*;

public class Utils {

    public byte[] process() {

        byte[] rezultat = null;
        String document = "testDocument.docx";

        try {
            rezultat = IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream(document));
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
        return  rezultat;
    }

    public String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    public static void main (String args[]) {

        Utils utils = new Utils();
        byte[] rezultat = utils.process();

        String s = "0x";

        for (int i = 0; i < rezultat.length; i++) {
            s += utils.byteToHex(rezultat[i]).toUpperCase();
        }

        System.out.println(s);

        //write s to DB as varbinary
    }

}
