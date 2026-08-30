package crm.utils;

import com.codeborne.selenide.SelenideElement;
import crm.adapters.pages.PersonalPage;

public enum TypeCitizenship {

    RF("РФ", PersonalPage.TypeCitizenship.citizenshipRF),
    Uzbekistan("Узбекистан", PersonalPage.TypeCitizenship.citizenshipUzbekistan),
    Kyrgyzstan("Киргизия", PersonalPage.TypeCitizenship.citizenshipKyrgyzstan),
    Armenia("Армения", PersonalPage.TypeCitizenship.citizenshipArmenia),
    Azerbaijan("Азербайджан", PersonalPage.TypeCitizenship.citizenshipAzerbaijan),
    Tajikistan("Таджикистан", PersonalPage.TypeCitizenship.citizenshipTajikistan),
    Kazakhstan("Казахстан", PersonalPage.TypeCitizenship.citizenshipKazakhstan);

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
