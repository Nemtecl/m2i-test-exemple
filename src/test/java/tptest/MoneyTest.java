package tptest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    public void shouldInstanciateWithNoParam() {
        // GIVEN
        Money m;
        int montant = 0;
        Devise devise = Devise.EURO;

        // WHEN
        m = new Money();

        // THEN
        assertThat(m).isNotNull();
        assertThat(m.getDevise()).isEqualTo(devise);
        assertThat(m.getMontant()).isEqualTo(montant);
    }
}