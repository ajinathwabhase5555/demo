/**
 * 
 */
package com.bomweb.insurance;

/**
 * @author SACHIN
 *
 */
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import javax.net.ssl.HttpsURLConnection;

public class HttpClientExample {

    public static void main(String[] args) {
    	
    	byte[] isoresponse = getFingerArray();
    	System.out.println(new String(isoresponse));
        try {
            HttpClientExample hce = new HttpClientExample();
            String body = hce.post("http://125.18.108.188:7003/Servlet/TSPGenericServiceProcessor", new String(isoresponse));
            System.out.println(body);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String post(String postUrl, String data) throws IOException {
        URL url = new URL(postUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        con.setDoOutput(true);

        this.sendData(con, data);

        return this.read(con.getInputStream());
    }

    protected void sendData(HttpURLConnection con, String data) throws IOException {
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();
        } catch(IOException exception) {
            throw exception;
        } finally {
            this.closeQuietly(wr);
        }
    }

    private String read(InputStream is) throws IOException {
        BufferedReader in = null;
        String inputLine;
        StringBuilder body;
        try {
            in = new BufferedReader(new InputStreamReader(is));

            body = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                body.append(inputLine);
            }
            in.close();

            return body.toString();
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            this.closeQuietly(in);
        }
    }

    protected void closeQuietly(Closeable closeable) {
        try {
            if( closeable != null ) {
                closeable.close();
            }
        } catch(IOException ex) {

        }
    }
    
    public static byte[] getFingerArray() {
		byte[] fingerArray = null;
		try {

			File file = new File("E://BOM/Enrollment/Insurance");
			if (file.isDirectory()) {
				File[] files = file.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.toLowerCase().endsWith(".xml");
					}
				});
				file = files[0];
			}
			if (file.exists()) {
				FileInputStream in = new FileInputStream(file);
				fingerArray = new byte[(int) file.length()];
				in.read(fingerArray);
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fingerArray;
	}
}
