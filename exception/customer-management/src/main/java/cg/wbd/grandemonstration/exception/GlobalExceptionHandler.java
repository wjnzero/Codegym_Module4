package cg.wbd.grandemonstration.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler({ DuplicateEmailException.class})
//    public ResponseEntity<String> handleExceptionMail(Exception ohNo) {
//        ohNo.printStackTrace();
//        return ResponseEntity.status(432).body("DuplicateEmail");
//    }


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleUnwantedException(Exception ohNo) {
//        ohNo.printStackTrace();
//        return ResponseEntity.status(500).body("khong biet loi gi");
//    }
    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/customers/err");
    }
}
