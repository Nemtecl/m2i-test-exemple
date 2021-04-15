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

    @Test
    public void doitInitialiserAvecDeuxParams() {
        // GIVEN
        Money m;
        int montant = 1000;
        Devise devise = Devise.DINAR;

        // WHEN
        m = new Money(montant, devise);

        // THEN
        assertThat(m).isNotNull();
        assertThat(m.getDevise()).isEqualTo(devise);
        assertThat(m.getMontant()).isEqualTo(montant);
    }

    @Test
    public void setMontantDoitModifierLeMontant() {
        // GIVEN
        Money m = new Money();
        int montant = 500;

        // WHEN
        m.setMontant(montant);

        // THEN
        assertThat(m.getMontant()).isEqualTo(montant);
    }

    @Test
    public void setDeviseDoitModifierLaDevise() {
        // GIVEN
        Money m = new Money();
        Devise devise = Devise.PESO;

        // WHEN
        m.setDevise(devise);

        // THEN
        assertThat(m.getDevise()).isEqualTo(devise);
    }

    @Test
    public void setDeviseNullDoitRenvoyerUneException() {
        // GIVEN
        Money m = new Money();

        // WHEN
        // THEN
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> m.setDevise(null));
    }
}