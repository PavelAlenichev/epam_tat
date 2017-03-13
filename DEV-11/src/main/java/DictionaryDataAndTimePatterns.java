/**
 * Class with dictionary of data and time patterns 
 */
public class DictionaryDataAndTimePatterns {

    private String[][] dictionaryDateFormatting = new String[49][3];

  /**
   * Method with initalization dictionary of data and time patterns 
   */
  public void init(){
    dictionaryDateFormatting[0][0] = "d";
    dictionaryDateFormatting[0][1] = "d";
    dictionaryDateFormatting[1][0] = "dd";
    dictionaryDateFormatting[1][1] = "dd";
    dictionaryDateFormatting[2][0] = "ddd";
    dictionaryDateFormatting[2][1] = "E";
    dictionaryDateFormatting[3][0] = "dddd";
    dictionaryDateFormatting[3][1] = "EEEE";
    dictionaryDateFormatting[4][0] = "f";
    dictionaryDateFormatting[4][1] = "S";
    dictionaryDateFormatting[5][0] = "ff";
    dictionaryDateFormatting[5][1] = "SS";
    dictionaryDateFormatting[6][0] = "fff";
    dictionaryDateFormatting[6][1] = "SSS";
    dictionaryDateFormatting[7][0] = "ffff";
    dictionaryDateFormatting[7][1] = "SSSS";
    dictionaryDateFormatting[8][0] = "fffff";
    dictionaryDateFormatting[8][1] = "SSSSS";
    dictionaryDateFormatting[9][0] = "ffffff";
    dictionaryDateFormatting[9][1] = "SSSSSS";
    dictionaryDateFormatting[10][0] = "fffffff";
    dictionaryDateFormatting[10][1] = "SSSSSSS";
    dictionaryDateFormatting[11][0] = "F";
    dictionaryDateFormatting[11][1] = "S";
    dictionaryDateFormatting[12][0] = "FF";
    dictionaryDateFormatting[12][1] = "SS";
    dictionaryDateFormatting[13][0] = "FFF";
    dictionaryDateFormatting[13][1] = "SSS";
    dictionaryDateFormatting[14][0] = "FFFF";
    dictionaryDateFormatting[14][1] = "SSSS";
    dictionaryDateFormatting[15][0] = "FFFFF";
    dictionaryDateFormatting[15][1] = "SSSSS";
    dictionaryDateFormatting[16][0] = "FFFFFF";
    dictionaryDateFormatting[16][1] = "SSSSSS";
    dictionaryDateFormatting[17][0] = "FFFFFFF";
    dictionaryDateFormatting[17][1] = "SSSSSSS";
    dictionaryDateFormatting[18][0] = "g";
    dictionaryDateFormatting[18][1] = "G";
    dictionaryDateFormatting[19][0] = "gg";
    dictionaryDateFormatting[19][1] = "GG";
    dictionaryDateFormatting[20][0] = "h";
    dictionaryDateFormatting[20][1] = "h";
    dictionaryDateFormatting[21][0] = "hh";
    dictionaryDateFormatting[21][1] = "hh";
    dictionaryDateFormatting[22][0] = "H";
    dictionaryDateFormatting[22][1] = "H";
    dictionaryDateFormatting[23][0] = "HH";
    dictionaryDateFormatting[23][1] = "HH";
    dictionaryDateFormatting[24][0] = "K";
    dictionaryDateFormatting[24][1] = "XXX";
    dictionaryDateFormatting[25][0] = "m";
    dictionaryDateFormatting[25][1] = "m";
    dictionaryDateFormatting[26][0] = "mm";
    dictionaryDateFormatting[26][1] = "mm";
    dictionaryDateFormatting[27][0] = "M";
    dictionaryDateFormatting[27][1] = "M";
    dictionaryDateFormatting[28][0] = "MM";
    dictionaryDateFormatting[28][1] = "MM";
    dictionaryDateFormatting[29][0] = "MMM";
    dictionaryDateFormatting[29][1] = "MMM";
    dictionaryDateFormatting[30][0] = "MMMM";
    dictionaryDateFormatting[30][1] = "MMMM";
    dictionaryDateFormatting[31][0] = "s";
    dictionaryDateFormatting[31][1] = "s";
    dictionaryDateFormatting[32][0] = "ss";
    dictionaryDateFormatting[32][1] = "ss";
    dictionaryDateFormatting[33][0] = "t";
    dictionaryDateFormatting[33][1] = "a";
    dictionaryDateFormatting[34][0] = "tt";
    dictionaryDateFormatting[34][1] = "aa";
    dictionaryDateFormatting[35][0] = "Y";
    dictionaryDateFormatting[35][1] = "Y";
    dictionaryDateFormatting[36][0] = "YY";
    dictionaryDateFormatting[36][1] = "YY";
    dictionaryDateFormatting[37][0] = "YYY";
    dictionaryDateFormatting[37][1] = "YYY";
    dictionaryDateFormatting[38][0] = "YYYY";
    dictionaryDateFormatting[38][1] = "YYYY";
    dictionaryDateFormatting[39][0] = "YYYYY";
    dictionaryDateFormatting[39][1] = "YYYYY";
    dictionaryDateFormatting[40][0] = "z";
    dictionaryDateFormatting[40][1] = "X";
    dictionaryDateFormatting[41][0] = "zz";
    dictionaryDateFormatting[41][1] = "X";
    dictionaryDateFormatting[42][0] = "zzz";
    dictionaryDateFormatting[42][1] = "XXX";
    dictionaryDateFormatting[43][0] = ":";
    dictionaryDateFormatting[43][1] = ":";
    dictionaryDateFormatting[44][0] = "/";
    dictionaryDateFormatting[44][1] = "/";
    dictionaryDateFormatting[45][0] = "\"";
    dictionaryDateFormatting[45][1] = "\"";
    dictionaryDateFormatting[46][0] = "\'";
    dictionaryDateFormatting[46][1] = "\'";
    dictionaryDateFormatting[47][0] = "%";
    dictionaryDateFormatting[47][1] = "%";
    dictionaryDateFormatting[48][0] = "\\";
    dictionaryDateFormatting[48][1] = "\\";
  }

  /**
   * Method for return dictionary of data and time patterns 
   * return String[][] 
   */
  public String[][] get() {
    return dictionaryDateFormatting;
  }
}
