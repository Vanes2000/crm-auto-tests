package crm.adapters.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PersonalPage {

    public static class MainPage {

        public static SelenideElement buttonHeaderHover = $x("//button[@class='v-expansion-panel-header v-sidebar-container-link v-sidebar-container-link__default-height v-sidebar-container-link__hover nav-button_Основные таблицы']");

        public static SelenideElement linkNoneRouter = $x("//a[@href='/./personal']");

        public static SelenideElement buttonOutlinedTheme = $x("//button[contains(@name, 'персонал')]");

        public static SelenideElement pText = $x("//p[@class='text-h4 mb-3']");

    }

    public static class EmployeeDataForm {

        public SelenideElement fieldSurName = $x("//input[contains(@name, 'surname')]");

        public SelenideElement fieldName = $x("//input[@name='form_field_name_n']");

        public SelenideElement fieldPatronymic = $x("//input[contains(@name, 'form_field_patronymic')]");

        public SelenideElement fieldDateOfBirth = $x("//input[contains(@name, 'form_field_date_rojd')]");

        public SelenideElement fieldTelephone = $x("//input[@name='form_field_telefon']");

        public SelenideElement fieldCitizenship = $x("//label[contains(., 'Гражданство')]/following-sibling::div//input");

        public SelenideElement buttonCloseAddFrom = $x("//button[@name=\"form_btn_Закрыть\"]");

        public SelenideElement buttonSave = $x("//button[@name='form_btn_Сохранить']");

        //Чек-боксы

        public SelenideElement checkBoxEmploymentAvailable = $x("//*[@name=\"form_field_need_employed\"]");

        public SelenideElement checkBoxWithoutIdentificationDocuments = $x("//*[@name=\"form_field_is_mass\"]");

        public SelenideElement checkBoxFullTime = $x("//*[@name=\"form_field_in_state\"]");

        public SelenideElement nameFullTime = $x("//input[@name=\"form_field_alias\"]");

        //Доп поля из формы логистики

        public SelenideElement objectField = $x("//div[@class=\"v-select__slot\"]//div//input[@name=\"form_field_object_id\"]");

        public SelenideElement selectObject = $x("//div[@class=\"v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content\"]//div[@class=\"v-list-item__content\"]");

        public SelenideElement form = $x("//p[@class=\"text-h4 mb-3\"]");

    }

    public static class EmployeeErrorDataForm {

        public SelenideElement surnameError = $x("//div[@name=\"form_field_surname\"]//div[text()=\"Обязательное поле\"]");

        public SelenideElement nameError = $x("//div[@name=\"form_field_name_n\"]//div[text()=\"Обязательное поле\"]");

        public SelenideElement dateOfBirthError = $x("//div[@name=\"form_field_date_rojd\"]//div[text()=\"Обязательное поле\"]");

        public SelenideElement telephoneError = $x("//div[@name=\"form_field_telefon\"]//div[text()=\"Обязательное поле\"]");

        public SelenideElement citizenshipError = $x("//div[@class=\"autocomplete select_grajdanstvo_id\"]//div[text()=\"Обязательное поле\"]");

        public SelenideElement documentTypeError = $x("//div[@name=\"form_field_doc_id\"]//div[text()=\"Обязательное поле\"]");

        public SelenideElement dropZoneError = $x("//div[@name=\"form_field_path_doc\"]//div[text()=\"Обязательное поле\"]");

    }

    public static class EmployeeColorIndicatorLocators {

        public SelenideElement colorSurname = $x("//div[@name=\"form_field_surname\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorName = $x("//div[@name=\"form_field_name_n\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorPatronymic = $x("//div[@name=\"form_field_patronymic\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorDirection = $x("//div[@class=\"autocomplete select_direction_id\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorAccess = $x("//div[@class=\"autocomplete select_personal_id\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorCheckBoxEmploymentAvailable = $x("//div[@name=\"form_field_need_employed\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorCheckBoxFullTime = $x("//div[@name=\"form_field_need_employed\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorCheckBoxWithoutIdentificationDocuments = $x("//div[@name=\"form_field_is_mass\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorDateOfBirth = $x("//div[@name=\"form_field_date_rojd\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorTelephone = $x("//div[@name=\"form_field_telefon\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorCitizenship = $x("//div[@class=\"autocomplete select_grajdanstvo_id\"]//div[@class=\"v-input__control\"]");

        //Форма добавления документа

        public SelenideElement colorDocumentType = $x("//div[@name=\"form_field_doc_id\"]//div[@class=\"v-input__control\"]");

        public SelenideElement colorDropZone = $x("//div[@class=\"dropzone vue-dropzone dropzone dropzone--error\"]");

    }

    public static class EmployeeDocumentsForm {

        public SelenideElement buttonAdd = $x("//button[@name='btn_Добавить']");

        public SelenideElement divSelectSlot = $x("//input[@name=\"form_field_doc_id\"]");

        public SelenideElement divClickable = $x("//input[@type=\"file\"]");

        public SelenideElement buttonSaveDoc = $x("//div[@class=\"v-popup v-popup3\"]//span[@class=\"v-btn__content\" and text()=\" Сохранить \"]");

        public SelenideElement spanContent = $x("//span[text()=\" Оставить заявку \"]");

    }

    public static class PersonalModal {

        public SelenideElement transferCheckBox = $x("//div[@name=\"form_field_transfer\"]//div[@class=\"v-input--selection-controls__ripple\"]");

        public SelenideElement addressField_A = $x("//div[@class=\"v-text-field__slot\"]//input[@name=\"form_field_start_point\"]");

        public SelenideElement transferObjectFiled = $x("//div[@class=\"autocomplete select_object_transfer_id\"]//div[@aria-expanded=\"false\" and @role=\"combobox\"]");

        public SelenideElement transferSelectObject = $x("//div[@class=\"v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content\"]//div[@class=\"v-list v-select-list v-sheet theme--light theme--light\"]");

        public SelenideElement transferSelectRegion = $x("//div[@name=\"form_field_regions_id\"]//span[@class=\"v-chip v-chip--no-color v-chip--removable theme--light v-size--small v-chip--select\"]");

        public SelenideElement localitySelect = $x("//div[@class=\"autocomplete select_city_id\"]//span[@class=\"v-chip v-chip--no-color v-chip--removable theme--light v-size--small v-chip--select\"]");

        public SelenideElement addressField_B = $x("//div[@name=\"form_field_end_point\"]//input[@name=\"form_field_end_point\"]");

    }

    public static class DocumentsTypes {

        public static SelenideElement passport = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' Паспорт ']");

        public static SelenideElement snils = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' СНИЛС ']");

        public static SelenideElement cardDetails = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' Реквизиты карты ']");

        public static SelenideElement passportPage2 = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' Паспорт стр.2 ']");

        public static SelenideElement medicalBook = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' Мед. книжка ']");

        public static SelenideElement inn = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' ИНН ']");

        public static SelenideElement confirmFundsTransfer = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' Подтверждение перечисления ДС ']");

        public static SelenideElement guardianPermission = $x("//div[@class='v-list-item v-list-item--link theme--light']//p[text()=' Разрешение от опекуна ']");

    }

    public static class TypeCitizenship {

        public static SelenideElement citizenshipRF = $x("//div[@class=\"row d-flex\"]//p[text()=\" РФ \"]");

        public static SelenideElement citizenshipUzbekistan = $x("//div[@class=\"row d-flex\"]//p[text()=\" Узбекистан \"]");

        public static SelenideElement citizenshipKyrgyzstan = $x("//div[@class=\"row d-flex\"]//p[text()=\" Киргизия \"]");

        public static SelenideElement citizenshipArmenia = $x("//div[@class=\"row d-flex\"]//p[text()=\" Армения \"]");

        public static SelenideElement citizenshipAzerbaijan = $x("//div[@class=\"row d-flex\"]//p[text()=\" Азербайджан \"]");

        public static SelenideElement citizenshipKazakhstan = $x("//div[@class=\"row d-flex\"]//p[text()=\" Казахстан \"]");

        public static SelenideElement citizenshipTajikistan = $x("//div[@class=\"row d-flex\"]//p[text()=\" Таджикистан \"]");

    }

}