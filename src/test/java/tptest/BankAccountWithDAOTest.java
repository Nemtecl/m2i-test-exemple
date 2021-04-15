package tptest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BankAccountWithDAOTest {

    @Mock
    Connection mockConnection;

    @Mock
    JdbcDAO mockBankDao;

    @InjectMocks
    private BankAccountWithDAO dao;

    @Test
    public void creetCompteShouldCallDaoCreetCompte() throws SQLException, ConnectException {
        // GIVEN
        when(mockBankDao.setUpConnection()).thenReturn(mockConnection);

        // WHEN
        dao.creerCompte();

        // THEN
        verify(mockBankDao, times(1)).creerCompte();
    }

    @Test
    public void creerCompteIsReadonlyLeveException() throws SQLException, ConnectException {
        // GIVEN
        when(mockConnection.isReadOnly()).thenReturn(true);
        when(mockBankDao.setUpConnection()).thenReturn(mockConnection);

        // WHEN
        assertThatExceptionOfType(ConnectException.class).isThrownBy(() -> dao.creerCompte());
    }

}