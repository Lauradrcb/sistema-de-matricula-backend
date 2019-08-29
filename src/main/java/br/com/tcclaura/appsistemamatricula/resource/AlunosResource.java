package br.com.tcclaura.appsistemamatricula.resource;

import br.com.tcclaura.appsistemamatricula.model.Alunos;
import br.com.tcclaura.appsistemamatricula.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class AlunosResource {

    @Autowired
    AlunosRepository usersRepository;

    @GetMapping(value = "/")
    public String WorkCheck(){ return "BackEnd Working fine!"; }

    @GetMapping(value = "/all")
    public List<Alunos> getAll(){
        System.out.println(usersRepository.findAll());
        return usersRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Alunos> persist(@RequestBody final Alunos user){
        usersRepository.save(user);
        return usersRepository.findAll();
    }

    @PostMapping(value = "/login")
    public String findByName(@RequestBody String queryString,String username, String password){
         Alunos result = usersRepository.findByName(username);
         Boolean userExists = !(result == null);
         if(!userExists){
             System.out.println("1");
             return "{code:1, message:Not registered}";
         }
         else{
             Boolean grantAccess =  password.equals(result.getPassword());
             if(grantAccess){
                 return "{code:2, message:Granted access, user:" + result.getName() + "}";
             }
             else{
                 return "{code:3, message:Wrong password}";
             }
         }
    }
}
