package cg.wbd.grandemonstration.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DuplicateEmailException extends Exception {
    private int code;
    private String message;
}
