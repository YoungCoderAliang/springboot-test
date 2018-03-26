package dajiale.router.zuul.rest;

import java.io.Serializable;

public class GameManageInfo implements Serializable {
	private String gameId;
	private String threadId;
	private String threadName;
	private String threadStatus;
	private String gameStatus;
	private boolean shouldStopFlag;
	public String getThreadId() {
		return threadId;
	}
	public String getThreadName() {
		return threadName;
	}
	public String getThreadStatus() {
		return threadStatus;
	}
	public String getGameStatus() {
		return gameStatus;
	}
	public boolean isShouldStopFlag() {
		return shouldStopFlag;
	}
	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public void setThreadStatus(String threadStatus) {
		this.threadStatus = threadStatus;
	}
	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}
	public void setShouldStopFlag(boolean shouldStopFlag) {
		this.shouldStopFlag = shouldStopFlag;
	}
	/**
	 * @return the gameId
	 */
    public String getGameId() {
        return gameId;
    }
	/**
	 * @param gameId the gameId to set
	 */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}