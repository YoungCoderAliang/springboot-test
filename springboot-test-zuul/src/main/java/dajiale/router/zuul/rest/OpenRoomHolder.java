package dajiale.router.zuul.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import dajiale.router.zuul.DisConfig;

public class OpenRoomHolder {
	private static Map<String, String> roomToGame = new HashMap<String, String>();
	private static RestTemplate restTemplate = new RestTemplate();

	public static String queryGameId(String openRoomId) {
		if (roomToGame.containsKey(openRoomId)) {
			return roomToGame.get(openRoomId);
		}
		String ip = DisConfig.fromRandom();
		String resp = restTemplate.postForObject("http://" + ip + "/rest/openroom/getGameId?roomId={1}", null, String.class,
		        openRoomId);
		if (resp != null) {
			roomToGame.put(openRoomId, resp);
			return resp;
		}
		return null;
	}
}
