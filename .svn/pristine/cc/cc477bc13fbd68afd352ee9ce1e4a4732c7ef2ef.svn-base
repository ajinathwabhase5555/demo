package com.bomweb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

import com.bomweb.service.model.PushEnrollment_IN;

/**
 * @author SACHIN
 *
 */
public class UploadEnrollment {

	private static InputStream responseStream;

	public static String uploadEnrollFileToServer(File file, PushEnrollment_IN in) {
		String response = null;
		try {
			SSLContextBuilder sbuilder = new SSLContextBuilder();
			sbuilder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			});

			SSLConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sbuilder.build(),
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSF).build();

			MultipartEntityBuilder mbuilder = MultipartEntityBuilder.create();
			mbuilder.addTextBody("stTerminal", in.getTerminalID());
			mbuilder.addTextBody("stvendorId", in.getVendorID());
			mbuilder.addTextBody("stAgentID", in.getAgentID());
			mbuilder.addTextBody("stEKYCFlag", in.geteKYCFlag());
			mbuilder.addPart("filenames", new StringBody(in.getRrn()+".txt", ContentType.create("text/plain",Consts.UTF_8)));
			mbuilder.addBinaryBody("file", file,ContentType.DEFAULT_BINARY,file.getName());
			
			HttpEntity entity = mbuilder.build();
			HttpPost httpPost = new HttpPost("http://125.18.108.188:7003/Servlet/VendorDataUploadServlet");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);

			System.out.println("CODE ::::response HTTP CLIENT:::::::: " + httpResponse);
			if (httpResponse != null) {
				HttpEntity responseEntity = httpResponse.getEntity();
				System.out.println("Response Entity:::::::::BANK SERVER::::: " + responseEntity);
				if (responseEntity != null) {
					responseStream = responseEntity.getContent();
					if (responseStream != null) {
						BufferedReader br = new BufferedReader(new InputStreamReader(responseStream));
						String responseLine = br.readLine();
						String tempResponseString = "";
						while (responseLine != null) {
							tempResponseString = tempResponseString + responseLine + "\n";
							System.out.println("Response String::::::::::::::: " + tempResponseString.toString());
							responseLine = br.readLine();
						}
						br.close();
						if (tempResponseString.length() > 0)
							response = tempResponseString;
					}
				}
			}
		} catch (Exception exception) {
			response = "Failed to upload!";
			System.out.println("Error while sending files : " + exception);
		} finally {
			// write code to release the DB connections
		}
		return response;
	}

}
