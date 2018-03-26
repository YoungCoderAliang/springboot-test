package dajiale.router.zuul.rest;

import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dajiale.router.zuul.DisConfig;
import dajiale.router.zuul.rest.GameConfigApp.Odds;
import dajiale.router.zuul.timechecker.TimeChecker;
import dajiale.router.zuul.timechecker.TimeChecker.TimeReport;

@RestController
public class SpecialHandlerController {
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = { "/rest/game/getgames/v1", "/rest/openroom/getgames/v1" }, method = RequestMethod.POST)
	public SimpleResponse<List<GameConfigApp>> getGames() {
		String[] ips = DisConfig.allIp();
		List<GameConfigApp> list = new LinkedList<GameConfigApp>();
		for (String ip : ips) {
			try {
				SimpleResponse res = restTemplate.postForObject("http://" + ip + "/rest/game/getgames/v1", null,
				        SimpleResponse.class);
				if (res.success()) {
					List<GameConfigApp> ret = JSONArray.toList(JSONArray.fromObject(res.getData()), GameConfigApp.class);
					for (GameConfigApp config : ret) {
						config.setOdds(JSONArray.toList(JSONArray.fromObject(config.getOdds()), Odds.class));
					}
					list.addAll(ret);
				}
			} catch (Exception e) {
			}
		}
		return new SimpleResponse<List<GameConfigApp>>(list);
	}

	@RequestMapping(value = { "/rest/manage/getgames/v1" }, method = { RequestMethod.POST, RequestMethod.GET })
	public SimpleResponse<List<GameManageInfo>> reportGames(@RequestParam(value = "managekey") String managekey) {
		String[] ips = DisConfig.allIp();
		List<GameManageInfo> list = new LinkedList<GameManageInfo>();
		for (String ip : ips) {
			try {
				SimpleResponse res = restTemplate.postForObject("http://" + ip + "/rest/manage/getgames/v1?managekey={1}",
				        null, SimpleResponse.class, managekey);
				if (res.success()) {
					List<GameManageInfo> ret = JSONArray.toList(JSONArray.fromObject(res.getData()), GameManageInfo.class);
					list.addAll(ret);
				}
			} catch (Exception e) {
			}
		}
		return new SimpleResponse<List<GameManageInfo>>(list);
	}

	@RequestMapping(value = { "/timechecker/get" }, method = { RequestMethod.POST, RequestMethod.GET })
	public SimpleResponse<TimeReport> gettimechecker() {
		return new SimpleResponse<TimeReport>(TimeChecker.report());
	}

	@RequestMapping(value = { "/timechecker/reset" }, method = { RequestMethod.POST, RequestMethod.GET })
	public SimpleResponse<Void> resettimechecker() {
		TimeChecker.reset();
		return new SimpleResponse<Void>();
	}
}
