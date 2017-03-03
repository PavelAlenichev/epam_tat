/**
 * Created by berthold on 01.03.2017.
 */
public class Checker implements IChecker {
  private Defineder defineder;
  private String date;
  private String time;
  private TimeChecker timeChecker;
  private DateChecker dateChecker;



  @Override
  public void doCheck(String[] input) {
    if (defineder.defineDate() == -1) {
      date = "";
    } else {
      date = input[defineder.defineDate()];
    }

    if (defineder.defineTime() == -1) {
      time = "";
    } else {
      timeChecker.doCheck(input[defineder.defineTime()]);
    }

  }
}
