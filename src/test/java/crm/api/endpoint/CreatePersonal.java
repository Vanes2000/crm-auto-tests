package crm.api.endpoint;

import crm.api.RequestParams.AddPersonal;

public class CreatePersonal {

    public static String CREATE_UNFINISHED_PERSONAL = "/create/unfinished_personal";

    public static String ADD_PERSONAL = "/query/personal";

    //Создаём данные сотрудника в tmp таблицах
    public void CreateUnfinishedPersonalPersonal () {

        AddPersonal.AddPersonalOne.builder ()

                .surname("Орлова")
                .nameN("Варвара")
                .patronymic("Даниловна")
                .dateRojd("1962-04-22")
//                .directionJson(7) - тут передаём id
                .telefon("88887776655")
//                .accountJson (  ) - тут передаём id аккаунта который иницировал запрос на добавление таблицы: sys_account
                .grajdanstvoId ( 1 )
                .needEmployed ( false )
                .sexId ( 1 );
    }

    //Создаём данные сотрудника
    public void addPersonal() {

        AddPersonal.AddPersonalTwo.builder ()

//                .personalId (  ) - тут надо передать id который мы получил из запроса createPersonal
                .typeParentAction ( 1 )
                .parentAction ( 1 )
//                .directionJson (  ) - берём его из запроса createPersonal
//                .objectJson (  ) - берём его из запроса на получения данных аккаунта
//                .grajdanstvoId ( 1 ) - берём его из запроса createPersonal
                .transfer(false)
                .startPoint("")
                .endPoint("")
                .cityId(null)
                .regionsId(null)
                .objectTransferId(null)
                .regionName("")
                .cityName("");
    }

}