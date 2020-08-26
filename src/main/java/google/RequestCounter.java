package google;

public interface RequestCounter {
  public void increment();

  public long lastMinute();

  public long lastHour();

  public long lastDay();
}
