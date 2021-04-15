package tptest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DeviseTest {

    @Test
    public void doitInstancierUneDevise() {
        // GIVEN
        Devise devise;
        String expected = "LIVRE";

        // WHEN
        devise = Devise.LIVRE;

        // THEN
        assertThat(devise).isNotNull();
        assertThat(devise.name()).isEqualTo(expected);
    }

}