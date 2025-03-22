package co.edu.poli.ces3.demo.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class RandomBigIntegerGenerator {
    //estatico -> esta en una memoria aparte de lo que estan los objetos que se instancia

    //varibles estaticas no cambian en la ejecución del codigo -> se almacenan en memoria
    private static final SecureRandom random = new SecureRandom();
    private static final Set<BigInteger> generatedNumbers = new HashSet<>();

    //metodo estatico -> no necesito generar una instancia de la clase para usarlo
    public static BigInteger generateUniqueBigInteger(int bitLength) {
        BigInteger number;
        do {
            number = new BigInteger(bitLength, random);
        } while (generatedNumbers.contains(number));

        generatedNumbers.add(number);
        return number;
    }
}
