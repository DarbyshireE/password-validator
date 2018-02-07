package com.example.elliott.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Elliott on 2018-02-06.
 */

public class ValidatorTest {

    @Test
    public void checkPassword()
    {
        assertFalse(Validator.validate("password"));
    }
    @Test
    public void checkPasswordCaseInsensitive() { assertFalse(Validator.validate("PaSSWoRd")); }
    @Test
    public void checkLength()
    {
        assertFalse(Validator.validate("ABC123!"));
    }
    @Test
    public void checkSpecialChar() { assertFalse(Validator.validate("ABCD1234")); }
    @Test
    public void checkDigit() { assertFalse(Validator.validate("ABCDEFGH!")); }
    @Test
    public void checkCaps() { assertFalse(Validator.validate("abcd1234!")); }
    @Test
    public void validPassword() { assertTrue(Validator.validate("ABCD1234!")); }


}
