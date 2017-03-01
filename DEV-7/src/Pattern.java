/**
 * Pattern with which will be compared inputted text
 */
public class Pattern {
  private final String hourFormat = "HH";
  private final int maxHour = 23;
  private final String minuteFormat = "mm";
  private final int maxMinute = 59;
  private final String timeSeparater = ":";

  private final String dayFormat = "dd";
  private final int maxDay = 31;
  private final String monthFormat = "MM";
  private final int maxMonth = 12;
  private final String yearFormat = "yyyy";
  private final String dateSeparator = "-";

  private String timeFormat = 	"^\\d{2}\\:{1}\\d{2}$";
  private String dateFormat = "^\\d{2}\\-\\d{2}\\-\\d{4}$";

  public String getTimeFormat() {
    return timeFormat;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public String getTimeSeparater() {
    return timeSeparater;
  }

  public String getDateSeparator() {
    return dateSeparator;
  }

}