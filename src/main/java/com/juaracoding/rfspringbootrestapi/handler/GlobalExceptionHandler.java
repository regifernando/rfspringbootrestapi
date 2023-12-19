package com.juaracoding.rfspringbootrestapi.handler;

import com.juaracoding.rfspringbootrestapi.configuration.OtherConfig;
import com.juaracoding.rfspringbootrestapi.util.LoggingFile;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
/*
	KODE EXCEPTION
	VALIDATION		= 01
	DATA			= 02
	AUTH			= 03
	MEDIA / FILE	= 04
	UNKNOW			= 99
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private List<ApiValidationError> lsSubError = new ArrayList<ApiValidationError>();
    private String [] strExceptionArr = new String[2];

    public GlobalExceptionHandler() {
        strExceptionArr[0] = "GlobalExceptionHandler";
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        lsSubError.clear();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            lsSubError.add(new ApiValidationError(fieldError.getField(),fieldError.getDefaultMessage()));
        }

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, "TIDAK DAPAT DIPROSES",ex,request.getDescription(false),"X-01-001");
        apiError.setSubErrors(lsSubError);
//		return ResponseEntity.unprocessableEntity().body(apiError);
        return new ResponseEntity<Object>(apiError,HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    /*
        salah satu kasus nya jika foreign key nya belum di set data nya di table master (parent)
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {

        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,"DATA TIDAK VALID",ex,request.getDescription(false),"X-02-001"));
    }

    /*
        salah satu kasusnya : simulasikan tabel di delete lalu upload file csv untuk produce error exception UnexpectedRollbackException..
     */
    @ExceptionHandler(UnexpectedRollbackException.class)
    public ResponseEntity<Object> unexpectedRollbackException(UnexpectedRollbackException ex, WebRequest request) {
        strExceptionArr[1] = "unexpectedRollbackException(UnexpectedRollbackException ex, WebRequest request) \n"+RequestCapture.allRequest(request,null);
        LoggingFile.exceptionStringz(strExceptionArr, ex, OtherConfig.getFlagLogging());
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"FLOW GAGAL DI PROSES",ex,request.getDescription(false),"X-02-002"));
    }

//	@ExceptionHandler(ExpiredJwtException.class)
//	public ResponseEntity<Object> expiredJwtException(ExpiredJwtException ex, WebRequest request) {
//		strExceptionArr[1] = "expiredJwtException(ExpiredJwtException ex, WebRequest request) \n"+RequestCapture.allRequest(request,null);
//		LoggingFile.exceptionStringz(strExceptionArr, ex, OtherConfig.getFlagLogging());
//		return buildResponseEntity(new ApiError(HttpStatus.FORBIDDEN,"Token Expired",ex,request.getDescription(false),"X-03-001"));
//	}
//	@ExceptionHandler(InternalAuthenticationServiceException.class)
//	public ResponseEntity<Object> unternalAuthenticationServiceException(InternalAuthenticationServiceException ex, WebRequest request) {
//		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"OTENTIKASI GAGAL",ex,request.getDescription(false),"X-03-002"));
//	}

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<Object> MultipartException(MultipartException ex, WebRequest request) {
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"Konten harus Multipart",ex,request.getDescription(false),"X-04-001"));
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<Object> fileUploadException(FileUploadException ex, WebRequest request) {
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"File Tidak Sesuai",ex,request.getDescription(false),"X-04-002"));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"TIDAK DAPAT DIPROSES",ex,request.getDescription(false),"X-99-001"));
    }
}
