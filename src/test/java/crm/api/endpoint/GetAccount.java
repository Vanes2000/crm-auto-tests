package crm.api.endpoint;

public class GetAccount {

    //Тут будет общий метод для получения того пермишена который иницировал запрос

    //1. Отправляется запрос на авторизацию
    //2. Можно брать креды для авторизации и отправлять select запрос в БД и получать id и подставлять его следующие запросы
    //3. Запрос на получение данных: SELECT id FROM sys_account WHERE

    private static String getAccountSql = "SELECT id FROM sys_account WHERE name like ?"

    public void getAccount {
    }
}
