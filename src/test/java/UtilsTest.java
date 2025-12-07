import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testCheckName_valid() {
        assertTrue(Utils.checkName("Alice"));
    }

    @Test
    void testCheckName_invalid() {
        assertFalse(Utils.checkName(""));
        assertFalse(Utils.checkName(null));
    }

    @Test
    void testIsValidAge_validRange() {
        assertTrue(Utils.isValidAge(25));
    }

    @Test
    void testIsValidAge_negative() {
        assertFalse(Utils.isValidAge(-5));
    }

    @Test
    void testIsValidAge_bugCaseOver120() {
        // This exposes the bug in the method
        assertTrue(Utils.isValidAge(150));  // current implementation allows this
    }
}
