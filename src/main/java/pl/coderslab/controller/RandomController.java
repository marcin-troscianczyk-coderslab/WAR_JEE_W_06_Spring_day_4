package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.OptionalInt;
import java.util.Random;

@RestController
public class RandomController {

    @GetMapping(path = "/showRandom/{max}", produces = "text/html; charset=UTF-8")
    public String showRandom(@PathVariable(name = "max") int max) {

        final Random random = new Random();
        final int number = random.nextInt(max) + 1;
        return "Wylosowano liczbę: " + number;
    }

    @GetMapping(path = "/showRandom/{min:\\d+}/{max:\\d+}", produces = "text/html; charset=UTF-8")
    public String showRandomMinMax(@PathVariable(name = "min") int min,
                                   @PathVariable(name = "max") int max) {

       /* if (max < min) {
            return "Błędne dane wejsciowe max < min";
        }

        if (min == max) {
            return "Wylosowano liczbę: " + min;
        }*/

        final Random random = new Random();
        final OptionalInt optionalInt = random.ints(1, min, max + 1)
                            .findFirst();
        final int number = optionalInt.orElseThrow(InvalidNumberException::new);
        //final int number = random.nextInt(max - min) + min + 1;
        return "Użytkownik podał wartości min = " + min + ", max = " + max + ".Wylosowano liczbę: " + number;
    }

    private class InvalidNumberException extends RuntimeException {
        InvalidNumberException() {
            super("Podano nieprawidłowe liczby!");
        }
    }
}
