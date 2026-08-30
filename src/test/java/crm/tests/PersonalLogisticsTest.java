package crm.tests;

import crm.checks.UrlChecks;
import crm.tests.precondition.PreconditionTestPersonal;
import crm.utils.DocumentType;
import crm.utils.TestFile;
import crm.utils.TypeCitizenship;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class PersonalLogisticsTest extends BasedTest {

    @BeforeClass
    public void openAuth() {
        loginHelper.loginAsManagerLogistic();
        UrlChecks.BaseChecks.checkPageRedirect();
        PreconditionTestPersonal.openStaffAdditionForm();
    }

    @Test
    @Description("Добавление линейщика с трансфером и обязательным документом")
    public void addPersonalWithATransferAndARequiredDocument() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataLogistics();
        preconditions.choosingCitizenship(TypeCitizenship.Tajikistan);
        preconditions.fillTransferModal();
        preconditions.SavingDataAfterInput();
        checkNotification.checkSaveNotification();
        preconditions.verifyFirstStageTransition();
        preconditions.addDocument(DocumentType.PASSPORT, TestFile.JPG);
        checkNotification.checkSaveNotification();
        UrlChecks.PersonalCreationChecks.checkPageAddPersonalForm();
        employeeDocumentsForm.spanContent.shouldBe(exist, visible).click();
        UrlChecks.PersonalCreationChecks.checkPagePersonal();
        checkNotification.checkSaveNotification();
    }

    @Test
    @Description("Добавление линейщика без трансфера, но с обязательным документом")
    public void CheckingTheAdditionOfAnEmployeeWithoutATransferAndARequiredDocument() {
        PreconditionTestPersonal.openStaffAddForm();
        preconditions.fillEmployeeDataLogistics();
        preconditions.choosingCitizenship(TypeCitizenship.Tajikistan);
        preconditions.SavingDataAfterInput();
        checkNotification.checkSaveNotification();
        preconditions.verifyFirstStageTransition();
        preconditions.addDocument(DocumentType.PASSPORT, TestFile.JPG);
        checkNotification.checkSaveNotification();
        UrlChecks.PersonalCreationChecks.checkPageAddPersonalForm();
        employeeDocumentsForm.spanContent.shouldBe(exist, visible).click();
        UrlChecks.PersonalCreationChecks.checkPagePersonal();
        checkNotification.checkSaveNotification();
    }
}
