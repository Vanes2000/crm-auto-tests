package crm.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NameGenerator {

    private static final String[] MALE_FIRST_NAMES = {"Михаил","Александр", "Лев", "Максим", "Артем", "Марк", "Иван", "Матвей", "Роман", "Тимофей", "Дмитрий", "Мирон", "Даниил", "Федор", "Мухаммад", "Кирилл", "Илья", "Андрей", "Владимир", "Арсений", "Константин", "Алексей", "Ярослав", "Егор", "Павел"};

    private static final String[] FEMALE_FIRST_NAMES = {"София", "Анна", "Мария", "Ева", "Василиса", "Виктория", "Варвара", "Александра", "Полина", "Алиса", "Елизавета", "Мирослава", "Арина", "Ксения", "Екатерина", "Есения", "Вера", "Валерия", "Вероника", "Кира", "Амина", "Дарья", "Милана", "Анастасия", "Мия"};

    private static final String[] MALE_LAST_NAMES = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов", "Попов", "Васильев", "Новиков", "Федоров", "Морозов", "Волков", "Алексеев", "Лебедев", "Семенов", "Егоров", "Павлов", "Козлов", "Степанов", "Николаев", "Орлов", "Андреев", "Макаров", "Никитин", "Зайцев", "Соловьев"};

    private static final String[] FEMALE_LAST_NAMES = {"Иванова", "Петрова", "Сидорова", "Смирнова", "Кузнецова", "Попова", "Васильева", "Новикова", "Федорова", "Морозова", "Волкова", "Алексеева", "Лебедева", "Семенова", "Егорова", "Павлова", "Козлова", "Степанова", "Николаева", "Орлова", "Андреева", "Макарова", "Никитина"};

    private static final String[] MALE_MIDDLE_NAMES = {"Александрович", "Алексеевич", "Анатольевич", "Андреевич", "Антонович", "Аркадьевич", "Артемович", "Борисович", "Валентинович", "Валерьевич", "Васильевич", "Викторович", "Витальевич", "Владимирович", "Владиславович", "Вячеславович", "Геннадьевич", "Георгиевич", "Григорьевич", "Данилович", "Денисович", "Дмитриевич", "Евгеньевич", "Егорович", "Иванович"};

    private static final String[] FEMALE_MIDDLE_NAMES = {"Александровна", "Алексеевна", "Анатольевна", "Андреевна", "Антоновна", "Аркадьевна", "Артемовна", "Борисовна", "Валентиновна", "Валерьевна", "Васильевна", "Викторовна", "Витальевна", "Владимировна", "Владиславовна", "Вячеславовна", "Геннадьевна", "Георгиевна", "Григорьевна", "Даниловна", "Денисовна", "Дмитриевна", "Евгеньевна", "Егоровна", "Ивановна"};

     static Random random = new Random();

    public static String[] generateRandomName() {

        Gender randomGender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;

        String[] firstNames = (randomGender == Gender.MALE) ? MALE_FIRST_NAMES : FEMALE_FIRST_NAMES;
        String[] lastNames = (randomGender == Gender.MALE) ? MALE_LAST_NAMES : FEMALE_LAST_NAMES;
        String[] middleNames = (randomGender == Gender.MALE) ? MALE_MIDDLE_NAMES : FEMALE_MIDDLE_NAMES;

        String firstName = getRandomElement(firstNames);
        String lastName = getRandomElement(lastNames);
        String middleName = getRandomElement(middleNames);

        return new String[]{firstName, lastName, middleName};
    }

    private static String getRandomElement(String[] array) {
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }

    public enum Gender {
        MALE, FEMALE
    }


    public static String generateRandomBirthDate(){

        int year = 1950 + random.nextInt(51);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);

        LocalDate birthDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return formatter.format(birthDate);
    }
}
