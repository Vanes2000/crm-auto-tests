package crm.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PersonalPage  {

    public static class MainPage {

        public SelenideElement buttonHeaderHover = $x("//button[@class='v-expansion-panel-header v-sidebar-container-link v-sidebar-container-link__default-height v-sidebar-container-link__hover nav-button_Основные таблицы']");

        public SelenideElement linkNoneRouter = $x("//a[@href='/./personal']");

        public SelenideElement buttonOutlinedTheme = $x("//button[contains(@name, 'персонал')]");

        public SelenideElement pText = $x("//p[@class='text-h4 mb-3']");

    }


    public static class TheFirstStage {

        public SelenideElement fieldSurName = $x("//input[contains(@name, 'surname')]");

        public SelenideElement fieldName = $x("//input[@name='form_field_name_n']");

        public SelenideElement fieldPatronymic = $x("//input[contains(@name, 'form_field_patronymic')]");

        public SelenideElement fieldDateOfBirth = $x("//input[contains(@name, 'form_field_date_rojd')]");

        public SelenideElement fieldTelephone = $x("//input[@name='form_field_telefon']");

        public SelenideElement fieldCitizenship = $x("//label[contains(., 'Гражданство')]/following-sibling::div//input");

        public SelenideElement citizenshipOfTheRussianFederation = $x("//div[@class=\"row d-flex\"]//p[text()=\" РФ \"]");

        public SelenideElement notificationThatAnEmployeeAlreadyExists = $x("//div[contains(@class, 'pa-3')]");

        public SelenideElement checkboxWithoutIdentificationDocuments = $x("//div[@class=\"field-col col-sm-6 col-12 checkbox\"]//div[@class=\"v-input--selection-controls__ripple\"]");

        public SelenideElement buttonSave = $x("//button[@name='form_btn_Сохранить']");

        //Доп поля из формы логистики

        public SelenideElement objectField = $x("//div[@class=\"v-select__slot\"]//div//input[@name=\"form_field_object_id\"]");

        public  SelenideElement selectObject = $x("//div[@class=\"v-list-item__content\"]//p[text()=\" РЦ Волгоград \"]");

        public SelenideElement AccessFiled = $x("//div[@class=\"v-select__slot\"]//div//input[@name=\"form_field_personal_id\"]");

        public SelenideElement selectAccess = $x("//div[@class=\"row d-flex\"]//p[text()=\" Ружицкий Владислав(РЦ Волгоград) \"]");

        public SelenideElement form = $x("//p[@class=\"text-h4 mb-3\"]");


    }


    public static class TheSecondStage {

        public SelenideElement buttonAdd = $x ("//button[@name='btn_Добавить']");

        public SelenideElement divSelectSlot = $x("//input[@name=\"form_field_doc_id\"]");

        //Форма добавления документа

        public SelenideElement passport = $x("//div[@data-v-57b3bb1d and @class=\"v-list-item__content\"]//p[text()=\" Паспорт \"]");

        public SelenideElement divClickable = $x("//input[@type=\"file\"]");

        public SelenideElement buttonSaveDoc = $x("//div[@data-v-f76177b6 and @class=\"row justify-end buttons-container\"]//span[@class=\"v-btn__content\" and text()=\" Сохранить \"]");

        public String filePath = "bandicam 2025-11-19 21-34-38-587.jpg";


        public SelenideElement spanContent = $x("//button[@data-v-7b21640a]//span[text()=\" Оставить заявку \"]");
    }

    public static class PersonalModal {

        public SelenideElement transferCheckBox = $x("//div[@name=\"form_field_transfer\"]//div[@class=\"v-input--selection-controls__ripple\"]");

        public SelenideElement addressField_A = $x("//div[@class=\"v-text-field__slot\"]//input[@name=\"form_field_start_point\"]");

        public SelenideElement transferObjectFiled = $x("//div[@class=\"autocomplete select_object_transfer_id\"]//div[@aria-expanded=\"false\" and @role=\"combobox\"]");


        public SelenideElement transferSelectObject = $x("//div[@class=\"v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content\"]//p[text()=\" РЦ Волгоград \"]");

        public  SelenideElement transferSelectRegion = $x("//span[@class=\"v-chip__content\"]//p[text()=\"Волгоградская область\"]");

        public SelenideElement localitySelect = $x("//span[@class=\"v-chip__content\"]//p[text()=\"Волгоград\"]");

        public SelenideElement addressField_B = $x("//div[@name=\"form_field_end_point\"]//input[@name=\"form_field_end_point\"]");

    }

}

