/**
 * @brief {A set of test cases for the MyCustomString class}
 *
 * Mae B. Morella
 * SWE 3643 – Assignment 4
 */

package edu.kennesaw.seclass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class MyCustomStringTest {
  private MyCustomStringInterface myCustomstring;

  @BeforeEach
  public void setUp() {
    myCustomstring = new MyCustomString();
  }

  @AfterEach
  public void tearDown() {
    myCustomstring = null;
  }

  @Test
  public void testCountNumbers1() {
    myCustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
    assertEquals(9, myCustomstring.countNumbers());
  }

  @Test
  public void testCountNumbers2() {
    myCustomstring.setString("this string contains zero numbers.");
    assertEquals(0, myCustomstring.countNumbers());
  }

  @Test
  public void testCountNumbers3() {
    myCustomstring.setString("0 1 2 3 4 5 6 7 8 9");
    assertEquals(10, myCustomstring.countNumbers());
  }

  @Test
  public void testCountNumbers4() {
    assertEquals(0, myCustomstring.countNumbers());
  }

  @Test
  public void testCountNumbers5() {
    myCustomstring.setString("");
    assertEquals(0, myCustomstring.countNumbers());
  }

  @Test
  public void testCountNumbers6() {
    myCustomstring.setString("9");
    assertEquals(1, myCustomstring.countNumbers());
  }

  @Test
  public void testReverseNCharacters1() {
    myCustomstring.setString("Peter Piper picked a peck of pickled peppers.");
    assertEquals(
      "etePiP r repkcipa decep fo kcip delkpep srep.",
      myCustomstring.reverseNCharacters(4, false)
    );
  }

  @Test
  public void testReverseNCharacters2() {
    myCustomstring.setString("Peter Piper picked a peck of pickled peppers.");
    assertEquals(
      "etePiP r repkcipa decep fo kcip delkpep srepXXX.",
      myCustomstring.reverseNCharacters(4, true)
    );
  }

  @Test
  public void testReverseNCharacters3() {
    myCustomstring.setString("a");
    assertEquals("a", myCustomstring.reverseNCharacters(1, false));
  }

  @Test
  public void testReverseNCharacters4() {
    myCustomstring.setString("string shorter than segment length");
    assertEquals(
      "htgnel tnemges naht retrohs gnirts",
      myCustomstring.reverseNCharacters(100, false)
    );
  }

  @Test
  public void testReverseNCharacters5() {
    myCustomstring.setString(null);
    assertThrows(
      NullPointerException.class,
      () -> myCustomstring.reverseNCharacters(10, false)
    );
  }

  @Test
  public void testReverseNCharacters6() {
    myCustomstring.setString("argument out of bounds");
    assertThrows(
      IllegalArgumentException.class,
      () -> myCustomstring.reverseNCharacters(-1, false)
    );
  }

  @Test
  public void testReverseNCharacters7() {
    myCustomstring.setString("argument out of bounds");
    assertThrows(
      IllegalArgumentException.class,
      () -> myCustomstring.reverseNCharacters(0, false)
    );
  }

  @Test
  public void testReverseNCharacters8() {
    myCustomstring.setString(" madam civic radar refer");
    assertEquals(
      "madam civic radar refer ",
      myCustomstring.reverseNCharacters(6, false)
    );
  }

  @Test
  public void testReverseNCharacters9() {
    myCustomstring.setString(" madam civic radar refer to ");
    assertEquals(
      "madam civic radar refer XX ot ",
      myCustomstring.reverseNCharacters(6, true)
    );
  }

  @Test
  public void testReverseNCharacters10() {
    myCustomstring.setString("madam");
    assertEquals("Xmadam", myCustomstring.reverseNCharacters(6, true));
  }

  @Test
  public void testReverseNCharacters11() {
    myCustomstring.setString("madam im adam");
    assertEquals("Xmada mi madam", myCustomstring.reverseNCharacters(14, true));
  }

  @Test
  public void testConvertDigitsToNamesInSubstring1() {
    myCustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
    myCustomstring.convertDigitsToNamesInSubstring(17, 24);
    assertEquals(
      "H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!",
      myCustomstring.getString()
    );
  }

  @Test
  public void testConvertDigitsToNamesInSubstring2() {
    myCustomstring.setString("1 2 3 4 5 6 7 8 9 0");
    myCustomstring.convertDigitsToNamesInSubstring(1, 8);
    assertEquals("One Two Three Four 5 6 7 8 9 0", myCustomstring.getString());
  }

  @Test
  public void testConvertDigitsToNamesInSubstring3() {
    myCustomstring.setString("1234567890");
    myCustomstring.convertDigitsToNamesInSubstring(1, 10);
    assertEquals(
      "Onetwothreefourfivesixseveneightninezero",
      myCustomstring.getString()
    );
  }

  @Test
  public void testConvertDigitsToNamesInSubstring4() {
    myCustomstring.setString(null);
    assertThrows(
      NullPointerException.class,
      () -> myCustomstring.convertDigitsToNamesInSubstring(1, 10)
    );
  }

  @Test
  public void testConvertDigitsToNamesInSubstring5() {
    myCustomstring.setString("startPosition 5 after endPosition 3");
    assertThrows(
      IllegalArgumentException.class,
      () -> myCustomstring.convertDigitsToNamesInSubstring(15, 3)
    );
  }

  @Test
  public void testConvertDigitsToNamesInSubstring6() {
    myCustomstring.setString("startPosition less than 1");
    assertThrows(
      MyIndexOutOfBoundsException.class,
      () -> myCustomstring.convertDigitsToNamesInSubstring(0, 3)
    );
  }

  @Test
  public void testConvertDigitsToNamesInSubstring7() {
    myCustomstring.setString("endPosition greater than string length");
    assertThrows(
      MyIndexOutOfBoundsException.class,
      () -> myCustomstring.convertDigitsToNamesInSubstring(1, 1000)
    );
  }

  @Test
  public void testConvertDigitsToNamesInSubstring8() {
    myCustomstring.setString("endPosition greater than string length");
    assertThrows(
      IllegalArgumentException.class,
      () -> myCustomstring.convertDigitsToNamesInSubstring(1000, -1000)
    );
  }

  @Test
  public void testConvertDigitsToNamesInSubstring9() {
    myCustomstring.setString("123");
    myCustomstring.convertDigitsToNamesInSubstring(1, 2);
    assertEquals("Onetwo3", myCustomstring.getString());
  }

  @Test
  public void testConvertDigitsToNamesInSubstring10() {
    myCustomstring.setString("Zero123");
    myCustomstring.convertDigitsToNamesInSubstring(6, 7);
    assertEquals("Zero1Twothree", myCustomstring.getString());
  }

  @Test
  public void testConvertDigitsToNamesInSubstring11() {
    myCustomstring.setString("Zero123");
    myCustomstring.convertDigitsToNamesInSubstring(6, 7);
    assertEquals("Zero1Twothree", myCustomstring.getString());
  }
}
