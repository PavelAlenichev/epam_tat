/**
 * Some interface IKeeper defines structure of data and some methods to work with it
 */
public interface IKeeper {

  /**
   * @return some information
   */
   public String getInformation();

  /**
   * put some information in structure
   *
   * @param data
   */
   public void putInformation(String data);

  /**
   * set some large part of information
   *
   * @param section
   */
   public void setSection(String section);
}