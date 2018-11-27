import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class CustomerData {

    private static String houseNumber;
    private static String postCode;
    private static int cityIndex;
    private static String randomCity;
    @NotNull
    static String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }
    static Random randomGenerator = new Random();
    private static ArrayList<String> citiesList = new ArrayList<>();
    public static HashSet<String> listOfProducts = new HashSet<>();

    static {
        citiesList.add("Киев");
        citiesList.add("Харьков");
        citiesList.add("Одесса");
        citiesList.add("Днепр");
        citiesList.add("Донецк");
        citiesList.add("Запорожье");
        citiesList.add("Львов");
        citiesList.add("Кривой Рог");
        citiesList.add("Николаев");
        citiesList.add("Мариуполь");
        citiesList.add("Луганск");
        citiesList.add("Винница");
        citiesList.add("Макеевка");
        citiesList.add("Севастополь");
        citiesList.add("Симферополь");
        citiesList.add("Херсон");
        citiesList.add("Полтава");
        citiesList.add("Чернигов");
        citiesList.add("Черкассы");
        citiesList.add("Хмельницкий");
        citiesList.add("Житомир");
        citiesList.add("Черновцы");
        citiesList.add("Сумы");
        citiesList.add("Горловка");
        citiesList.add("Ровно");
        citiesList.add("Ровно");
        citiesList.add("Ивано-Франковск");
        citiesList.add("Каменское");
        citiesList.add("Кропивницкий");
        citiesList.add("Кременчуг");
        citiesList.add("Тернополь");
        citiesList.add("Луцк");
        citiesList.add("Белая Церковь");
        citiesList.add("Краматорск");
        citiesList.add("Мелитополь");
        citiesList.add("Керчь");
        citiesList.add("Ужгород");
        citiesList.add("Никополь");
        citiesList.add("Бердянск");
        citiesList.add("Славянск");
        citiesList.add("Алчевск");
        citiesList.add("Павлоград");
        citiesList.add("Северодонецк");
        citiesList.add("Евпатория");
        citiesList.add("Бровары");
        citiesList.add("Каменец-Подольский");

    }


    public static String getRandomCity(){
        cityIndex = randomGenerator.nextInt(citiesList.size());
        randomCity = citiesList.get(cityIndex);
        return randomCity;
    }

    public static String getPostCode() {
        postCode = Integer.toString(10000+randomGenerator.nextInt(20000));
        return postCode;
    }

    public static String getHouseNumber(){
        houseNumber = String.valueOf(randomGenerator.nextInt(300)+1);
        return houseNumber;
    }

    static {
        listOfProducts.add("Faded Short Sleeve T-Shirts");
        listOfProducts.add("Blouse");
        listOfProducts.add("Printed Dress");
        listOfProducts.add("Printed Chiffon Dress ");
    }
    @Contract(pure = true)
    public static HashSet<String> getListOfProducts(){
        return listOfProducts;
    }

}
