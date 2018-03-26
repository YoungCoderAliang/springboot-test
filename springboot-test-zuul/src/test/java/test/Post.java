package test;

import java.io.IOException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.jsoup.Jsoup;

public class Post {
	static {
		try {
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					return true;
				}
			});
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String res = null;
//		res = Jsoup.connect("http://119.23.202.24:1234/rest/common/provincelist/v1").ignoreContentType(true)
//		        .post().body().html();
//		System.out.println(res);
////		
//		res = Jsoup.connect("http://119.23.202.24:1234/rest/common/citylist/v1?param1=abc").data("provinceId", "440000").ignoreContentType(true)
//		        .post().body().html();
//		System.out.println(res);
////	
	res = Jsoup.connect("http://xiandanyouxi.youguanzi.com/rest/common/citylist/v1").data("provinceId", "440000").ignoreContentType(true)
	        .post().body().html();
	System.out.println(res);
////		
		res = Jsoup.connect("https://xiandanyouxi.youguanzi.com/rest/common/citylist/v1").data("provinceId", "440000").ignoreContentType(true)
		        .post().body().html();
		System.out.println(res);
//		
//		res = Jsoup.connect("http://119.23.202.24:1234/rest/game/rank/v1?DJLSID=d49369432c239418180637e238dbbeae").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);
//		
//		res = Jsoup.connect("http://119.23.202.24:1234/rest/game/getgames/v1?DJLSID=d49369432c239418180637e238dbbeae").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);

//		res = Jsoup.connect("http://testdajiale.youguanzi.com/rest/game/data/getround/v1?DJLSID=f2e819713209d8622feb495eeba1e52b&gameId=16&roomId=1178").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);
//		
//		res = Jsoup.connect("http://testdajiale.youguanzi.com/rest/game/data/getround/v1?DJLSID=f2e819713209d8622feb495eeba1e52b&gameId=37&roomId=3568").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);
//
//		res = Jsoup.connect("http://testdajiale.youguanzi.com/rest/game/data/getround/v1?DJLSID=f2e819713209d8622feb495eeba1e52b&gameId=29&roomId=4926").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);
//
//		res = Jsoup.connect("http://localhost/rest/game/data/getround/v1?DJLSID=f2e819713209d8622feb495eeba1e52b&gameId=29&roomId=4926").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);

//		res = Jsoup.connect("http://119.23.26.130/rest/manage/getTimeReport").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);

//		res = Jsoup.connect("http://testdajiale.youguanzi.com/timechecker/get").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);
		
//		res = Jsoup.connect("http://localhost/timechecker/reset").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);
		
//		res = Jsoup.connect("http://localhost/rest/openroom/user/applysocre/v1?DJLSID=0a4c9df760cdf32fbfb3e8291eb96851&roomId=726252&score=100").ignoreContentType(true).post()
//		        .body().html();
//		System.out.println(res);
		
		
	}
	
	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	private static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
		        throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
		        throws java.security.cert.CertificateException {
			return;
		}
	}
}
