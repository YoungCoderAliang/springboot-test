package dajiale.router.zuul.rest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

public class GameConfigApp implements Serializable {
	private String gameId; // 该指数模式配置下的游戏id
	private String type; // 指数名
	private String showName;
	private String picUrl;
	private int userNumber = 0;

	private String[] timeDispatch = new String[] { "13", "25", "2", "5" }; // 局内时间分配，单位s
	private List<Odds> odds; // 赔率设置
	private String timeMark;
	
	public static class Odds implements Serializable {
		private String winCond; // 获胜条件
		private String odds; // 赔率

		public String getWinCond() {
			return winCond;
		}

		public String getOdds() {
			return odds;
		}

		public void setWinCond(String winCond) {
			this.winCond = winCond;
		}

		public void setOdds(String odds) {
			this.odds = odds;
		}
	}
	
	public GameConfigApp() {
	}

	public String getType() {
		return type;
	}

	public String[] getTimeDispatch() {
		return timeDispatch;
	}

	public List<Odds> getOdds() {
		return odds;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTimeDispatch(String[] timeDispatch) {
		this.timeDispatch = timeDispatch;
	}

	public void setOdds(List<Odds> odds) {
		this.odds = odds;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getPicUrl() {
		return picUrl;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String toString() {
		return gameId + "-" + type + "-" + showName + "-" + Joiner.on(',').join(Arrays.asList(timeDispatch));
	}

	/**
	 * @return the timeMark
	 */
    public String getTimeMark() {
        return timeMark;
    }

	/**
	 * @param timeMark the timeMark to set
	 */
    public void setTimeMark(String timeMark) {
        this.timeMark = timeMark;
    }
}