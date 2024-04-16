package console.Domain;

import java.util.ArrayList;
import java.util.List;

public class carFactory {

    public static List<masina> generateMasinaList(int numberOfObjects) {
        List<masina> masinaList = new ArrayList<>();

        // Sample arrays for car brands and models (extended)
        String[] Brands = {"Toyota", "Honda", "Ford", "Chevrolet", "Volkswagen", "Nissan", "BMW", "Mercedes-Benz", "Audi", "Hyundai",
                "Kia", "Mazda", "Subaru", "Volvo", "Lexus", "Tesla", "Fiat", "Jeep", "Chrysler", "Dodge",
                "Buick", "Cadillac", "GMC", "Ram", "Jaguar", "Land Rover", "Porsche", "Ferrari", "Lamborghini", "Maserati",
                "Alfa Romeo", "Aston Martin", "Bugatti", "McLaren", "Rolls-Royce", "Bentley", "Mitsubishi", "Infiniti", "Acura", "Mini",
                "Suzuki", "Smart", "Saab", "Lancia", "Fiat", "Peugeot", "Renault", "Citroën", "Skoda", "Seat"};

        String[] Models = {"Camry", "Civic", "Mondeo", "Silverado", "Golf",
                "Altima", "3 Series", "C-Class", "A4", "Elantra",
                "Optima", "Mazda3", "Outback", "XC60", "RX",
                "Model S", "500", "Wrangler", "300", "Charger",
                "Encore", "Escalade", "Sierra", "1500", "F-PACE",
                "Range Rover", "911", "488", "Huracán", "Ghibli",
                "Giulia", "DB11", "Chiron", "720S", "Phantom",
                "Continental GT", "Outlander", "Q50", "MDX", "Cooper",
                "Swift", "Fortwo", "9-3", "Ypsilon", "Panda",
                "208", "Clio", "C3", "Octavia", "Leon"
        };

        for (int i = 1; i <= numberOfObjects; i++) {
            // Generate a Masina object with a unique ID between 1 and 100
            // Use modulo operator to ensure that the index is within the bounds of the arrays
            masina masina = new masina(i, Brands[(i - 1) % Brands.length], Models[(i - 1) % Models.length]);
            masinaList.add(masina);
        }

        return masinaList;
    }

}
