package pres.jeremy.bellatrix.common.util.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pres.jeremy.bellatrix.common.util.constant.ApiConstant;
import pres.jeremy.bellatrix.common.util.support.Result;
import pres.jeremy.bellatrix.common.util.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Slf4j
public abstract class AbstractExceptionsHandler {

    @Autowired
    public HttpServletRequest request;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception ex) {
        log.error("error", ex);
        if (ex instanceof BusinessException) {
            BusinessException exception = (BusinessException) ex;
            Result result = new Result();
            result.setCode(exception.getCode());
            result.setMsg(exception.getMessage());
            return result;
        } else if (ex instanceof MethodArgumentNotValidException) {
            String message = null;
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = exception.getBindingResult();
            if (bindingResult.hasErrors()) {
                FieldError fieldError = bindingResult.getFieldError();
                if (fieldError != null) {
                    message = fieldError.getDefaultMessage();
                }
            }
            return Result.failed(message);
        } else if (ex instanceof BindException) {
            BindException exception = (BindException) ex;
            String message = null;
            BindingResult bindingResult = exception.getBindingResult();
            if (bindingResult.hasErrors()) {
                FieldError fieldError = bindingResult.getFieldError();
                if (fieldError != null) {
                    message = fieldError.getDefaultMessage();
                }
            }
            return Result.failed(message);
        } else if (ex instanceof AccessDeniedException) {
            AccessDeniedException exception = (AccessDeniedException) ex;
            String message = exception.getMessage();
            return Result.failed(message);
        } else {
            Result result = new Result();
            result.setCode(-1);
            result.setMsg(ex.getMessage());
            return result;
        }
    }

    private String buildError(String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(RequestUtil.getRequestIp(request));
        builder.append("]:[");
        builder.append(request.getHeader(ApiConstant.APP_TERMINAL));
        builder.append("/");
        builder.append(request.getHeader(ApiConstant.APP_VERSION));
        builder.append("]:[");
        builder.append(request.getRequestURI());
        builder.append(" ");
        builder.append(request.getMethod());
        builder.append("] ");
        builder.append(msg);
        return builder.toString();
    }

}
