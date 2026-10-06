package crm.utils;

import com.codeborne.selenide.SelenideElement;
import crm.adapters.pages.PersonalPage;

public enum TypeCitizenship {

    RU("РФ", PersonalPage.TypeCitizenship.citizenshipRF),
    UZB("Узбекистан", PersonalPage.TypeCitizenship.citizenshipUzbekistan),
    KGZ("Киргизия", PersonalPage.TypeCitizenship.citizenshipKyrgyzstan),
    ARG("Армения", PersonalPage.TypeCitizenship.citizenshipArmenia),
    AZE("Азербайджан", PersonalPage.TypeCitizenship.citizenshipAzerbaijan),
    TJK("Таджикистан", PersonalPage.TypeCitizenship.citizenshipTajikistan),
    KAZ("Казахстан", PersonalPage.TypeCitizenship.citizenshipKazakhstan);

    private final String name;
    private final SelenideElement element;

    TypeCitizenship(String name, SelenideElement element) {
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
