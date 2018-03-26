package dajiale.router.zuul.timechecker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TimeChecker {
	public static ThreadLocal<TimeChecker> local = new ThreadLocal<TimeChecker>();
	private static List<List<Long>> all = new LinkedList<List<Long>>();
	
	private long startTime;
	private long endTime;
	private List<Long> times = new LinkedList<Long>();
	private long lastTime;

	public TimeChecker() {
		startTime = lastTime = System.currentTimeMillis();
	}

	public void checkPoint() {
		long now = System.currentTimeMillis();
		times.add(now - lastTime);
		lastTime = now;
	}

	public void record() {
		long now = endTime = System.currentTimeMillis();
		times.add(now - lastTime);
		times.add(endTime - startTime);
		//正常情况下关闭，需要定位的时候，可以开启
//		all.add(this.times);
	}

	public static TimeReport report() {
		if (all.size() == 0) {
			return null;
		}
		TimeReport report = new TimeReport();
		report.mid = repordByPos(new BigDecimal("0.5"));
		report.range90 = repordByPos(new BigDecimal("0.9"));
		report.range95 = repordByPos(new BigDecimal("0.95"));
		report.setRecordCount(all.size());
		return report;
	}

	private static List<Long> repordByPos(BigDecimal pos) {
		int part = all.get(0).size();
		List<List<Long>> copy = new ArrayList<List<Long>>(all);
		
		List<Long> reportSub = new ArrayList<Long>(part);
		for (int i = 0; i < part; i++) {
			List<Long> subAll = new LinkedList<Long>();
			for (int j = 0; j < copy.size(); j++) {
				subAll.add(copy.get(j).get(i));
			}
			Collections.sort(subAll);
			int findPos = pos.multiply(new BigDecimal(subAll.size())).setScale(0, RoundingMode.DOWN).intValue();
			reportSub.add(subAll.get(findPos));
		}
		return reportSub;
	}

	public static void reset() {
		all = new LinkedList<List<Long>>();
	}

	public static class TimeReport {
		private List<Long> mid;
		private List<Long> range90;
		private List<Long> range95;
		private int recordCount;
		public List<Long> getMid() {
			return mid;
		}
		public List<Long> getRange90() {
			return range90;
		}
		public List<Long> getRange95() {
			return range95;
		}
		public void setMid(List<Long> mid) {
			this.mid = mid;
		}
		public void setRange90(List<Long> range90) {
			this.range90 = range90;
		}
		public void setRange95(List<Long> range95) {
			this.range95 = range95;
		}
		/**
		 * @return the recordCount
		 */
        public int getRecordCount() {
	        return recordCount;
        }
		/**
		 * @param recordCount the recordCount to set
		 */
        public void setRecordCount(int recordCount) {
	        this.recordCount = recordCount;
        }
	}

	public static void main(String[] args) {
		List<Long> subAll = new LinkedList<Long>();
		for (long i = 0; i < 100; i++) {
			subAll.add(i);
		}
		int findPos = new BigDecimal("0.9").multiply(new BigDecimal(subAll.size())).setScale(0, RoundingMode.DOWN).intValue();
		System.out.println(findPos);
//		Random r = new Random(System.currentTimeMillis());
//		for (int i = 0; i < 100; i++) {
//			TimeChecker checker = new TimeChecker();
//			try {
//				Thread.sleep(10L + r.nextInt(10));
//			} catch (InterruptedException e) {
//			}
//			checker.checkPoint();
//			try {
//				Thread.sleep(20L + r.nextInt(20));
//			} catch (InterruptedException e) {
//			}
//			checker.record();
//		}
//		System.out.println(JSONObject.fromObject(TimeChecker.report()));
	}
}
