package at.struct.was9bugs.bug22.app2;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.io.pem.PemReader;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Enumeration;
import java.util.logging.Logger;

public class App2Servlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(App2Servlet.class.getName());

    private static final String PRIV_KEY = "-----BEGIN RSA PRIVATE KEY-----\n" +
                                           "MIICXAIBAAKBgQC543qJ49TTbu6XZwBgfT/OqniFJSfyN4EsJZsm0FQbw3wpD8p8\n" +
                                           "79Qvfg/qXMGoXWqmwwP/pPb032htBFt2ddm2iBsggPYWj1+s4zSomnrvCQ/qsURb\n" +
                                           "X9GWNhXZOtbJuL04B/tYghYSCG21uYuSRjxpMzS5BLRrtQ/Ssk0sUzaD/wIDAQAB\n" +
                                           "AoGBAIm2ZQnSp9Eb1daEkFrrb2IEGNVK+ZUQWboDAjZ3EFihMlKZSEHWyzOECPZv\n" +
                                           "UWkSC/kPcN7rr6kp+YsKN1hDZs33B/tr8lsapNqNAkD8l0+Y+FfExDbeAFELAjmu\n" +
                                           "zyMlg4J3Y94TrRCfkbBW4Je+1uAZPFrU/qj/Q0bgt/dQENyBAkEA7d2ftNAPIgO5\n" +
                                           "A6S2xP7MA86H6ze9rf5WcbOVoVcls6LP0RoFVGbfeYi361i9D/DiJy09vcoe6lSm\n" +
                                           "7od+5KBJeQJBAMgPbYq8lH+KJ//5fljLaoROgBrlyi88Pnvw2vEQL8kAYZOapFaV\n" +
                                           "fHphzqS6qjCbmADeq6b0byOANf5pIYP40zcCQC2WG9V7Smsqa3rXRm/apR7Vphbe\n" +
                                           "R+vgopCH6lVRblhPC6T3Z64VSR7xpM3l49X6RF1dvkdxRRuDvbpZHWiTj4ECQBpd\n" +
                                           "liUrlzJ7xavBeLpBDKelJNLmp8+z09RHuML+TB3kU/e88J2Mk9wZGb+x7g3743tx\n" +
                                           "3RNisWbvVa5Ssp0O5N8CQETCSf025dMSUB0vB15qokuIp9wi/MqyjxReJF9uIoe8\n" +
                                           "g4cjvexBmwhINPLSauh0ks101YCi+GYwBv02b5SSG+U=\n" +
                                           "-----END RSA PRIVATE KEY-----";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);

        try(PemReader reader = new PemReader(new StringReader(PRIV_KEY))) {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = factory.generatePrivate(new PKCS8EncodedKeySpec(reader.readPemObject().getContent()));

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey, new SecureRandom());

            byte[] input = "Encrypt me".getBytes(StandardCharsets.UTF_8);
            byte[] encodedByte = Base64.encode(cipher.doFinal(input));


            PrintWriter writer = resp.getWriter();
            writer.println(new String(encodedByte, StandardCharsets.UTF_8));

            printInfo(writer);
            writer.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            logger.info("Starting Installing BC Provider...");
            Security.addProvider(new BouncyCastleProvider());
            logger.info("Done Installing BC Provider...");
        }
    }

    private void printInfo(PrintWriter pw) {
        pw.println(BouncyCastleProvider.class.getClassLoader().toString());

        String bcName = BouncyCastleProvider.class.getName().replace(".", "/") + ".class";
        try {
            pw.println("BC Classloader:");
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(bcName);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                pw.println("\t" + url.toExternalForm());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
