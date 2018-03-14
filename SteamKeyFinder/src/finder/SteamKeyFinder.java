package finder;

/**
 * caps = 5 buchstaben + Zahlen "-" 5 buchstaben + Zahlen "-" 5 buchstaben + Zahlen.
 * 
 * @author JDAIN
 *
 */
public class SteamKeyFinder {
  static int useCounter = 1;

  /**
   * Checks for SteamKeys
   * 
   * @param input
   *          some Random text.
   * @return raw SteamKeys
   */
  public String findSteamKeys(String input) {
    useCounter++;
    StringBuilder result = new StringBuilder();

    String[] steamKeys = new String[input.length()]; // steamkey 15 chars
    int charCounter = 0; // should be 5
    int connectorCounter = 0; // should be 2
    int keyCounter = 0;
    StringBuilder keyReader = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      keyReader.append(input.charAt(i));

      if (Character.isUpperCase(input.charAt(i)) || Character.isDigit(input.charAt(i))) {
        charCounter++;

        if ((i < input.length() - 1)) {
          if (charCounter == 5 && input.charAt(i + 1) == '-') {
            connectorCounter++;
            charCounter = 0;
          }
        }

        if (charCounter == 5 && connectorCounter == 2) { // it is a SteamKey

          connectorCounter = 0; // should be 2
          steamKeys[keyCounter] = keyReader.substring(keyReader.length() - 17, keyReader.length());

          keyCounter++;
        }

        if (charCounter == 5) {
          charCounter = 0;
        }
      } else {
        charCounter = 0;
        if (connectorCounter == 2 && !(input.charAt(i) == '-')) {
          connectorCounter = 0;
        }

      }
    }
    for (int j = 0; j < steamKeys.length; j++) {
      if (steamKeys[j] != null) {
        result.append(steamKeys[j] + " , ");
      }
    }
    // return result.toString();
    return result.toString();
  }

}
