/**
 * @brief {A set of test cases for the MyCustomString class}
 *
 *        Mae B. Morella SWE 3643 – Assignment 4
 */

package edu.kennesaw.seclass;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MyCustomStringTest {
    private MyCustomStringInterface myCustomString;

    @BeforeEach
    public void setUp() {
        myCustomString = new MyCustomString();
    }

    @AfterEach
    public void tearDown() {
        myCustomString = null;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Test countNumbers method
    ///////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testCountNumbers1() {
        myCustomString.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, myCustomString.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        String msg = "The string contains no numbers.";

        myCustomString.setString("foo bar baz one ten eleven");
        assertEquals(0, myCustomString.countNumbers(), msg);
    }

    @Test
    public void testCountNumbers3() {
        String msg = "The string contains 9 numbers.";

        myCustomString.setString("Jenny 867-5309 8 6 7 5 3 0 9");
        assertEquals(9, myCustomString.countNumbers(), msg);
    }

    @Test
    public void testCountNumbers4() {
        String msg = "The string contains 1 number.";

        myCustomString.setString("9");
        assertEquals(1, myCustomString.countNumbers(), msg);
    }

    @Test
    public void testCountNumbers5() {
        String msg = "All characters in the Unicode Decimal Digit class should be counted.";

        myCustomString.setString("Fullwidth digits: １３, ３７");
        assertEquals(2, myCustomString.countNumbers(), msg);
        myCustomString.setString("Devangari numerals: ०१, १, २, ३, ४, ५, ६, ७, ८, ९");
        assertEquals(10, myCustomString.countNumbers(), msg);
        myCustomString.setString("Supplementary characters: 𝟘 𝟙 𝟚 𝟛 𝟜A 𝟝 𝟞 𝟟 𝟠 𝟡");
        assertEquals(10, myCustomString.countNumbers(), msg);
    }

    @Test
    public void testCountNumbers6() {
        assertEquals(0, myCustomString.countNumbers(), "Uninitialized string should return 0");
        myCustomString.setString(null);
        assertEquals(0, myCustomString.countNumbers(), "Null string should return 0");
        myCustomString.setString("");
        assertEquals(0, myCustomString.countNumbers(), "Empty string should return 0");
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Reverse N characters method
    ///////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testReverseNCharacters1() {
        myCustomString.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srep.",
                myCustomString.reverseNCharacters(4, false));
    }

    @Test
    public void testReverseNCharacters2() {
        myCustomString.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srepXXX.",
                myCustomString.reverseNCharacters(4, true));
    }

    @Test
    public void testReverseNCharacters3() {
        String msg = "Reversing a single-character string should result in the same string.";

        myCustomString.setString("a");
        assertEquals("a", myCustomString.reverseNCharacters(1, false), msg);
    }

    @Test
    public void testReverseNCharacters4() {
        String msg = "If n > strLength, the entire string should be reversed.";

        myCustomString.setString("string shorter than segment length");
        assertEquals("htgnel tnemges naht retrohs gnirts",
                myCustomString.reverseNCharacters(100, false), msg);
    }

    @Test
    public void testReverseNCharacters5() {
        String msg = "Each word is palindromic. Last word is reversed.";

        myCustomString.setString("MadamCivicRadarReferTot");
        assertEquals("madaMciviCradaRrefeRtoT", myCustomString.reverseNCharacters(5, false), msg);
    }

    @Test
    public void testReverseNCharacters6() {
        String msg = "This string should be reversed and padded with 1 X.";

        myCustomString.setString("madam im adam"); // len -> 13
        assertEquals("Xmada mi madam", myCustomString.reverseNCharacters(14, true), msg);
    }

    @Test
    public void testReverseNCharacters7() {
        String msg = "This word should be padded with X to length 6.";

        myCustomString.setString("Madam");
        assertEquals("XmadaM", myCustomString.reverseNCharacters(6, true), msg);
    }

    @Test
    public void testReverseNCharacters8() {
        String msg = "The last word should be padded  with 'X' to length 5.";

        myCustomString.setString("MadamCivicRadarReferTot");
        assertEquals("madaMciviCradaRrefeRXXtoT", myCustomString.reverseNCharacters(5, true), msg);
    }

    @Test
    public void testReverseNCharacters9() {
        String msg = "Unicode grapheme sequences should be preserved; i.e. a single character.";

        myCustomString.setString("jalapeño 🌶️"); // -> U+1F336 ️ U+FE0F
        assertEquals("🌶️ oñepalaj", myCustomString.reverseNCharacters(100, false), msg);
        myCustomString.setString("🏳️‍⚧️🏳️‍🌈👩🏽‍🚀");
        assertEquals("🚀‍🏽👩🌈‍🏳️⚧️‍🏳️", myCustomString.reverseNCharacters(100, false), msg);
    }

    @Test
    public void testReverseNCharacters10() {
        String msg1 = "Should throw IllegalArgumentException if n == 0 and string not null";
        String msg2 = "Should throw IllegalArgumentException if n < 0 and string not null";

        var expectedType = IllegalArgumentException.class;
        myCustomString.setString("not null");
        assertThrows(expectedType, () -> myCustomString.reverseNCharacters(0, false), msg1);
        assertThrows(expectedType, () -> myCustomString.reverseNCharacters(-1, false), msg2);
    }

    @Test
    public void testReverseNCharacters11() {
        String msg = "Should throw NullPointerException if string is null or uninitialzed.";

        var expectedType = NullPointerException.class;
        assertThrows(expectedType, () -> myCustomString.reverseNCharacters(10, false), msg);
        myCustomString.setString(null);
        assertThrows(expectedType, () -> myCustomString.reverseNCharacters(10, false), msg);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Convert digits to names
    ///////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        myCustomString.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        myCustomString.convertDigitsToNamesInSubstring(17, 24);
        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!",
                myCustomString.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        String msg = "Position 1 through 8 should be converted to words";

        myCustomString.setString("1 2 3 4 5 6 7 8 9 0");
        myCustomString.convertDigitsToNamesInSubstring(1, 8);
        assertEquals("One Two Three Four 5 6 7 8 9 0", myCustomString.getString(), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        String msg = "All numbers should be converted to one long word.";

        myCustomString.setString("1234567890");
        myCustomString.convertDigitsToNamesInSubstring(1, 10);
        assertEquals("Onetwothreefourfivesixseveneightninezero", myCustomString.getString(), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        String msg = "Can convert multiple digits separately.";

        myCustomString.setString("123");
        myCustomString.convertDigitsToNamesInSubstring(3, 3);
        myCustomString.convertDigitsToNamesInSubstring(2, 2);
        myCustomString.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("OneTwoThree", myCustomString.getString(), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        String msg = "Conversion works at the end of the string.";

        myCustomString.setString("Zero123");
        myCustomString.convertDigitsToNamesInSubstring(6, 7);
        assertEquals("Zero1Twothree", myCustomString.getString(), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        String msg = "Conversion works at the start of the string.";

        myCustomString.setString("123");
        myCustomString.convertDigitsToNamesInSubstring(1, 2);
        assertEquals("Onetwo3", myCustomString.getString(), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        String msg = "Should throw MyIndexOutOfBoundsException if end > strLength";
        myCustomString.setString("f00b4r"); // len -> 6
        assertThrows(MyIndexOutOfBoundsException.class,
                () -> myCustomString.convertDigitsToNamesInSubstring(1, 10), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        String msg = "Should throw IllegalArgumentException if start > end";

        myCustomString.setString("");
        assertThrows(IllegalArgumentException.class,
                () -> myCustomString.convertDigitsToNamesInSubstring(1000, -1000), msg);
        assertThrows(IllegalArgumentException.class,
                () -> myCustomString.convertDigitsToNamesInSubstring(15, 3), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring9() {
        String msg = "Should throw MyIndexOutOfBoundsException if start < 1";

        myCustomString.setString("");
        assertThrows(MyIndexOutOfBoundsException.class,
                () -> myCustomString.convertDigitsToNamesInSubstring(0, 3), msg);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring10() {
        String msg = "Any character besides 0–9 should not be affected.";

        myCustomString.setString("Devangari numerals: ०, १, २, ३, ४, ५, ६, ७, ८, ९");
        myCustomString.convertDigitsToNamesInSubstring(1, 48);
        assertEquals("Devangari numerals: ०, १, २, ३, ४, ५, ६, ७, ८, ९", myCustomString.getString(),
                msg);

    }

    @Test
    public void testConvertDigitsToNamesInSubstring11() {
        String msg = "Should throw NullPointerException if string is null or uninitialized.";

        var expectedType = NullPointerException.class;
        assertThrows(expectedType, () -> myCustomString.convertDigitsToNamesInSubstring(1, 10),
                msg);
        myCustomString.setString(null);
        assertThrows(expectedType, () -> myCustomString.convertDigitsToNamesInSubstring(1, 10),
                msg);
    }
}
