package crm.utils;

import com.codeborne.selenide.SelenideElement;
import crm.adapters.pages.PersonalPage;

public enum DocumentType {

    PASSPORT("Паспорт", PersonalPage.DocumentsTypes.passport),
    SNILS("СНИЛС", PersonalPage.DocumentsTypes.snils),
    CARD_DETAILS("Реквизиты карты", PersonalPage.DocumentsTypes.cardDetails),
    PASSPORT_PAGE_2("Паспорт стр.2", PersonalPage.DocumentsTypes.passportPage2),
    MED_BOOK("Мед. книжка", PersonalPage.DocumentsTypes.medicalBook),
    INN("ИНН", PersonalPage.DocumentsTypes.inn),
    CONFIRM_FUNDS_TRANSFER("Подтверждение перечисления ДС", PersonalPage.DocumentsTypes.confirmFundsTransfer),
    GUARDIAN_PERMISSION("Разрешение от опекуна", PersonalPage.DocumentsTypes.guardianPermission);

    private final String name;
    private final SelenideElement element;

    DocumentType(String name, SelenideElement element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public SelenideElement getElement() {
        return element;
    }
}
