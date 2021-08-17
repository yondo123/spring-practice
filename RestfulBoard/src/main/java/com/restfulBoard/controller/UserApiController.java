package com.restfulBoard.controller;

import com.restfulBoard.dto.Response;
import com.restfulBoard.dto.User;
import com.restfulBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Locale;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource errorMessage;

    //회원가입
    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<Response<?>> signup(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            Response<?> error = new Response<>(
                    errorMessage.getMessage(result.getAllErrors().get(0), Locale.getDefault()), false, null);
            return new ResponseEntity<>(error, HttpStatus.OK);
        }else{
            String status;
            status = userService.signup(user);

            if(Objects.equals(status, "S")){
                Response<?> success = new Response<>("success account", true, null);
                return new ResponseEntity<>(success, HttpStatus.OK);
            }else if(Objects.equals(status, "Y")){
                Response<?> existError = new Response<>("success login", true, null);
                return new ResponseEntity<>(existError, HttpStatus.OK);
            }else{
                Response<?> existError = new Response<>("fail login", false, null);
                return new ResponseEntity<>(existError, HttpStatus.OK);
            }
        }
    }
}
