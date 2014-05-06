/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author admin
 */
@ResponseStatus(value = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
public final class InternalServerError extends RuntimeException {
    
}
