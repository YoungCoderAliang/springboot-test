package dajiale.router.zuul;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import dajiale.router.zuul.rest.OpenRoomHolder;
import dajiale.router.zuul.timechecker.TimeChecker;
import dajiale.router.zuul.timechecker.TimeCheckerPostZuulFilter;
import dajiale.router.zuul.timechecker.TimeCheckerPreZuulFilter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class GameServiceZuulServer {
	private static Logger logger = LoggerFactory.getLogger(GameServiceRouteLocator.class);

	@Autowired
	protected ZuulProperties zuulProperties;
	@Autowired
	protected ServerProperties server;

	public static void main(String[] args) {
		// java -jar -Xms400m -Xmx800m -Dspring.profiles.active=http /home/dajialehttp/dajiale-router-zuul-1.5.9.RELEASE.jar
		// java -jar -Xms400m -Xmx800m -Dspring.profiles.active=https /home/dajialehttps/dajiale-router-zuul-1.5.9.RELEASE.jar
		SpringApplication.run(GameServiceZuulServer.class, args);
	}

	@Bean
	public RouteLocator gameServiceRouter() {
		return new GameServiceRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
	}
	
	@Bean 
	public ZuulFilter timeCheckerPreZuulFilter() {
		return new TimeCheckerPreZuulFilter();
	}
	
	@Bean 
	public ZuulFilter timeCheckerPostZuulFilter() {
		return new TimeCheckerPostZuulFilter();
	}

	public static class GameServiceRouteLocator extends SimpleRouteLocator {
		public GameServiceRouteLocator(String servletPath, ZuulProperties properties) {
			super(servletPath, properties);
		}

		@Override
		public Route getMatchingRoute(final String path) {
			TimeChecker tc = TimeChecker.local.get();
			if (tc != null) {
				tc.checkPoint();
			}
			HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
			String uri = request.getRequestURI();
			Map<String, String[]> params = request.getParameterMap();
			String ip = null;
			if (uri.contains("/rest/game")) {
				if (uri.contains("/rest/game/getgames/v1")) {
					return null;
				}
				if (params.containsKey("gameId")) {
					ip = DisConfig.fromGame(params.get("gameId")[0]);
				} else if (params.containsKey("roomId")) {
					ip = DisConfig.fromRoom(params.get("roomId")[0]);
				} else {
					ip = DisConfig.fromRandom();
				}
			} else if (uri.contains("/rest/openroom")) {
				if (uri.contains("/rest/openroom/getgames/v1")) {
					return null;
				}
				if (params.containsKey("gameId")) {
					ip = DisConfig.fromGame(params.get("gameId")[0]);
				} else if (params.containsKey("roomId")) {
					ip = DisConfig.fromGame(OpenRoomHolder.queryGameId(params.get("roomId")[0]));
				} else {
					ip = DisConfig.fromRandom();
				}
			} else if (uri.contains("/rest/manage")) {
				if (uri.contains("/rest/manage/getgames/v1")) {
					return null;
				}
				if (params.containsKey("gameId")) {
					if (params.get("gameId")[0] != null) {
						ip = DisConfig.fromGame(params.get("gameId")[0]);
					} else {
						// 暂时不处理这种类型：查看所有房间
						ip = DisConfig.fromRandom();
					}
				} else if (uri.contains("/rest/manage/suspendroom/v1") || uri.contains("/rest/manage/recoverroom/v1")) {
					ip = DisConfig.fromGame(OpenRoomHolder.queryGameId(params.get("roomId")[0]));
				} else if (params.containsKey("roomId")) {
					ip = DisConfig.fromRoom(params.get("roomId")[0]);
				} else {
					ip = DisConfig.fromRandom();
				}
			} else {
				ip = DisConfig.fromRandom();
			}
			if (tc != null) {
				tc.checkPoint();
			}
			return new Route("all-rule", path, "http://" + ip, "", false, null);
		}
	}
}
