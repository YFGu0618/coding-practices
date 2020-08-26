package google;

import java.util.LinkedList;
import java.util.List;

public class MyRequestCounter implements RequestCounter {
  private List<Long> queue = new LinkedList<>();
  private long lastTs = System.nanoTime();
  private long counter = 0;
  private static final long SEC = 1000000000;

  public void increment() {
    long ts = System.nanoTime();
    int interval = Math.toIntExact((ts - lastTs) / SEC);
    if (interval < 1) {
      counter++;
      return;
    } else {
      queue.add(counter);
      counter = 0;
      for (int i = 1; i < interval; i++) {
        queue.add(0L);
      }
      while (queue.size() > 24 * 3600) {
        queue.remove(0);
      }
    }
  }

  public long lastMinute() {
    final List<Long> q = queue;
    long req = 0;
    for (int i = 0; i < 60 && q.size() - i >= 0; i++) {
      req += q.get(q.size() - i);
    }
    return req;
  }

  public long lastHour() {
    final List<Long> q = queue;
    long req = 0;
    for (int i = 0; i < 3600 && q.size() - i >= 0; i++) {
      req += q.get(q.size() - i);
    }
    return req;
  }

  public long lastDay() {
    final List<Long> q = queue;
    long req = 0;
    for (int i = 0; i < q.size(); i++) {
      req += q.get(i);
    }
    return req;
  }
}
