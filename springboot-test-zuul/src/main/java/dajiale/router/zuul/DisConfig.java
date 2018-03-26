package dajiale.router.zuul;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class DisConfig {
	private static Map<Long, String> gameToIp = new HashMap<Long, String>();
	private static Map<Integer, Long> roomToGame = new HashMap<Integer, Long>();
	private static Random random = new Random(System.currentTimeMillis());
	static {
		String ip1 = "10.10.10.81";
		String ip2 = "10.10.10.82";
		String ip3 = "10.10.10.83";
//		String ip1 = "119.23.72.104";
//		String ip2 = "119.23.26.130";
//		String ip3 = "119.23.26.130";
		
		gameToIp.put(16L, ip1);
		gameToIp.put(22L, ip1);
		gameToIp.put(27L, ip2);
		gameToIp.put(29L, ip2);
		gameToIp.put(37L, ip3);
		
		roomToGame.put(10417, 27L);
		roomToGame.put(10835, 29L);
		roomToGame.put(10931, 29L);
		roomToGame.put(11081, 39L);
		roomToGame.put(11283, 45L);
		roomToGame.put(13172, 59L);
		roomToGame.put(13462, 29L);
		roomToGame.put(14124, 22L);
		roomToGame.put(14259, 45L);
		roomToGame.put(15143, 30L);
		roomToGame.put(15487, 37L);
		roomToGame.put(16780, 27L);
		roomToGame.put(18445, 39L);
		roomToGame.put(18867, 59L);
		roomToGame.put(19015, 16L);
		roomToGame.put(19651, 16L);
		roomToGame.put(20372, 22L);
		roomToGame.put(20379, 38L);
		roomToGame.put(20498, 41L);
		roomToGame.put(20852, 45L);
		roomToGame.put(21729, 27L);
		roomToGame.put(22130, 37L);
		roomToGame.put(22659, 30L);
		roomToGame.put(23648, 30L);
		roomToGame.put(23792, 41L);
		roomToGame.put(23953, 37L);
		roomToGame.put(24980, 45L);
		roomToGame.put(25691, 41L);
		roomToGame.put(26777, 41L);
		roomToGame.put(28019, 37L);
		roomToGame.put(29768, 29L);
		roomToGame.put(29854, 39L);
		roomToGame.put(31016, 29L);
		roomToGame.put(32278, 37L);
		roomToGame.put(33842, 38L);
		roomToGame.put(34613, 37L);
		roomToGame.put(35111, 38L);
		roomToGame.put(36154, 39L);
		roomToGame.put(37770, 27L);
		roomToGame.put(37978, 29L);
		roomToGame.put(38926, 38L);
		roomToGame.put(40391, 59L);
		roomToGame.put(41962, 41L);
		roomToGame.put(42734, 45L);
		roomToGame.put(42912, 41L);
		roomToGame.put(43271, 41L);
		roomToGame.put(44424, 59L);
		roomToGame.put(46545, 16L);
		roomToGame.put(46774, 45L);
		roomToGame.put(46959, 45L);
		roomToGame.put(47746, 29L);
		roomToGame.put(48051, 30L);
		roomToGame.put(48464, 41L);
		roomToGame.put(48631, 22L);
		roomToGame.put(49033, 38L);
		roomToGame.put(49072, 59L);
		roomToGame.put(51669, 37L);
		roomToGame.put(52231, 22L);
		roomToGame.put(52486, 45L);
		roomToGame.put(52487, 22L);
		roomToGame.put(54200, 16L);
		roomToGame.put(54634, 16L);
		roomToGame.put(55444, 27L);
		roomToGame.put(55871, 30L);
		roomToGame.put(56160, 30L);
		roomToGame.put(56899, 45L);
		roomToGame.put(61571, 16L);
		roomToGame.put(63352, 39L);
		roomToGame.put(63621, 59L);
		roomToGame.put(63914, 22L);
		roomToGame.put(64236, 59L);
		roomToGame.put(66188, 30L);
		roomToGame.put(67176, 27L);
		roomToGame.put(70493, 30L);
		roomToGame.put(70525, 29L);
		roomToGame.put(70670, 38L);
		roomToGame.put(71643, 41L);
		roomToGame.put(71844, 37L);
		roomToGame.put(72018, 27L);
		roomToGame.put(72995, 37L);
		roomToGame.put(73894, 38L);
		roomToGame.put(74299, 59L);
		roomToGame.put(74764, 27L);
		roomToGame.put(74998, 59L);
		roomToGame.put(76968, 22L);
		roomToGame.put(77716, 39L);
		roomToGame.put(78226, 38L);
		roomToGame.put(79092, 22L);
		roomToGame.put(79903, 59L);
		roomToGame.put(80687, 29L);
		roomToGame.put(81943, 22L);
		roomToGame.put(83357, 39L);
		roomToGame.put(83448, 41L);
		roomToGame.put(84817, 16L);
		roomToGame.put(84885, 39L);
		roomToGame.put(85040, 38L);
		roomToGame.put(85471, 30L);
		roomToGame.put(85476, 29L);
		roomToGame.put(85615, 16L);
		roomToGame.put(87529, 38L);
		roomToGame.put(88841, 27L);
		roomToGame.put(89480, 37L);
		roomToGame.put(90121, 30L);
		roomToGame.put(91820, 39L);
		roomToGame.put(91886, 27L);
		roomToGame.put(95163, 22L);
		roomToGame.put(96779, 39L);
		roomToGame.put(97050, 45L);
		roomToGame.put(98245, 16L);
		roomToGame.put(98979, 16L);
	}
	
	public static String fromRoom(String roomId) {
		return gameToIp.get(roomToGame.get(Integer.parseInt(roomId)));
	}
	
	public static String fromGame(String gameId) {
		return gameToIp.get(Long.parseLong(gameId));
	}
	
	public static String fromRandom() {
		Set<String> set = new HashSet<String>(gameToIp.values());
		return set.toArray(new String[set.size()])[random.nextInt(set.size())];
	}
	
	public static String[] allIp() {
		Set<String> set = new HashSet<String>(gameToIp.values());
		return set.toArray(new String[set.size()]);
	}
}
