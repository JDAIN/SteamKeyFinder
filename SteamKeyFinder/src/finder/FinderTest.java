package finder;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

public class FinderTest {

  private SteamKeyFinder sut;

  @Before
  public void init() {
    sut = new SteamKeyFinder();
  }

  @Test
  public void testFindSimpleKey() {
    String test = "";
    Assert.assertEquals("A3G43-23ABW-WE23T", sut.findSteamKeys(test));

  }

}