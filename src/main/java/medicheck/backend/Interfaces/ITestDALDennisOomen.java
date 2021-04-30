package medicheck.backend.Interfaces;

import medicheck.backend.DTO.AccountDTO;

public interface ITestDALDennisOomen {
    AccountDTO getAccountInfoByName(String username) throws Exception;
    void register(AccountDTO account) throws Exception;

}
