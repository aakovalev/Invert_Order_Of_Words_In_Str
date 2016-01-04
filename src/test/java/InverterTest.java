import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InverterTest {
    private Inverter inverter;

    @Before
    public void setUp() throws Exception {
        inverter = new Inverter();
    }

    @Test
    public void invertEmptyString() throws Exception {
        validateInversion("", "");
        validateInversion(" ", " ");
        validateInversion("  ", "  ");
    }

    @Test
    public void invertStringWithSingleWord() throws Exception {
        validateInversion("one", "one");
        validateInversion(" one", "one ");
        validateInversion("  test ", " test  ");
    }

    @Test
    public void invertStringOfTwoWords() throws Exception {
        validateInversion("one two", "two one");
        validateInversion("  one two", "two one  ");
    }

    @Test
    public void invertStringPreservesSpacesWithinString() throws Exception {
        validateInversion("one   two", "two   one");
    }

    @Test
    public void invertStringOfThreeWords() throws Exception {
        validateInversion("one two three", "three two one");
        validateInversion("здесь был Вася", "Вася был здесь");
    }

    @Test
    public void invertArbitraryString() throws Exception {
        validateInversion("There  is no place home ", " home place no is  There");
    }

    @Test
    public void invertOrderOfChars() throws Exception {
        assertEquals("ecalp", inverter.invertOrderOfChars(0, 4, "place"));
    }

    @Test
    public void getEndOfWordIndexWhenEndOfWordIsEndOfString() throws Exception {
        assertEquals(3, endOfWordIndex(0, "test"));
        assertEquals(6, endOfWordIndex(5, "one two"));
        assertEquals(6, endOfWordIndex(3, "one two"));
    }

    @Test
    public void getEndOfWordIndexWhenEndOfStringIsNotEndOfString() throws Exception {
        assertEquals(2, endOfWordIndex(0, "one two three"));
        assertEquals(6, endOfWordIndex(4, "one two three"));
        assertEquals(7, endOfWordIndex(3, "one  two three"));
    }

    private void validateInversion(String someStr, String inverted) {
        assertEquals(inverted, inverter.invertOrderOfWords(someStr));
    }

    private int endOfWordIndex(int startIndex, String str) {
        return inverter.endOfWordIndex(startIndex, str.toCharArray());
    }
}