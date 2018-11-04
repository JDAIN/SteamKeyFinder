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
    String test = "asda213123hfgh34252jhgj45645456rthhtryh45645rfhgA3G43-23ABW-WE23Tasdadasdasd23421423sfaasdadasdadadadadasdadada";
    Assert.assertEquals("A3G43-23ABW-WE23T"+" , ", sut.findSteamKeys(test));
  }

  @Test 
  public void testNoTextNoKey() {
	  String test ="";
	  Assert.assertEquals("", sut.findSteamKeys(test));
  }
  
  @Test 
  public void testNoKey() {
	  String test ="Halloadasd1 was -asdfsaf-4345345-sdfa234a0s-sfsadf asdf adfsaf sfasf asdfa ";
	  Assert.assertEquals("", sut.findSteamKeys(test));
  }
}