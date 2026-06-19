package utilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();
	Random random = new Random();

    public String createRandomFirstName() {
        return faker.name().firstName();
    }

    public String createRandomLastName() {
        return faker.name().lastName();
    }

    public String generateAddress() {
        return faker.address().fullAddress();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }
    
    public String generateCategory() {
    	return faker.food().ingredient();
    }
    
    public String generateUsername() {
        String base = faker.name().username(); // gives something like "cool_cat123"
        int suffix = random.nextInt(1000);     // adds uniqueness
        return base + suffix;
    }

}
