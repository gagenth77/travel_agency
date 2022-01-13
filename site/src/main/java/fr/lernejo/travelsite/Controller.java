package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class Controller
{
    final ArrayList<Enregistrement> enregistrement =  new ArrayList<>();

    @PostMapping(value = "/api/inscription")
    public ArrayList<Enregistrement> register(@RequestBody Enregistrement registre)
    {
        enregistrement.add(registre);
        return enregistrement;
    }

    @GetMapping(value = "/api/travels")
    public ArrayList<Pays> getDestinations(@RequestParam String userName)
    {
        ArrayList<Pays> countries = new ArrayList<>();
        countries.add(new Pays("Caribbean",32.4));
        countries.add(new Pays("Australia",35.1));
        for(Enregistrement registry: enregistrement)
        {
            if(registry.userName().equals(userName))
            {
                return countries;
            }
        }
        return new ArrayList<Pays>();
    }
}
